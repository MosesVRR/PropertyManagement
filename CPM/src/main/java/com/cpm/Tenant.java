package com.cpm;

import java.util.ArrayList;

class Tenant extends User {
    private TenantAgreement currentAgreement;
    private ArrayList<RentReceipt> rentReceipts;

    public Tenant(String username, String password, String name) {
        super(username, password, name);
        this.rentReceipts = new ArrayList<RentReceipt>();
    }

    public TenantAgreement getCurrentAgreement() {
        return currentAgreement;
    }

    public void setCurrentAgreement(TenantAgreement currentAgreement) {
        this.currentAgreement = currentAgreement;
    }

    public ArrayList<RentReceipt> getRentReceipts() {
        return rentReceipts;
    }

    public RentReceipt addRentReceipt(RentReceipt rentReceipt) {
        this.rentReceipts.add(rentReceipt);
        return rentReceipt;
    }
}
