package com.cpm;

class MaintenanceStaff extends User {

    public MaintenanceStaff(String email, String password, String name) {
        super(email, password, name);
        //TODO Auto-generated constructor stub
    }

    public void fixingIssue() {
        // Implementation
    }

    //Method to validate OCL 25
    public void changeMaintenanceStatus(MaintenanceStatus newStatus, MaintenanceRequest request) {
        if (newStatus == MaintenanceStatus.COMPLETED && (request.getDescription() == null || request.getDescription().isEmpty())) {
            System.out.println("Cannot mark request as completed without a description.");
        } else {
            request.setStatus(newStatus);
            // Other necessary operations (e.g., updating database, notifying staff, etc.)
        }
    }
    
}
