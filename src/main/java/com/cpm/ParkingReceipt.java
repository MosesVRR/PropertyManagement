package com.cpm;

public class ParkingReceipt extends Receipt {
    private ParkingSpot parkingSpot;
    private int duration;
    private Vehicle vehicle;

    ParkingReceipt(ParkingSpot parkingSpot, Visitor parkedBy, int duration) {
        super(parkedBy);
        this.parkingSpot = parkingSpot;
        this.duration = duration;
        this.vehicle = parkedBy.getVehicle();
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
