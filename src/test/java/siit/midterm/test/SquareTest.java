package siit.midterm.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class SquareTest {

    @Test
    void getPerimeter() {

        Random randomizer=new Random();
        double l =randomizer.nextInt(10);
        Square square = new Square(l);

        Assertions.assertEquals(4*l, square.getPerimeter());

    }

    @Test
    void getSurfaceArea() {

        Random randomizer=new Random();
        double l =randomizer.nextInt(10);
        Square square = new Square(l);

        Assertions.assertEquals(l*l, square.getSurfaceArea());
    }
}