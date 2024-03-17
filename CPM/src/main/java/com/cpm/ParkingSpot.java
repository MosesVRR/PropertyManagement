package com.cpm;

import java.util.Date;

class ParkingSpot {
    private static int idCounter = 0;
    private int id;
    private SlotStatus status;
    private ParkingSize size;

    private Vehicle vehicle;
    int price;
    private Property property;
    private Unit associateUnit;
    private final Date parkedOn;


    public ParkingSpot(int price, Property property) {
        this.id = ++idCounter;
        this.price = price;
        this.property = property;
        this.parkedOn = new Date();
    }

    public Date getParkedOn() {
        return parkedOn;
    }


    public ParkingSpot(int price, Property property, Unit unit) {
        this.id = ++idCounter;
        this.price = price;
        this.property = property;
        this.associateUnit = unit;
        this.parkedOn = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SlotStatus getStatus() {
        return status;
    }

    public void setStatus(SlotStatus status) {
        this.status = status;
    }

    public ParkingSize getSize() {
        return size;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Unit getAssociateUnit() {
        return associateUnit;
    }

    public void setAssociateUnit(Unit associateUnit) {
        this.associateUnit = associateUnit;
    }

    public void setSize(ParkingSize size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

}
