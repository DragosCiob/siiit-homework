package siit.homework07;

import java.util.*;

public class SetsOfPersons {
    public static void main(String[] args) {
        // some persons
        Person person1=new Person("Adrian", 17);
        Person person2=new Person("Dan", 22);
        Person person3=new Person("Laura", 19);
        Person person4=new Person("Adina", 32);

        Set<Person> personSet = new TreeSet<>( new PersonAgeComparator() /*new NameComparator()*/);
        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person3);
        personSet.add(person4);

        for (Person person: personSet) {

            System.out.println(person);

        }

        // some hobbies
        List<Hobby> hobbies  = new ArrayList<>();
        Hobby cycling=new Hobby("cycling");
        Hobby rafting=new Hobby("rafting");
        Hobby running=new Hobby("running");
        Hobby surfing=new Hobby("surfing");
        hobbies.add(cycling);
        hobbies.add(rafting);
        hobbies.add(running);
        hobbies.add(surfing);
       // System.out.println(hobbies);

        //some addresses
        List<Address> countries = new ArrayList<>();
        Address romania = new Address("Romania");
        Address spain = new Address("Spain");
        Address italy = new Address("Italy");
        Address france = new Address("France");
        countries.add(romania);
        countries.add(spain);
        countries.add(italy);
        countries.add(france);
      //  System.out.println(countries);


       //hashmap for hobbies of a person
        Map<Person, List<Hobby>>hobbiesOfPerson1 = new HashMap<>();
        List<Hobby> adisHobbies= new ArrayList<>();
        Hobby skating =new Hobby("skating");
        adisHobbies.add(running);
        adisHobbies.add(surfing);
//      System.out.println("the following are Adi's hobbies");
        hobbiesOfPerson1.put(person1,adisHobbies);
//      System.out.println(hobbiesOfPerson1);

        //hashmap for hobbies addresses
        Map<Hobby, List<Address>> where = new HashMap<>();
        List<Address> surfingAddress = new ArrayList<>();
        List<Address> cyclingAddress = new ArrayList<>();
        surfingAddress.add(spain);
        Address portugal = new Address("Portugal");
        surfingAddress.add(portugal);
        cyclingAddress.add(italy);
        where.put(surfing,surfingAddress );
        where.put(running,cyclingAddress );
//      System.out.println("destination for surfing are ");
//      System.out.println(where);


        //hashmap to collect the information for each person
        Map<Map<Person, List<Hobby>>, Map<Hobby,List<Address>>> personHobbyDestination = new HashMap<>();
        personHobbyDestination.put(hobbiesOfPerson1,where);
        System.out.println(personHobbyDestination);





    }

}
