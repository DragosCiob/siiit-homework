package siit.homework11;

public class Person {

    private final String firstName;
    private final String lastName;
    private final Integer monthOfBirth;

    public Person(String firstName, String lastName, Integer dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthOfBirth = dateOfBirth;
    }





    @Override
    public String toString() {
        return
                 firstName + " " + lastName + "/" ;
    }

    public Integer getMonthOfBirth() {
        return monthOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    
}
