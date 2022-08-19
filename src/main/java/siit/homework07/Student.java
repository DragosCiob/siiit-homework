package siit.homework07;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Student {

    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final String gender;
    private final String cnp;

    private Integer age;

    public Student(String firstName, String lastName, Integer yearOfBirth, Integer monthOfBirth, Integer dayOfBirth, String gender, String cnp) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.dateOfBirth = dateOfBirth;
//        this.gender = gender;
//        this.cnp = cnp;
        try {
            if (firstName == null) {
                throw new IllegalArgumentException("A first name must be inserted");
            }
            this.firstName = firstName;

            if (lastName == null) {
                throw new IllegalArgumentException("A last name must be inserted");
            }
            this.lastName = lastName;

            if (yearOfBirth == null ||
                    monthOfBirth == null ||
                    dayOfBirth == null ||
                    yearOfBirth < 1900 ||
                    yearOfBirth > (LocalDate.now().getYear() - 18)) {
                throw new IllegalArgumentException("The age is not suitable");
            }
            this.dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);


            if (gender == null || (!gender.equalsIgnoreCase("Female") && !gender.equalsIgnoreCase("Male"))){
                throw new IllegalArgumentException("Gender must be Male or Female.");
            } else {

                this.gender = gender;
            }

            if (cnp==null) {
                throw new IllegalArgumentException("CNP cannot be empty.");
            }else{
                this.cnp = cnp;
            }
        }catch (IllegalArgumentException exception){

            throw new IllegalArgumentException (exception.getMessage());
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

 

    public String getGender() {
        return gender;
    }

    public String getCnp() {
        return cnp;
    }

    public Integer getAge() {

        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return this.firstName+ " " + this.lastName +" "  +getAge();

    }

    /**
     *
     * @param o
     * @return

     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(cnp, student.cnp);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(cnp);
    }
}
