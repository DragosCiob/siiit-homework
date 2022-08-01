package siit.homework07;

import java.util.ArrayList;
import java.util.List;

public class Hobby {

    private List<String> hobbies;
//    private int frequency;

    public Hobby(String initialHobby /*int frequency*/) {
        this.hobbies = new ArrayList<>();
        this.hobbies.add(initialHobby);
//      this.frequency = frequency;
    }

    public void addHobby(String hobby){
        this.hobbies.add(hobby);
    }

    @Override
    public String toString() {
        return "hobbies:" + hobbies;
    }

    public List<String> getHobbies() {
        List<String> temp = new ArrayList<>();
        temp.addAll(hobbies);
        return temp;
    }
}
