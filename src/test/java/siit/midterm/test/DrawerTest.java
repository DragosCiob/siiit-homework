package siit.midterm.test;


import org.junit.jupiter.api.Test;


import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DrawerTest {


    Drawer drawer=new Drawer();
    Random randomizer=new Random();
    double radius =randomizer.nextInt(10);
    Circle circle = new Circle(radius);
    double l1 =randomizer.nextInt(10);
    double l2 =randomizer.nextInt(10);
    Rectangle rectangle = new Rectangle(l1, l2);
    double base=randomizer.nextInt(10);
    double height=randomizer.nextInt(10);
    Triangle triangle = new Triangle(base, height);
    double l =randomizer.nextInt(10);
    Square square = new Square(l);

    @Test
    void getTotalPerimeter() {


        assertEquals(((2*(Math.sqrt(((base/2)*(base/2)) + (height * height))))+base)+(2*radius*3.14)+(2*l1+2*l2)+(4*l) , circle.getPerimeter()+triangle.getPerimeter()+rectangle.getPerimeter()+square.getPerimeter());

    }

    @Test
    void getTotalArea() {


        assertEquals(((base*height)/2)+(l*l)+(l1*l2)+(3.14*(Math.pow(radius,2))) , circle.getSurfaceArea()+rectangle.getSurfaceArea()+square.getSurfaceArea()+triangle.getSurfaceArea());



    }


    @Test
    void drawException() {

        drawer.draw(square);
        drawer.draw(triangle);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                drawer.draw(square));

        String expectedMessage = "cannot be added two similar objects";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);


    }
}