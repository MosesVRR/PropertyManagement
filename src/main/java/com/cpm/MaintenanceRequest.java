package com.cpm;

public class MaintenanceRequest {
    private String requestId;
    private String description;
    private MaintenanceStatus status;
    private MaintenanceStaff assignedTo;

    // Constructor
    public MaintenanceRequest(String requestId, String description) {
        this.requestId = requestId;
        this.description = description;
        this.status = MaintenanceStatus.ONHOLD; // Initial status is set to Pending
    }

    // Getters and setters
    public String getDescription(){
        return this.description;
    }

    public MaintenanceStaff getAssignedTo() {
        return this.assignedTo;
    }

    public void setAssignedTo(MaintenanceStaff assignedTo) {
        this.assignedTo = assignedTo;
    }

    public MaintenanceStatus getStatus() {
        return this.status;
    }

    public void setStatus(MaintenanceStatus status) {
        this.status = status;
    }

    // Method to check the OCL 29 constraint
    public boolean isAssignedAndPending() {
        System.out.println(this.assignedTo + "has been assigned to a request.");
        return this.assignedTo != null && this.status == MaintenanceStatus.PENDING;
    }
}