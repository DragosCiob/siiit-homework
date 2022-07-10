package siit.homework04.oop2;

public class Main {
    public static void main(String[] args) {

        Phone phone1= new GalaxyS20("green", "glass", 8, "12fgh");
        Phone phone2= new GalaxyA5("blue", "aluminum", 6, "10klm");
        phone1.createNewContact(1, "0743901102", "Ignat", "Andi");
        phone1.createNewContact(2, "0731312499", "Pop", "Luiza");
        phone1.displayContactsList();
        phone2.createNewContact(1, "0744113212", "Sandu", "Ana");
        phone2.createNewContact(2, "0722312479", "Manea", "Stefan");
        phone2.displayContactsList();

        phone1.sendTextMessage("0743901102", "hey, how is it going?");
        phone1.sendTextMessage("0743901102", "hey, how is it going?");
        phone1.sendTextMessage("0743901102", "are you busy?");
        phone1.displayMessagesHistory("0743901102", "Ignat");

        phone1.call("0731312499", "Pop");
        phone1.call("073131157", "Radu");
        phone1.displayCallsHistory();

    }
}
