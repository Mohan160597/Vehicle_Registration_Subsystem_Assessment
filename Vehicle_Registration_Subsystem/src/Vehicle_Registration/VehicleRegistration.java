package Vehicle_Registration;

//Interface defining operations related to vehicle registration
public interface VehicleRegistration {
 Vehicle registerNewVehicle(String make, String model, int yearOfManufacture, User owner);
 Vehicle viewRegisteredVehicle(String registrationNumber);
 void updateVehicleDetails(String registrationNumber, Vehicle updatedVehicle);
 void deleteVehicle(String registrationNumber);
 void renewVehicleRegistration(String registrationNumber);
 void sendExpirationAlert(String registrationNumber);
 void trackRegistrationStatus(String registrationNumber);
 void viewAllRegisteredVehicles();
}

