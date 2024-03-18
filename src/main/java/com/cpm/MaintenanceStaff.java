package com.cpm;

class MaintenanceStaff extends User {

    public MaintenanceStaff(String email, String password, String name) {
        super(email, password, name);
        //TODO Auto-generated constructor stub
    }

    public void fixingIssue() {
        // Implementation
    }

    //Method to validate OCL 25 and OCL 24
    public void changeMaintenanceStatus(MaintenanceStatus newStatus, MaintenanceRequest request) {
        if (newStatus == MaintenanceStatus.COMPLETED && (request.getDescription() == null || request.getDescription().isEmpty())) {
            System.out.println("Cannot mark request as completed without a description.");
        } else if(newStatus == MaintenanceStatus.PENDING && request.getAssignedTo() == null){
            System.out.println("Cannot set status to PENDING without assigning to a staff member.");
        } 
        else{
            request.setStatus(newStatus);
            System.out.println("Set status succesfully");
            // Other necessary operations (e.g., updating database, notifying staff, etc.)
        }
    }
    
}
