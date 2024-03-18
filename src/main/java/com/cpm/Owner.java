package com.cpm;

import java.util.ArrayList;
import java.util.List;

class Owner extends User {
    private List<Property> properties;
    private List<TenantAgreement> tenantAgreements = new ArrayList<TenantAgreement>();
    private List<Tenant> tenants;

    public Owner(String username, String password, String name) {
        super(username, password, name);
        properties = new ArrayList<Property>();
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public Property addProperty(String name, String address) {
        Property property = new Property(name, address, this);
        properties.add(property);
        System.out.println("Property added");
        return property;
    }

    public void showAllProperties() {
        System.out.println("------------------------------");
        System.out.println("Properties: ");
        for (Property property : properties) {
            System.out.println("| Id: " + property.getId() + " | Name: " + property.getName() + " | Address: " + property.getAddress() + " | No of Units: " + property.getUnits().size() + " | Available Parking: " + property.getParkingSpots().size());
        }
        System.out.println("------------------------------");
    }

    public void createAgreement(int amount, int duration, Tenant tenant, Unit unit) {
        TenantAgreement tenantAgreement = new TenantAgreement(amount, duration, this, tenant, unit);
        this.tenantAgreements.add(tenantAgreement);
        tenant.setCurrentAgreement(tenantAgreement);
    }

    public void removeProperty(int id) {
        System.out.println("remove property");
    }
    public List<TenantAgreement> getTenantAgreements() {
        return tenantAgreements;
    }

    public void setTenantAgreements(List<TenantAgreement> tenantAgreements) {
        this.tenantAgreements = tenantAgreements;
    }

    // Method to validate the OCL 27 constraint
    public boolean validateTenantAgreements() {
        // Check if the number of tenant agreements equals the number of tenants
        System.out.println();
        return tenantAgreements.size() == tenants.size();
    }

    // Method to validate the OCL 26 constraint
    public boolean validateRentReceipts() {
        for (TenantAgreement ta : tenantAgreements) {
            if (ta.getTenant().getRentReceipts().size() > ta.getDuration()) {
                System.out.println("Invalid number of rent receipts owned.");
                return false; // Number of rent receipts exceeds duration
            }
        }
        System.out.println("Valid number of rent receipts owned.");
        return true; // All agreements satisfy the constraint
    }
}
