package Vehicle_Registration;

//State class representing an expired vehicle registration state
@SuppressWarnings("serial")
public class ExpiredState implements VehicleState {
 @Override
 public void handleState(Vehicle vehicle) {
     System.out.println("The vehicle registration has expired.");
 }
}

