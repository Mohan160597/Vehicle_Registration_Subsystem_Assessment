package Vehicle_Registration;

import java.util.Scanner;

//Main class to interact with the Vehicle Registration System
public class Main {
 public static void main(String[] args) {
     VehicleRegistrationSystem system = VehicleRegistrationSystem.getInstance();
     Scanner scanner = new Scanner(System.in);

     while (true) {
         System.out.println("Vehicle Registration System");
         System.out.println("1. Register new vehicle");
         System.out.println("2. View registered vehicle");
         System.out.println("3. Update vehicle details");
         System.out.println("4. Delete vehicle");
         System.out.println("5. Renew vehicle registration");
         System.out.println("6. Send expiration alert");
         System.out.println("7. Track registration status");
         System.out.println("8. View all registered vehicles");
         System.out.println("9. Exit");
         System.out.print("Choose an option: ");

         int option = scanner.nextInt();
         scanner.nextLine(); // Consume newline

         switch (option) {
             case 1:
                 System.out.print("Enter make: ");
                 String make = scanner.nextLine();
                 System.out.print("Enter model: ");
                 String model = scanner.nextLine();
                 System.out.print("Enter year of manufacture: ");
                 int year = scanner.nextInt();
                 scanner.nextLine(); // Consume newline
                 System.out.print("Enter owner user ID: ");
                 String userId = scanner.nextLine();
                 System.out.print("Enter owner name: ");
                 String name = scanner.nextLine();
                 System.out.print("Enter owner address: ");
                 String address = scanner.nextLine();
                 System.out.print("Enter owner phone number: ");
                 String phoneNumber = scanner.nextLine();
                 User owner = new User(userId, name, address, phoneNumber);
                 system.registerNewVehicle(make, model, year, owner);
                 break;
             case 2:
                 System.out.print("Enter registration number: ");
                 String regNumber = scanner.nextLine();
                 Vehicle vehicle = system.viewRegisteredVehicle(regNumber);
                 System.out.println(vehicle != null ? vehicle : "Vehicle not found.");
                 break;
             case 3:
                 System.out.print("Enter registration number: ");
                 regNumber = scanner.nextLine();
                 vehicle = system.viewRegisteredVehicle(regNumber);
                 if (vehicle != null) {
                     System.out.print("Enter new make: ");
                     make = scanner.nextLine();
                     System.out.print("Enter new model: ");
                     model = scanner.nextLine();
                     System.out.print("Enter new year of manufacture: ");
                     year = scanner.nextInt();
                     scanner.nextLine(); // Consume newline
                     vehicle.setMake(make);
                     vehicle.setModel(model);
                     vehicle.setYearOfManufacture(year);
                     system.updateVehicleDetails(regNumber, vehicle);
                     System.out.println("Vehicle details updated.");
                 } else {
                     System.out.println("Vehicle not found.");
                 }
                 break;
             case 4:
                 System.out.print("Enter registration number: ");
                 regNumber = scanner.nextLine();
                 system.deleteVehicle(regNumber);
                 System.out.println("Vehicle deleted if it existed.");
                 break;
             case 5:
                 System.out.print("Enter registration number: ");
                 regNumber = scanner.nextLine();
                 system.renewVehicleRegistration(regNumber);
                 System.out.println("Vehicle registration renewed if it existed.");
                 break;
             case 6:
                 System.out.print("Enter registration number: ");
                 regNumber = scanner.nextLine();
                 system.sendExpirationAlert(regNumber);
                 break;
             case 7:
                 System.out.print("Enter registration number: ");
                 regNumber = scanner.nextLine();
                 system.trackRegistrationStatus(regNumber);
                 break;
             case 8:
                 system.viewAllRegisteredVehicles();
                 break;
             case 9:
                 System.out.println("Exiting...");
                 scanner.close();
                 return;
             default:
                 System.out.println("Invalid option. Please try again.");
         }
     }
 }
}

