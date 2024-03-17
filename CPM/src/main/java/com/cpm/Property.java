package com.cpm;

import java.util.ArrayList;
import java.util.List;

public class Property {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String address;
    private User ownedBy;

    private List<Unit> units = new ArrayList<Unit>();

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    private List<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();

    public Property(String name, String address, User ownedBy) {
        this.id = ++idCounter;
        this.name = name;
        this.address = address;
        this.ownedBy = ownedBy;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public void showUnits() {
        System.out.println("Units: ");
        for (Unit unit : this.units) {
            System.out.println("| Id: " + unit.getId() + " | Unit No" + unit.getUnitNo() + " | Type: " + unit.getType());
        }
    }

    public void addUnit(int unitNo, int floorNo, UnitType unitType) {
        units.add(new Unit(unitNo, floorNo, unitType));
    }

    public void addParking(int price) {
        ParkingSpot parking = new ParkingSpot(price, this);
        this.parkingSpots.add(parking);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(User ownedBy) {
        this.ownedBy = ownedBy;
    }
}
