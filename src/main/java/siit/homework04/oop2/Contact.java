package siit.homework04.oop2;

public class Contact {
     int noOfContact;
     String contactPhoneNumber;
     String firstName;
     String secondName;

     public Contact(int noOfContact, String contactPhoneNumber, String firstName, String secondName) {
          this.noOfContact = noOfContact;
          this.contactPhoneNumber = contactPhoneNumber;
          this.firstName = firstName;
          this.secondName = secondName;
     }



     public void printContacts(){
          System.out.println(noOfContact + " " + contactPhoneNumber + " " + firstName + " " + secondName);
     }


}
