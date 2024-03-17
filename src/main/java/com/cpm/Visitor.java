package com.cpm;

import java.util.ArrayList;
import java.util.List;

class Visitor extends User {
    private Vehicle vehicle;
    private List<ParkingReceipt> receiptList;

    public Visitor(String username, String password, String name) {
        super(username, password, name);
        receiptList = new ArrayList<ParkingReceipt>();
    }

    public List<ParkingReceipt> addParkingReceipt(ParkingReceipt parkingReceipt) {
        receiptList.add(parkingReceipt);
        return receiptList;
    }

    public void setParkingReceiptList(List<ParkingReceipt> receiptList) {
        this.receiptList = receiptList;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
