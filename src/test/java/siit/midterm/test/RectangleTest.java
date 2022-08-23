package siit.midterm.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class RectangleTest {

    @Test
    void getPerimeter() {

        Random randomizer=new Random();
        double l1 =randomizer.nextInt(10);
        double l2 =randomizer.nextInt(10);
        Rectangle rectangle = new Rectangle(l1, l2);

        Assertions.assertEquals(2*l1+2*l2, rectangle.getPerimeter());
    }

    @Test
    void getSurfaceArea() {
        Random randomizer=new Random();
        double l1 =randomizer.nextInt(10);
        double l2 =randomizer.nextInt(10);
        Rectangle rectangle = new Rectangle(l1, l2);

        Assertions.assertEquals(l1*l2, rectangle.getSurfaceArea());

    }
}