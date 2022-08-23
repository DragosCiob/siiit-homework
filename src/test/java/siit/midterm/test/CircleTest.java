package siit.midterm.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class CircleTest {

    @Test
    void getPerimeter() {

        Random randomizer=new Random();
        double radius =randomizer.nextInt(10);
        Circle circle = new Circle(radius);





        Assertions.assertEquals(2*radius*3.14, circle.getPerimeter());
    }

    @Test
    void getSurfaceArea() {
        Random randomizer=new Random();
        double radius =randomizer.nextInt(10);
        Circle circle = new Circle(radius);


        Assertions.assertEquals((Math.pow(radius,2))*3.14, circle.getSurfaceArea());


    }
}