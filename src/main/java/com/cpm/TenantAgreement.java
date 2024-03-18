package com.cpm;

import java.util.Date;
import java.util.List;

public class TenantAgreement {
    private static int idCounter = 0;
    private int id, amount, duration;
    private Owner owner;
    private Tenant tenant;
    private Unit unit;
    private Date signedOn;

    public TenantAgreement(int amount, int duration, Owner owner, Tenant tenant, Unit unit) {
        this.id = ++idCounter;
        this.amount = amount;
        this.duration = duration;
        this.owner = owner;
        this.tenant = tenant;
        this.unit = unit;
        this.signedOn = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Date getSignedOn() {
        return signedOn;
    }

    public void setSignedOn(Date signedOn) {
        this.signedOn = signedOn;
    }

    // Validation method for OCL 20
    public boolean validateTransfer(List<TenantAgreement> tenantAgreements) {
        for (TenantAgreement agreement : tenantAgreements) {
            if (agreement.getDuration() > 0) {
                boolean hasShorterAgreement = tenantAgreements.stream()
                        .anyMatch(newAgreement -> newAgreement.getDuration() <= agreement.getDuration());
                if (!hasShorterAgreement) {
                    System.out.println("Lease cannot be tranferred to new tenant.");
                    return false; // No new agreement with shorter or equal duration found
                }
            }
        }
        System.out.println("Lease tranferred to new tenant.");
        return true; // All agreements with remaining duration have a corresponding new agreement
    }

    // Method to validate the OCL 28 constraint [updated]
    public boolean validateTenantAgreement() {
        // Check if tenant, unit, and signedOn date are not null
        if (this.tenant == null || this.unit == null || this.signedOn == null) {
            System.out.println("The tenant agreement is invalid.");
            return false;
        }
        
        // Check if the tenant is associated with the property
        if (!this.unit.getTenant().equals(tenant)) {
            System.out.println("The tenant agreement is invalid.");
            return false;
        }

        // All conditions passed, so the constraint is satisfied
        System.out.println("The tenant agreement is valid.");
        return true;
    }

    
}
