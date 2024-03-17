package com.cpm;

public class Unit {
    private static int idCounter = 0;
    private int id, unitNo, floorNo;
    private UnitType type;
    private Tenant tenant;
//    private parkingSpot;

    Unit(int unitNo, int floorNo, UnitType type) {
        this.id = ++idCounter;
        this.unitNo = unitNo;
        this.floorNo = floorNo;
        this.type = type;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Unit.idCounter = idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(int unitNo) {
        this.unitNo = unitNo;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public UnitType getType() {
        return type;
    }

    public void setType(UnitType type) {
        this.type = type;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
