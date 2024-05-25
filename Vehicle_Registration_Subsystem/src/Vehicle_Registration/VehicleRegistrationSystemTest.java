package Vehicle_Registration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class VehicleRegistrationSystemTest {

    private VehicleRegistrationSystem system;
    private User testUser;

    @BeforeEach
    public void setUp() {
        system = VehicleRegistrationSystem.getInstance();
        testUser = new User("U001", "John Doe", "123 Main St", "555-1234");
    }

    @Test
    public void testRegisterNewVehicle() {
        Vehicle vehicle = system.registerNewVehicle("Toyota", "Corolla", 2020, testUser);
        assertNotNull(vehicle.getRegistrationNumber());
        assertEquals("Toyota", vehicle.getMake());
        assertEquals("Corolla", vehicle.getModel());
        assertEquals(2020, vehicle.getYearOfManufacture());
        assertEquals(testUser, vehicle.getOwner());
    }

    @Test
    public void testViewRegisteredVehicle() {
        Vehicle registeredVehicle = system.registerNewVehicle("Honda", "Civic", 2019, testUser);
        Vehicle vehicle = system.viewRegisteredVehicle(registeredVehicle.getRegistrationNumber());
        assertNotNull(vehicle);
        assertEquals("Honda", vehicle.getMake());
        assertEquals("Civic", vehicle.getModel());
        assertEquals(2019, vehicle.getYearOfManufacture());
        assertEquals(testUser, vehicle.getOwner());
    }

    @Test
    public void testUpdateVehicleDetails() {
        Vehicle registeredVehicle = system.registerNewVehicle("Ford", "Focus", 2018, testUser);
        String registrationNumber = registeredVehicle.getRegistrationNumber();
        registeredVehicle.setMake("FordUpdated");
        registeredVehicle.setModel("FocusUpdated");
        registeredVehicle.setYearOfManufacture(2021);
        system.updateVehicleDetails(registrationNumber, registeredVehicle);

        Vehicle updatedVehicle = system.viewRegisteredVehicle(registrationNumber);
        assertNotNull(updatedVehicle);
        assertEquals("FordUpdated", updatedVehicle.getMake());
        assertEquals("FocusUpdated", updatedVehicle.getModel());
        assertEquals(2021, updatedVehicle.getYearOfManufacture());
    }

    @Test
    public void testDeleteVehicle() {
        Vehicle registeredVehicle = system.registerNewVehicle("Nissan", "Altima", 2017, testUser);
        String registrationNumber = registeredVehicle.getRegistrationNumber();
        system.deleteVehicle(registrationNumber);

        Vehicle deletedVehicle = system.viewRegisteredVehicle(registrationNumber);
        assertNull(deletedVehicle);
    }

    @Test
    public void testRenewVehicleRegistration() {
        Vehicle registeredVehicle = system.registerNewVehicle("Mazda", "3", 2016, testUser);
        String registrationNumber = registeredVehicle.getRegistrationNumber();
        system.renewVehicleRegistration(registrationNumber);

        RegistrationCertificate certificate = system.getCertificates().get(registrationNumber);
        assertNotNull(certificate);
        Date currentDate = new Date();
        assertTrue(certificate.getExpiryDate().after(currentDate));
    }
}
