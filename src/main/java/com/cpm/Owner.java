package com.cpm;

import java.util.ArrayList;
import java.util.List;

class Owner extends User {
    private List<Property> properties;
    private List<TenantAgreement> tenantAgreements = new ArrayList<TenantAgreement>();

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
        TenantAgreement tenantAgreement = new TenantAgreement(amount, duration, tenant, this, unit);
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


}
