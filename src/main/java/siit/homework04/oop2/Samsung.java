package siit.homework04.oop2;

import java.util.ArrayList;
import java.util.List;

public abstract  class Samsung implements Phone {

    protected int  batteryLife;
    protected String phoneName;

    private String color;
    private String material;

    private int batteryStatus;



    private List<Contact> contactList = new ArrayList<>();
    private List<Messages> messagesList = new ArrayList<>();
    private List<String> callsList = new ArrayList<>();

    public Samsung(int batteryLife, String color, String material, int batteryStatus, String phoneName ) {
        this.batteryLife = batteryLife;
        this.color = color;
        this.material = material;
        this.batteryStatus=batteryStatus;
        this.phoneName=phoneName;
    }




    @Override
    public void createNewContact(int noOfContact, String contactPhoneNumber, String firstName, String secondName) {
             contactList.add(new Contact( noOfContact, contactPhoneNumber, firstName, secondName));
    }

    @Override
    public void displayContactsList() {
        System.out.println("contacts of " + getPhoneName() );
        for (Contact contact : contactList) {
            contact.printContacts();
        }
    }

    @Override
    public void sendTextMessage(String contactPhoneNumber, String messageText) {
        int limit = 500;
        batteryStatus=batteryLife;
        System.out.println( " current battery status is: " + batteryStatus);
        if (batteryStatus != 0) {
            if (messageText.length() > limit) {
                System.out.println( " You have exceeded 500 characters!");
            } else {
                messagesList.add(new Messages(contactPhoneNumber, messageText));
                batteryStatus =batteryStatus-1;
                batteryLife=batteryStatus;
            }
        } else {
            System.out.println("Charge your phone");
        }
        System.out.println("updated battery status due to messaging: " + batteryStatus);

    }

    @Override
    public void displayMessagesHistory(String contactPhoneNumber, String firstName) {
        System.out.println("messages history with contact number " + firstName );
        for (Messages message : messagesList) {
            if (message.getContactPhoneNumber().equals(contactPhoneNumber)) {
                System.out.println(message.getMessageText());
            }
        }

    }

    @Override
    public void call(String contactPhoneNumber, String firstName) {
        System.out.println("battery status is " + batteryStatus );
        if (batteryStatus != 0) {
            callsList.add(firstName);
            batteryStatus=batteryStatus-2;
        }else{
            System.out.println("Charge your phone battery");
        }
        System.out.println("battery status updated due to calling " + batteryStatus );

    }



    @Override
    public void displayCallsHistory() {
        System.out.println("history of calls");
        System.out.println(callsList);

    }

    public String getPhoneName() {
        return phoneName;
    }
}
