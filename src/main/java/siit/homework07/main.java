package siit.homework07;

public class main {

    public static void main(String[] args) {

        Student student1 = new Student("Ana", "Marin", 1992, 7, 15, "Female", "1212");
        Student student2 = new Student("Dan", "Dobre", 1989, 11, 10, "Male", "1313");
        Student student3 = new Student("Nadia", "Ifrim", 1985, 10, 15, "Female", "1414");

        SetOfStudent studentRepository = new SetOfStudent();
        studentRepository.addStudent(student1);
        studentRepository.addStudent(student2);
        studentRepository.addStudent(student3);

        System.out.println(studentRepository);

        studentRepository.deleteStudent("1313");

        System.out.println(studentRepository);

        studentRepository.retrieveStudents(22);
        System.out.println(studentRepository);





    }

}
