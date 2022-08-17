package siit.homework07;

public class main {

    public static void main(String[] args) {

        Student student1 = new Student("Ana", "Marin", 1989, 7, 15, "Female", "1212");
        Student student2 = new Student("Dan", "Dobre", 1960, 11, 10, "Male", "1313");
        Student student3 = new Student("Nadia", "Ilie", 1985, 10, 15, "Female", "1414");
        Student student4 = new Student("Alex", "Jan", 1992, 9, 1, "Male", "1515");
        Student student5 = new Student("Bogdan", "Ilie", 1992, 11, 22, "Male", "1616");

        SetOfStudents studentRepository = new SetOfStudents();
        studentRepository.addStudent(student1);
        studentRepository.addStudent(student2);
        studentRepository.addStudent(student3);
        studentRepository.addStudent(student4);
        studentRepository.addStudent(student5);

        System.out.println(studentRepository.getSetOfStudents());

        System.out.println(studentRepository.listStudentsByName());
        System.out.println(studentRepository.listStudentsByBirthDate());
        System.out.println(studentRepository.retrieveStudents(29));













    }

}
