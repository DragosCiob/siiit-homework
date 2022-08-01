package siit.homework07;

import java.util.ArrayList;
import java.util.List;

public class Address {

    private List<String> addresses;

    public Address(String address) {
        this.addresses = new ArrayList<>();
       this.addresses.add(address);
    }


    public void setAddresses(String address){
        this.addresses.add(address);
    }


    public List<String> getAddresses() {
        List<String> temp = new ArrayList<>();
        temp.addAll(addresses);
        return temp;
    }


    @Override
    public String toString() {
        return "Address: " + addresses;
    }
}
