package siit.homework07;



import java.util.*;

public class SetOfStudents {


    /**
     * set of students by default ordered by name
     */
    private  Set<Student> setOfStudents = new HashSet<>();



    /**
     *  this method consent to add a student instances
     * @param student represent the object instance of Student class
     */
    public void addStudent(Student student) {

        setOfStudents.add(student);

    }

    /**
     * deletes a student instance
     *
     * @param cnp the cnp of the student
     * @throws IllegalArgumentException if the cnp is empty
     */
    public void deleteStudent(String cnp) {
        if (cnp == null) {
            throw new IllegalArgumentException("Enter the cnp");
        }
        Student studentToRemove = null;
        for (Student student : setOfStudents) {
            if (student.getCnp().equals(cnp)) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove==null) {
            System.out.println("Student with cnp" + cnp + " does not exist.");
        }
        setOfStudents.remove(studentToRemove);
    }


    /**
     * the method prints the a list of student instances with the same age
     * @param age is age you want to search the students by.
     */

    public List<Student>retrieveStudents(Integer age) {
        if (age == null || age < 0) {
            throw new IllegalArgumentException("Age should be a positive number");
        }
        List<Student> studentToPrint = new ArrayList<>();
        for (Student student : setOfStudents) {
            if (student.getAge().equals(age)) {
                studentToPrint.add(student);
            }
        }
        return studentToPrint;
    }

    /**
     * Student Set ordered by date of birth.
     */
    public  Set<Student> listStudentsByBirthDate(){
        Set<Student> studentSet = new TreeSet<>(new BirthDateComparator());

        studentSet.addAll(setOfStudents);
//        for (Student student:studentSet) {
//            System.out.println(student);
//        }

        return studentSet;
    }
    public  Set<Student> listStudentsByName(){
        Set<Student> studentSet = new TreeSet<>(new NameComparator());

        studentSet.addAll(setOfStudents);
//        for (Student student:studentSet) {
//            System.out.println(student);
//        }

        return studentSet;
    }

    public Set<Student> getSetOfStudents() {
        Set<Student> studentSet = new HashSet<>();
        studentSet=setOfStudents;
        return studentSet;
    }
}
