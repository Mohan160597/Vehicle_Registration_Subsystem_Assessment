package Vehicle_Registration;

import java.io.Serializable;

//Vehicle class representing a vehicle with various attributes
@SuppressWarnings("serial")
public class Vehicle implements Serializable {
 private String registrationNumber;
 private String make;
 private String model;
 private int yearOfManufacture;
 private User owner;
 private VehicleState state; // State of the vehicle

 // Constructor
 public Vehicle(String make, String model, int yearOfManufacture, User owner) {
     this.make = make;
     this.model = model;
     this.yearOfManufacture = yearOfManufacture;
     this.owner = owner;
     this.state = new NewState();  // Initially, the vehicle is in a new state
 }

 // Getters and Setters
 public String getRegistrationNumber() {
     return registrationNumber;
 }

 public void setRegistrationNumber(String registrationNumber) {
     this.registrationNumber = registrationNumber;
 }

 public String getMake() {
     return make;
 }

 public void setMake(String make) {
     this.make = make;
 }

 public String getModel() {
     return model;
 }

 public void setModel(String model) {
     this.model = model;
 }

 public int getYearOfManufacture() {
     return yearOfManufacture;
 }

 public void setYearOfManufacture(int yearOfManufacture) {
     this.yearOfManufacture = yearOfManufacture;
 }

 public User getOwner() {
     return owner;
 }

 public void setOwner(User owner) {
     this.owner = owner;
 }

 public VehicleState getState() {
     return state;
 }

 public void setState(VehicleState state) {
     this.state = state;
 }

 public void handleState() {
     state.handleState(this);
 }

 @Override
 public String toString() {
     return "Vehicle{" +
             "registrationNumber='" + registrationNumber + '\'' +
             ", make='" + make + '\'' +
             ", model='" + model + '\'' +
             ", yearOfManufacture=" + yearOfManufacture +
             ", owner=" + owner +
             ", state=" + state.getClass().getSimpleName() +
             '}';
 }
}



