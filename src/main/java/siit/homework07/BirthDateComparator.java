package siit.homework07;

import java.util.Comparator;

public class BirthDateComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {

        if(o1.getAge().equals(o2.getAge())){
            return o1.getCnp().compareTo(o2.getCnp());
        }
        return o1.getAge().compareTo(o2.getAge());
    }


}

