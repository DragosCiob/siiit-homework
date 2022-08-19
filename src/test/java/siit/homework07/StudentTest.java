package siit.homework07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class StudentTest {
@Test
    public void testLastName() {

       Exception thrownException = Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Student("Bogdan", null , 1992, 11, 22, "Male", "1616"));
       Assertions.assertEquals("A last name must be inserted", thrownException.getMessage());
    }
    @Test
    public void testFirstName() {

        Exception thrownException =Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Student(null, "Ilie" , 1992, 11, 22, "Male", "1616"));
        Assertions.assertEquals("A first name must be inserted", thrownException.getMessage());
    }
    @Test
    public void testYearOFBirth(){

        Exception thrownException =Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Student("Bogdan", "Ilie" , null, 11, 22, "Male", "1616"));
        Assertions.assertEquals("The age is not suitable", thrownException.getMessage());

    }

    @Test
    public void testDayOFBirth(){

        Exception thrownException =Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Student("Bogdan", "Ilie" , 1992 , 11, null, "Male", "1616"));
        Assertions.assertEquals("The age is not suitable", thrownException.getMessage());

    }

    @Test
    public void testMonthOFBirth(){

        Exception thrownException =Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Student("Bogdan", "Ilie" , 1992 , null , 22, "Male", "1616"));
        Assertions.assertEquals("The age is not suitable", thrownException.getMessage());

    }

    @Test
    public void testGenderNull(){

        Exception thrownException =Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Student("Bogdan", "Ilie" , 1992 , 11 , 22, null, "1616"));
        Assertions.assertEquals("Gender must be Male or Female.", thrownException.getMessage());

    }

    @Test
    public void testCnp(){

        Exception thrownException =Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Student("Bogdan", "Ilie" , 1992 , 11 , 22, "Male", null));
        Assertions.assertEquals("CNP cannot be empty.", thrownException.getMessage());

    }

    @Test
    public void testGender(){

        Exception thrownException =Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Student("Bogdan", "Ilie" , 1992 , 11 , 22, "bicicleta", "1616"));
        Assertions.assertEquals("Gender must be Male or Female.", thrownException.getMessage());

    }



}