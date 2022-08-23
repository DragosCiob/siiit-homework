package siit.midterm.test;

public class Triangle implements Shape{

    private double triangleBase;
    private double triangleHeight;
    private final String name="Triangle";

    /**
     is working only for isosceles triangles
     */

    public Triangle(double triangleBase, double triangleHigh) {
        this.triangleBase = triangleBase;
        this.triangleHeight = triangleHigh;
    }

    public double getTriangleBase() {
        return triangleBase;
    }

    public double getTriangleHeight() {
        return triangleHeight;
    }

    public String getName() {
        return name;
    }


    public double getLengthOfSegment(){
         double l;
         double a;
         a = (triangleBase/2)*(triangleBase/2) + (triangleHeight * triangleHeight) ;
         l=Math.sqrt(a);
//        System.out.print(Math.sqrt(a));
        return l;

    }



    @Override
    public double getPerimeter() {
      System.out.println("triangle perimeter");
      System.out.println(triangleBase+getLengthOfSegment()+getLengthOfSegment());
        return triangleBase+getLengthOfSegment()+getLengthOfSegment();
    }

    @Override
    public double getSurfaceArea() {
        System.out.println("triangle area");
        System.out.println((triangleBase* triangleHeight)/2);
        return (triangleBase* triangleHeight)/2;
    }

    @Override
    public String toString() {
        return getName() + " base " + getTriangleBase()+ " height " + getTriangleHeight();
    }
}
