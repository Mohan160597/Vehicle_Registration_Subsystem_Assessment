package Vehicle_Registration;

import java.io.Serializable;

//State interface defining the handleState method
public interface VehicleState extends Serializable {
 void handleState(Vehicle vehicle);
}

