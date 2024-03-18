package com.cpm;
import java.util.List;
import java.util.ArrayList;
public class UserInitializer {
    public static void initializeUsers(List<User> users, List<Property> properties) {
        Admin admin = new Admin("admin", "admin123", "Admin1");
        users.add(admin);


        Tenant tenant1 = new Tenant("tenant1", "tenant123", "Tenant1");
        users.add(tenant1);
        Tenant tenant2 = new Tenant("tenant2", "tenant123", "Tenant2");
        users.add(tenant2);
        Tenant tenant3 = new Tenant("tenant3", "tenant123", "Tenant3");
        users.add(tenant3);
        Tenant tenant4 = new Tenant("tenant4", "tenant123", "Tenant4");
        users.add(tenant4);
        Tenant tenant5 = new Tenant("tenant5", "tenant123", "Tenant5");
        users.add(tenant5);
        Tenant tenant6 = new Tenant("tenant6", "tenant123", "Tenant6");
        users.add(tenant6);


        Owner owner = new Owner("owner", "owner123", "Owner1");
        users.add(owner);


        Visitor visitor1 = new Visitor("visitor1", "visitor123", "Visitor1");
        users.add(visitor1);
        Vehicle vehicle1 = new Vehicle("1", "SUV");
        visitor1.setVehicle(vehicle1);

        Visitor visitor2 = new Visitor("visitor2", "visitor123", "Visitor2");
        users.add(visitor2);
        Vehicle vehicle2 = new Vehicle("2", "SEDAN");
        visitor2.setVehicle(vehicle2);

        Visitor visitor3 = new Visitor("visitor3", "visitor123", "Visitor3");
        users.add(visitor3);
        Vehicle vehicle3 = new Vehicle("3", "HATCHBACK");
        Vehicle vehicle4 = new Vehicle("4", "HATCHBACK");
        visitor3.setVehicle(vehicle3);
        visitor3.setVehicle(vehicle4);


        Property newProperty = owner.addProperty("Concordia", "Downtown");
        properties.add(newProperty);

        newProperty.addUnit(101, 1, UnitType.STUDIO);
        newProperty.addUnit(102, 1, UnitType.CONDO);
        newProperty.addUnit(201, 1, UnitType.STUDIO);
        newProperty.addUnit(301, 1, UnitType.DUPLEX);
        newProperty.addUnit(302, 1, UnitType.DUPLEX);
        newProperty.addUnit(401, 1, UnitType.PENTHOUSE);






        Property propertyAgreement = null;
        for (Property property : owner.getProperties()) {
            if (property.getId() == 1) {
                propertyAgreement = property;
            }
        }
        propertyAgreement.showUnits();
        int unitId = 101;
        Unit unitAgreement = null;
        for (Unit unit : propertyAgreement.getUnits()) {
            if (unit.getId() == unitId) {
                unitAgreement = unit;
            }
        }
        User tenant = null;
        System.out.println("User: ");
        int userId = 1;
        for (User user : users) {
            if (user.getId() == userId) {
                tenant = user;
                break;
            }
        }


        //Creating Rent Agreement and assigning each tenant 1 unit
        owner.createAgreement(1000, 12, (Tenant) users.get(1), getUnitByUnitIdAndPropertyId(101, 2, 1, owner.getProperties(), users));
        owner.createAgreement(1250, 6, (Tenant) users.get(2), getUnitByUnitIdAndPropertyId(102, 3, 1, owner.getProperties(), users));
        owner.createAgreement(1000, 12, (Tenant) users.get(3), getUnitByUnitIdAndPropertyId(201, 4, 1, owner.getProperties(), users));
        owner.createAgreement(1500, 8, (Tenant) users.get(4), getUnitByUnitIdAndPropertyId(301, 5, 1, owner.getProperties(), users));
        owner.createAgreement(1500, 12, (Tenant) users.get(5), getUnitByUnitIdAndPropertyId(302, 6, 1, owner.getProperties(), users));
        owner.createAgreement(2000, 6, (Tenant) users.get(6), getUnitByUnitIdAndPropertyId(401, 7, 1, owner.getProperties(), users));

        //Adding Parking Spots to Property1
        newProperty.addParking(50);
        newProperty.addParking(100);
        newProperty.addParking(80);
        newProperty.addParking(50);
        newProperty.addParking(80);
        newProperty.addParking(100);
        newProperty.addParking(50);
        newProperty.addParking(80);
        newProperty.addParking(100);
        newProperty.addParking(50);


    }





    //Helper Function to get the last parameter in owner.createAgreement
    public static Unit getUnitByUnitIdAndPropertyId(int unitId, int userId, int propertyId, List<Property> properties, List<User> users) {
        Property propertyAgreement = null;
        for (Property property : properties) {
            if (property.getId() == propertyId) {
                propertyAgreement = property;
                break;
            }
        }
        if (propertyAgreement == null) {
            return null; // Property not found
        }

        Unit unitAgreement = null;
        for (Unit unit : propertyAgreement.getUnits()) {
            if (unit.getId() == unitId) {
                unitAgreement = unit;
                break;
            }
        }
        if (unitAgreement == null) {
            return null; // Unit not found
        }

        User tenant = null;
        for (User user : users) {
            if (user.getId() == userId) {
                tenant = user;
                break;
            }
        }
        if (tenant == null) {
            return null; // User not found
        }

        return unitAgreement;
    }


}
