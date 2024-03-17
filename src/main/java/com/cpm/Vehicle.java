package com.cpm;

class Vehicle {
    private static int idCounter = 0;
    private int id;

    private String vehicleNo;
    private VehicleType type;
    private ParkingSpot parkingSpot;

    public Vehicle(String vehicleId, String type) {
        this.id = ++idCounter;
        this.type = VehicleType.valueOf(type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
