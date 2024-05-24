package Vehicle_Registration;

//State class representing a new vehicle state
@SuppressWarnings("serial")
public class NewState implements VehicleState {
 @Override
 public void handleState(Vehicle vehicle) {
     System.out.println("The vehicle is in a new state. Ready for registration.");
 }
}

