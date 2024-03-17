package com.cpm;

import java.util.Date;

public class TenantAgreement {
    private static int idCounter = 0;
    private int id, amount, duration;
    private User owner, tenant;
    private Unit unit;
    private Date signedOn;

    public TenantAgreement(int amount, int duration, User owner, User tenant, Unit unit) {
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

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getTenant() {
        return tenant;
    }

    public void setTenant(User tenant) {
        this.tenant = tenant;
    }

    public Date getSignedOn() {
        return signedOn;
    }

    public void setSignedOn(Date signedOn) {
        this.signedOn = signedOn;
    }
}
