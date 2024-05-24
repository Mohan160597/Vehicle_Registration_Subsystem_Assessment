package Vehicle_Registration;

//State class representing a registered vehicle state
@SuppressWarnings("serial")
public class RegisteredState implements VehicleState {
 @Override
 public void handleState(Vehicle vehicle) {
     System.out.println("The vehicle is registered.");
 }
}

