package siit.homework04.oop2;

public class Messages {

    private String ContactPhoneNumber;
    private String messageText;

    public Messages(String contactPhoneNumber, String messageText) {
        ContactPhoneNumber = contactPhoneNumber;
        this.messageText = messageText;
    }

    public String getContactPhoneNumber() {
        return ContactPhoneNumber;
    }

    public String getMessageText() {
        return messageText;
    }
}
