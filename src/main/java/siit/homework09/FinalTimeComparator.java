package siit.homework09;

import java.util.Comparator;

public class FinalTimeComparator implements Comparator<Athlete> {

    @Override
    public int compare(Athlete o1, Athlete o2) {
        return o1.getFinalTime().compareTo(o2.getFinalTime());
        
    }
}
