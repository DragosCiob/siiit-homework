package siit.midterm.test;

public class Circle implements Shape{

    private double radius;
    private String name= "Circle";

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        System.out.println("Circle perimeter");
        double perimeter=0;
        perimeter=3.14*2*radius;
        System.out.println(perimeter);
        return perimeter;
    }

    @Override
    public double getSurfaceArea() {
        System.out.println("Circle Surface area");
        double area=0;
        area=3.14*(radius*radius);
        System.out.println(area);
        return area;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {

        return getName()+ " radius " + getRadius();
    }


}
