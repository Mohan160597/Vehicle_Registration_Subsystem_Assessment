package Vehicle_Registration;

//User class extending Person, representing a vehicle owner
@SuppressWarnings("serial")
public class User extends Person {
 // Constructor
 public User(String userId, String name, String address, String phoneNumber) {
     super(userId, name, address, phoneNumber);
 }

 @Override
 public String toString() {
     return "User{" +
             "userId='" + getUserId() + '\'' +
             ", name='" + getName() + '\'' +
             ", address='" + getAddress() + '\'' +
             ", phoneNumber='" + getPhoneNumber() + '\'' +
             '}';
 }
}

