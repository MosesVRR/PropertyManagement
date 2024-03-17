package com.cpm;

public class RentReceipt extends Receipt {
    private final TenantAgreement tenantAgreement;
    private Tenant tenant;

    public RentReceipt(Tenant tenant, TenantAgreement tenantAgreement) {
        super();
        this.tenantAgreement = tenantAgreement;
        this.tenant = tenant;
    }

    public TenantAgreement getTenantAgreement() {
        return tenantAgreement;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
