package siit.midterm.test;

public class Rectangle implements Shape{

    private double l1;
    private double l2;

    private String name ="Rectangle";


    public Rectangle(double l1, double l2) {
        this.l1 = l1;
        this.l2 = l2;

    }

    @Override
    public double getPerimeter() {
        System.out.println("Rectangle perimeter");
        double perimeter=0;
        perimeter=2*l1+2*l2;
        System.out.println(perimeter);
        return perimeter;
    }

    @Override
    public double getSurfaceArea() {
        System.out.println("Rectangle Surface area");
        double area=0;
        area=l1*l2;
        System.out.println(area);
        return area;
    }

    public double getL1() {
        return l1;
    }

    public double getL2() {
        return l2;
    }

    @Override
    public String toString() {
        return getName() + " length " + getL1() + " width " + getL2() ;
    }

    public String getName() {
        return name;
    }


}
