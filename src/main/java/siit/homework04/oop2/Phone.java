package siit.homework04.oop2;

public interface Phone {

    void createNewContact(int noOfContact, String contactPhoneNumber,String firstName, String secondName);

    void displayContactsList();
    void sendTextMessage(String contactPhoneNumber, String message);
    void displayMessagesHistory(String contactPhoneNumber,  String firstName );
    void call(String contactPhoneNumber, String firstName);
    void displayCallsHistory();

}
