package com.cpm;

import java.util.ArrayList;
import java.util.List;
class Tenant extends User {
    private TenantAgreement currentAgreement;
    private ArrayList<RentReceipt> rentReceipts;
    private List<MaintenanceRequest> maintenanceRequests;

    private ExpenseTracker expenseTracker;



    public Tenant(String username, String password, String name) {
        super(username, password, name);
        this.rentReceipts = new ArrayList<RentReceipt>();
        this.maintenanceRequests = new ArrayList<>();
        this.expenseTracker = new ExpenseTracker();
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
    public List<MaintenanceRequest> getMaintenanceRequests() {
        return maintenanceRequests;
    }


    public MaintenanceRequest createMaintenanceRequest(String requestId, String description) {
        // Check if a maintenance request with the same description already exists
        for (MaintenanceRequest existingRequest : maintenanceRequests) {
            if (existingRequest.getDescription().equals(description)) {
                System.out.println("You cannot have multiple maintenance requests with the same description.");
                return null; // Return null to indicate that the request was not created
            }
        }

        // If no matching description is found, create the maintenance request
        MaintenanceRequest request = new MaintenanceRequest(requestId, description);
        maintenanceRequests.add(request);
        return request;
    }

}
