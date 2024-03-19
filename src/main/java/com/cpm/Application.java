package com.cpm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Application {
    List<User> users = new ArrayList<User>();
    List<Property> properties = new ArrayList<Property>();
    User activeUser;

    public void initializeUsers() {
        UserInitializer.initializeUsers(this.users, this.properties);
    }



    public void menu() {
        if (this.activeUser == null) {
            this.userMenu();
        } else {
            if (this.activeUser instanceof Owner) {
                this.ownerMenu();
            } else if (this.activeUser instanceof Tenant) {
                this.tenantMenu();
            } else if (this.activeUser instanceof Admin) {
                this.adminMenu();
            } else {
                this.visitorMenu();
            }
        }
    }

    public void userMenu() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("Command > ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                this.login();
                break;
            case 2:
                this.register();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Admin menu");
        System.out.println("1. List all Users");
        System.out.println("2. List all Tenants");
        System.out.println("3. List all Properties");
        System.out.println("9. Logout");
        System.out.print("Command > ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                for (User user : this.users) {
                    System.out.println("| Id: " + user.getId() + "| User: " + user.getName() + " |");
                }
                break;
            case 2:
                for (User user : this.users) {
                    if (user instanceof Tenant) {
                        System.out.println("| Id: " + user.getId() + "| User: " + user.getName() + " |");
                    }
                }
                break;
            case 3:
                for (Property property : this.properties) {
                    System.out.println("| Id: " + property.getId() + "| name: " + property.getName() + " |");
                }
                break;
            case 9:
                activeUser = null;
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    public void ownerMenu() {
        System.out.println();
        Owner owner = (Owner) this.activeUser;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Owner Menu:");
        System.out.println("1. Add property \n" +
                "2. See all properties \n" +
                "3. Add Unit to property \n" +
                "4. Create tenant agreement \n" +
                "5. Show all tenant agreements \n" +
                "6. Adding parking spots\n" +
                "7. List All Tenants\n"+
                "9. Logout");

        System.out.print("Command > ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println();
                System.out.print("Property name: ");
                String name = scanner.next();
                System.out.print("Property address: ");
                String address = scanner.next();
                Property newProperty = owner.addProperty(name, address);
                properties.add(newProperty);
                break;
            case 2:
                System.out.println();
                owner.showAllProperties();
                break;
            case 3:
                System.out.println();
                System.out.println("Add Unit");
                owner.showAllProperties();
                System.out.println("Select property id");
                int id = scanner.nextInt();
                Property activeProperty = null;
                for (Property property : owner.getProperties()) {
                    if (property.getId() == id) {
                        activeProperty = property;
                    }
                }
                if (activeProperty == null) {
                    break;
                }

                System.out.print("Unit No : ");
                int unitNo = scanner.nextInt();

                // Check if the unitNo is unique within the property
                boolean isUniqueUnitNo = true;
                for (Unit unit : activeProperty.getUnits()) {
                    if (unit.getUnitNo() == unitNo) {
                        isUniqueUnitNo = false;
                        break;
                    }
                }

                if (!isUniqueUnitNo) {
                    System.out.println("This Unit Number already exists in the Property!. Please make it Unique.");
                    break;
                }

                System.out.print("Floor No : ");
                int floorNo = scanner.nextInt();
                System.out.print(" Unit Type: ");
                for (int i = 0; i < UnitType.values().length; i += 1) {
                    System.out.print(i + 1 + ". " + UnitType.values()[i] + " ");
                }
                int type = scanner.nextInt();
                activeProperty.addUnit(unitNo, floorNo, UnitType.values()[type - 1]);
                break;
            case 4:
                owner.showAllProperties();
                System.out.println("Select property id");
                int propertyId = scanner.nextInt();
                Property propertyAgreement = null;
                for (Property property : owner.getProperties()) {
                    if (property.getId() == propertyId) {
                        propertyAgreement = property;
                    }
                }
                if (propertyAgreement == null) {
                    break;
                }
                propertyAgreement.showUnits();
                System.out.println("Select unit id");
                int unitId = scanner.nextInt();
                Unit unitAgreement = null;
                for (Unit unit : propertyAgreement.getUnits()) {
                    if (unit.getId() == unitId) {
                        unitAgreement = unit;
                    }
                }
                User tenant = null;
                for (User user : this.users) {
                    if (user instanceof Tenant) {
                        System.out.println("| Id: " + user.getId() + " | Name: " + user.getName() + " | Email: " + user.getEmail());
                    }
                }
                System.out.println("User: ");
                int userId = scanner.nextInt();
                for (User user : users) {
                    if (user.getId() == userId) {
                        tenant = user;
                        break;
                    }
                }
                if (tenant == null) {
                    break;
                }


                System.out.print("Amount : $ ");
                int amount = scanner.nextInt();
                System.out.println();
                System.out.print("Duration (in months):");
                int duration = scanner.nextInt();

                owner.createAgreement(amount, duration, (Tenant) tenant, unitAgreement);
                System.out.println("Tenant agreement created");
                break;
            case 5:
                System.out.println("Agreements");
                for (TenantAgreement agreement : owner.getTenantAgreements()) {
                    System.out.println("| Id: " + agreement.getId() + " | Duration: " + agreement.getDuration() + "| Amount: $" + agreement.getAmount() + " |");
                }
                break;
            case 6:
                System.out.println("Parkings");
                owner.showAllProperties();
                System.out.println("Select property id");
                int propertyPropertyId = scanner.nextInt();
                Property parkingProperty = null;
                for (Property property : owner.getProperties()) {
                    if (property.getId() == propertyPropertyId) {
                        parkingProperty = property;
                    }
                }
                if (parkingProperty == null) {
                    break;
                }
                System.out.println("parking price: ");
                int price = scanner.nextInt();
                parkingProperty.addParking(price);
                break;

            case 7:
                for (User user : this.users) {
                    if (user instanceof Tenant) {
                        System.out.println("| Id: " + user.getId() + "| User: " + user.getName() + " |");
                    }
                }
                break;
            case 9:
                activeUser = null;
                break;
            default:
                System.out.println("Invalid command");
        }
    }

    public void tenantMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tenant menu");
        System.out.println();
        System.out.println("1. Get My Tenant Agreement");
        System.out.println("2. Pay Rent Receipt");
        System.out.println("3. Get All Receipts");
        System.out.println("4. Create Maintenance Request");
        System.out.println("5. Add an Expense");
        System.out.println("6. View Expenses");
        System.out.println("9. Logout");

        System.out.println("Command > ");

        int choice = scanner.nextInt();
        Tenant tenant = (Tenant) activeUser;
        TenantAgreement tenantAgreement = tenant.getCurrentAgreement();
        // Create an ExpenseTracker object
        ExpenseTracker expenseTracker = new ExpenseTracker();
        switch (choice) {
            case 1:
                System.out.println("| Id: " + tenantAgreement.getId() + " | " + "Duration in Months: "+tenantAgreement.getDuration() + " |" + "Rent Amount Each Month: "+ tenantAgreement.getAmount());
                break;
            case 2:
                // Check if the number of issued receipts is less than the duration of the agreement
                if (tenant.getRentReceipts().size() < tenantAgreement.getDuration()) {
                    RentReceipt rentReceipt = new RentReceipt(tenant, tenantAgreement);
                    tenant.addRentReceipt(rentReceipt);
                    System.out.print(tenantAgreement.getDuration() +" Rent receipts issued for the duration of " + tenantAgreement.getDuration() + " months successfully.");
                    System.out.println();

                } else {
                    System.out.println("You have already been issued rent receipts for all months in the agreement duration.");
                }
                break;
            case 3:
                for (RentReceipt receipt : tenant.getRentReceipts()) {
                    System.out.println("| Id: " + receipt.getId() + " | Tenant" + receipt.getTenant().getName() + " |");
                }
                break;
            case 4:
                System.out.println("Enter Maintenance Request ID: ");
                String requestId = scanner.next();
                System.out.println("Enter Maintenance Request Description: ");
                scanner.nextLine(); // Consume the newline character
                String description = scanner.nextLine();

                tenant.createMaintenanceRequest(requestId, description);

                System.out.println("Maintenance Request created successfully.");
                break;


            case 5:
                System.out.println("Enter Expense Description: ");
                scanner.nextLine(); // Consume the newline character
                String expenseDescription = scanner.nextLine();
                System.out.println("Enter Expense Amount: ");
                int expenseAmount = scanner.nextInt();

                // Add the expense using the addExpense() method
                expenseTracker.addExpense(expenseAmount, expenseDescription);
                break;

            case 6:
                System.out.println("Expenses:");
                List<String> expenseDetails = expenseTracker.getAllExpenseDetails();

                for (String detail : expenseDetails) {
                    System.out.println(detail);
                }

                break;


            case 9:
                this.activeUser = null;
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    public void visitorMenu() {
        Visitor visitor = (Visitor) activeUser;
        System.out.println("Visitor menu");
        System.out.println();
        System.out.println("1. Add vehicle");
        System.out.println("2. Park my vehicle in property");
        System.out.println("3. Empty my vehicle");
        System.out.println("4. Get all Vehicle receipts");
        System.out.println("5. Show information of vehicles I own");
        System.out.println("6. Reserve Parking Spot");
        System.out.println("9. Logout");
        System.out.print("Command > ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        Property visitorProperty = null;

        switch (choice) {
            case 1:
                System.out.print("VehicleNo: ");
                String vehicleNo = scanner.next();

                if (vehicleNo.equals("1") || vehicleNo.equals("2") || vehicleNo.equals("3") || vehicleNo.equals("4")) {
                    System.out.println("Vehicle number already exists!. Please choose a unique one.");
                    break;
                }

                System.out.println("Type: 1. SUV 2. Sedan 3. Hatchback");
                System.out.println("Type: ");
                int vehicleTypeChoice = scanner.nextInt();
                String vehicleTypeStr = "";
                if (vehicleTypeChoice == 1) {
                    vehicleTypeStr = "SUV";
                } else if (vehicleTypeChoice == 2) {
                    vehicleTypeStr = "SEDAN";
                } else {
                    vehicleTypeStr = "HATCHBACK";
                }

                Vehicle vehicle = new Vehicle(vehicleNo, vehicleTypeStr);
                visitor.setVehicle(vehicle);
                System.out.println("| Vehicle Added |");
                break;
            case 2:
                if (visitor.getVehicle() != null && visitor.getVehicle().getParkingSpot() != null) {
                    System.out.println("You can only park one vehicle at a time.");
                } else {
                    System.out.println("Select Property");
                    for (Property property : properties) {
                        System.out.println("| ID: " + property.getId() + " | Name: " + property.getName() + " |");
                    }
                    int id = scanner.nextInt();
                    for (Property property : properties) {
                        if (id == property.getId()) {
                            visitorProperty = property;
                        } else {
                            System.out.println("| Invalid property id |");
                        }
                    }
                    System.out.println("Parking Spots");
                    if (visitorProperty != null && visitorProperty.getParkingSpots() != null) {
                        for (ParkingSpot parkingSpot : visitorProperty.getParkingSpots()) {
                            System.out.println("| Id: " + parkingSpot.getId() + " | Status: " + parkingSpot.getStatus() + " | Price: " + parkingSpot.getPrice() + " | Size: " + parkingSpot.getSize() + " |");
                        }
                    } else {
                        System.out.println("| No parking spots available |");
                    }
                    System.out.print("Select parking spot: ");
                    int parkingSpotId = scanner.nextInt();
                    assert visitorProperty != null;
                    for (ParkingSpot parkingSpot : visitorProperty.getParkingSpots()) {
                        if (parkingSpot.getId() == parkingSpotId) {
                            parkingSpot.setVehicle(visitor.getVehicle());
                            visitor.getVehicle().setParkingSpot(parkingSpot);
                        }
                    }
                }

                break;
            case 3:
                System.out.println("Empty your vehicle parking spot");
                boolean emptyChoice = scanner.nextBoolean();

                if (!emptyChoice) {
                    ParkingReceipt receipt = new ParkingReceipt(visitor.getVehicle().getParkingSpot(), visitor, new Date().compareTo(visitor.getVehicle().getParkingSpot().getParkedOn()));
                    visitor.getVehicle().getParkingSpot().setVehicle(null);
                    visitor.getVehicle().setParkingSpot(null);
                    visitor.getVehicle().getParkingSpot().setStatus(SlotStatus.AVAILABLE);
                    visitor.addParkingReceipt(receipt);
                }
                break;


            case 6:
                System.out.println("As a visitor, you don't have authorisation to reserve a Parking Spot!");
                break;

            case 9:
                activeUser = null;
                break;
            default:
                System.out.println("Invalid input");
        }
    }


    public void login() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // search in Users[]
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                if (user.getEmail().equals(email) || user.getPassword().equals(password)) {
                    this.activeUser = user;
                    System.out.println("Login Successful ");
                }
            }
        }
        if (this.activeUser == null) {
            System.out.println("Login failed");
        }
    }

    public void register() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String email = scanner.nextLine();

        if (isUsernameUnique(email)) {
            System.out.print("Password: ");
            String password = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.println("1. Admin 2. Tenant 3. Owner 4. Visitor");
            System.out.println("Role: ");
            int role = scanner.nextInt();
            switch (role) {
                case 1:
                    Admin newAdmin = new Admin(email, password, name);
                    users.add(newAdmin);
                    break;
                case 2:
                    Tenant newTenant = new Tenant(email, password, name);
                    users.add(newTenant);
                    break;
                case 3:
                    Owner newOwner = new Owner(email, password, name);
                    users.add(newOwner);
                    break;
                case 4:
                    Visitor newVisitor = new Visitor(email, password, name);
                    users.add(newVisitor);
                    break;
                case 5:
                    System.out.println("Invalid Role");
            }
            System.out.println("User is registered");
        }
        else {
            System.out.println("Username '" + email + "' already exists. Please choose a different username.");
        }
        }

    private boolean isUsernameUnique(String username) {
        for (User user : users) {
            if (user.getEmail().equals(username)) {
                return false; // Username already exists
            }
        }
        return true; // Username is unique
    }



}
