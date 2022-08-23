package siit.midterm.test;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void getLengthOfSegment() {

        Random randomizer=new Random();
        double base=randomizer.nextInt(10);
        double height=randomizer.nextInt(10);
        Triangle triangle = new Triangle(base, height);

        assertEquals(Math.sqrt((base/2)*(base/2) + (height * height)), triangle.getLengthOfSegment());


    }

    @Test
    void getPerimeter() {

        Random randomizer=new Random();
        double base=randomizer.nextInt(10);
        double height=randomizer.nextInt(10);
        Triangle triangle = new Triangle(base, height);
        double l= Math.sqrt((base/2)*(base/2)+(height*height));

        assertEquals(l+l+base, triangle.getPerimeter());

    }

    @Test
    void getSurfaceArea() {

        Random randomizer=new Random();
        double base=randomizer.nextInt(10);
        double height=randomizer.nextInt(10);
        Triangle triangle = new Triangle(base, height);


        assertEquals((base*height)/2, triangle.getSurfaceArea());
    }
}