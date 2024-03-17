import com.cpm.Property;
import com.cpm.Unit;
import com.cpm.User;
import com.cpm.UnitType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PropertyTest {

    public Property property;
    public User owner;

    @BeforeEach
    void setUp() {
        owner = new User("Narun", "kumar", "narun");
        property = new Property("Test Property", "123 Test St", owner);
    }

    @Test
    void testAddUnit() {
        property.addUnit(101, 1, UnitType.APARTMENT);
        List<Unit> units = property.getUnits();
        assertNotNull(units);
        assertEquals(1, units.size());

        Unit unit = units.get(0);
        assertEquals(101, unit.getUnitNo());
        assertEquals(1, unit.getFloorNo());
        assertEquals(UnitType.APARTMENT, unit.getType());
    }

    @Test
    void testSetName() {
        property.setName("New Property Name");
        assertEquals("New Property Name", property.getName());
    }

    @Test
    void testSetAddress() {
        property.setAddress("456 New St");
        assertEquals("456 New St", property.getAddress());
    }

    @Test
    void testSetOwnedBy() {
        User newOwner = new User("Narun", "kumar", "narun");
        property.setOwnedBy(newOwner);
    }
}