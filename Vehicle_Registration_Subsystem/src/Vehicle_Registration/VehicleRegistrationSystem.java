package Vehicle_Registration;
import java.io.*;
import java.util.*;

// Class implementing the vehicle registration system using Singleton and State patterns
public class VehicleRegistrationSystem implements VehicleRegistration {
    private Map<String, Vehicle> vehicles; // Map to store vehicles with their registration numbers
    private Map<String, RegistrationCertificate> certificates; // Map to store certificates with registration numbers
    private static final String VEHICLES_FILE = "vehicles.dat"; // File to store vehicle data
    private static final String CERTIFICATES_FILE = "certificates.dat"; // File to store certificate data
    private static VehicleRegistrationSystem instance; // Singleton instance

    // Private constructor to prevent instantiation from outside
    private VehicleRegistrationSystem() {
        vehicles = new HashMap<>();
        certificates = new HashMap<>();
        loadData(); // Load existing data from files
    }

    // Singleton instance getter
    public static synchronized VehicleRegistrationSystem getInstance() {
        if (instance == null) {
            instance = new VehicleRegistrationSystem();
        }
        return instance;
    }

    // Load data from files
    @SuppressWarnings("unchecked")
    private void loadData() {
        try (ObjectInputStream vehicleInputStream = new ObjectInputStream(new FileInputStream(VEHICLES_FILE))) {
            vehicles = (HashMap<String, Vehicle>) vehicleInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Vehicles file not found. Starting with an empty list.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream certificateInputStream = new ObjectInputStream(new FileInputStream(CERTIFICATES_FILE))) {
            certificates = (HashMap<String, RegistrationCertificate>) certificateInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Certificates file not found. Starting with an empty list.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Vehicle registerNewVehicle(String make, String model, int yearOfManufacture, User owner) {
        // Generate unique registration number
        String registrationNumber = generateUniqueRegistrationNumber();
        // Create new vehicle instance
        Vehicle vehicle = new Vehicle(make, model, yearOfManufacture, owner);
        vehicle.setRegistrationNumber(registrationNumber);
        vehicle.setState(new RegisteredState());  // Set state to registered
        // Create registration certificate
        RegistrationCertificate certificate = new RegistrationCertificate(UUID.randomUUID().toString(), registrationNumber, new Date(), new Date());
        // Add vehicle and certificate to maps
        vehicles.put(registrationNumber, vehicle);
        certificates.put(registrationNumber, certificate);
        // Save data to files
        saveData();
        System.out.println("Vehicle registered successfully. Registration Number: " + registrationNumber);
        return vehicle;
    }

    @Override
    public Vehicle viewRegisteredVehicle(String registrationNumber) {
        // Retrieve vehicle by registration number
        return vehicles.get(registrationNumber);
    }

    @Override
    public void updateVehicleDetails(String registrationNumber, Vehicle updatedVehicle) {
        // Update vehicle details in the map
        vehicles.put(registrationNumber, updatedVehicle);
        // Save data to files
        saveData();
    }

    @Override
    public void deleteVehicle(String registrationNumber) {
        // Remove vehicle from the map
        vehicles.remove(registrationNumber);
        // Save data to files
        saveData();
    }

    @Override
    public void renewVehicleRegistration(String registrationNumber) {
        Vehicle vehicle = vehicles.get(registrationNumber);
        if (vehicle != null) {
            // Renew registration logic (e.g., update expiry date)
            RegistrationCertificate certificate = certificates.get(registrationNumber);
            if (certificate != null) {
                // Extend expiry date by one year
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(certificate.getExpiryDate());
                calendar.add(Calendar.YEAR, 1);
                certificate.setExpiryDate(calendar.getTime());
                // Update certificate in the map
                certificates.put(registrationNumber, certificate);
                // Save data to files
                saveData();
                System.out.println("Vehicle registration renewed.");
            }
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    @Override
    public void sendExpirationAlert(String registrationNumber) {
        Vehicle vehicle = vehicles.get(registrationNumber);
        if (vehicle != null) {
            // Check for expiry date and send alert if necessary
            RegistrationCertificate certificate = certificates.get(registrationNumber);
            if (certificate != null) {
                Date expiryDate = certificate.getExpiryDate();
                Date currentDate = new Date();
                long diff = expiryDate.getTime() - currentDate.getTime();
                long daysUntilExpiry = diff / (1000 * 60 * 60 * 24);
                if (daysUntilExpiry <= 30) {
                    System.out.println("Alert: Vehicle registration for " + registrationNumber + " will expire in " + daysUntilExpiry + " days.");
                } else {
                    System.out.println("Vehicle registration for " + registrationNumber + " is not expiring soon.");
                }
            }
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    @Override
    public void trackRegistrationStatus(String registrationNumber) {
        Vehicle vehicle = vehicles.get(registrationNumber);
        if (vehicle != null) {
            // Display current state of the vehicle
            vehicle.handleState();
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    @Override
    public void viewAllRegisteredVehicles() {
        // Display all registered vehicles
        if (vehicles.isEmpty()) {
            System.out.println("No registered vehicles found.");
        } else {
            for (Vehicle vehicle : vehicles.values()) {
                System.out.println(vehicle);
            }
        }
    }

    // Generate a unique 12-digit registration number
    private String generateUniqueRegistrationNumber() {
        Random random = new Random();
        String registrationNumber;
        do {
            registrationNumber = String.format("%012d", random.nextInt(1000000000));
        } while (vehicles.containsKey(registrationNumber));
        return registrationNumber;
    }

    // Save data to files
    private void saveData() {
        try (ObjectOutputStream vehicleOutputStream = new ObjectOutputStream(new FileOutputStream(VEHICLES_FILE))) {
            vehicleOutputStream.writeObject(vehicles);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream certificateOutputStream = new ObjectOutputStream(new FileOutputStream(CERTIFICATES_FILE))) {
            certificateOutputStream.writeObject(certificates);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



