package siit.midterm.test;

public class CalculatorMain {

    public static void main(String[] args) {


        Drawer drawer= new Drawer();
        Shape shape1 = new Triangle(12.2,6.3);
        Shape shape2 = new Rectangle(15.6, 15.9);
        Shape shape3 = new Square(15.1);
        Shape shape4 = new Circle(8.2);



        drawer.draw(shape1);
        drawer.draw(shape2);
        drawer.draw(shape3);
        drawer.draw(shape4);

        drawer.getTotalPerimeter();
        drawer.getTotalArea();


    }
}
