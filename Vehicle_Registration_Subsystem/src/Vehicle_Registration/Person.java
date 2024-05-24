package Vehicle_Registration;

import java.io.Serializable;

//Base class representing a person with basic attributes
@SuppressWarnings("serial")
public class Person implements Serializable {
 private String userId;
 private String name;
 private String address;
 private String phoneNumber;

 // Constructor
 public Person(String userId, String name, String address, String phoneNumber) {
     this.userId = userId;
     this.name = name;
     this.address = address;
     this.phoneNumber = phoneNumber;
 }

 // Getters and Setters
 public String getUserId() {
     return userId;
 }

 public void setUserId(String userId) {
     this.userId = userId;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public String getAddress() {
     return address;
 }

 public void setAddress(String address) {
     this.address = address;
 }

 public String getPhoneNumber() {
     return phoneNumber;
 }

 public void setPhoneNumber(String phoneNumber) {
     this.phoneNumber = phoneNumber;
 }

 @Override
 public String toString() {
     return "Person{" +
             "userId='" + userId + '\'' +
             ", name='" + name + '\'' +
             ", address='" + address + '\'' +
             ", phoneNumber='" + phoneNumber + '\'' +
             '}';
 }
}

