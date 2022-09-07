package siit.homework09;


import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Reader reader = new Reader();


        reader.generateStanding().stream().forEach(athlete -> System.out.println(athlete));

        System.out.println("TOP 3");
        List<Athlete> standing = reader .generateStanding().stream().collect(Collectors.toList());
        for(int i=0; i<3; i++){

            System.out.println(standing.get(i));

        }

    };
}
