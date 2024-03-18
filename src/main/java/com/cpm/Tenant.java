package com.cpm;

import java.util.ArrayList;
import java.util.List;

class Tenant extends User {
    private TenantAgreement currentAgreement;
    private ArrayList<RentReceipt> rentReceipts;
    private List<MaintenanceRequest> maintenanceRequests;

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

    // Validation method for OCL 21
    public boolean validateParkingDuration(Unit unit) {
        List<ParkingSpot> parkingSpots = unit.getParkingSpots();
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getParkingDuration() != -1) {
                System.out.println("Tenant cannot park indefinitely.");
                return false; // Tenant cannot park indefinitely
            }
        }
        System.out.println("Tenant can park indefinitely.");
        return true; // All parking spots have indefinite parking duration
    }

    // Method to validate OCL 25
    public boolean canGenerateMaintenanceRequest(String description) {
        // Check if any existing maintenance request has the same description
        for (MaintenanceRequest request : maintenanceRequests) {
            if (request.getDescription().equals(description)) {
                System.out.println("Cannot generate request with give description. It already exists.");
                return false; // Description already exists, can't generate new request
            }
        }
        System.out.println("Added description.");
        return true; // Description doesn't exist, can generate new request
    }
    
    // Method to generate a new maintenance request
    public void generateMaintenanceRequest(String requestID, String description) {
        if (canGenerateMaintenanceRequest(description)) {
            MaintenanceRequest newRequest = new MaintenanceRequest(requestID, description);
            maintenanceRequests.add(newRequest);
            // Other necessary operations (e.g., adding to database, notifying staff, etc.)
        } else {
            System.out.println("Cannot generate maintenance request with duplicate description.");
        }
    }
}
