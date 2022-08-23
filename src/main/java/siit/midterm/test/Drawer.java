package siit.midterm.test;



import java.util.ArrayList;
import java.util.List;


public class Drawer {

    private List<Shape> container = new ArrayList<>();

    /**
     * this  method does not allowes to be added two shapes with the same name
     * @param currentShape
     */
    public void draw(Shape currentShape) {
        for (Shape shape: container) {
            if (shape.getName().equals(currentShape.getName())){

                throw new IllegalArgumentException("cannot be added two similar objects");
            }

        }
        container.add(currentShape);
    }

    public List<Shape> getContainer() {
        List<Shape> temp=container;
        return temp;
    }

    public double getTotalPerimeter(){
        double totalPerimeter=0;

        for (Shape shape: container) {
           totalPerimeter +=shape.getPerimeter();
        }

        System.out.println("total perimeter: " + totalPerimeter);
        return totalPerimeter;
    }

    public double getTotalArea(){
        double totalArea=0;

        for (Shape shape: container) {
            totalArea +=shape.getSurfaceArea();
        }

        System.out.println("total Area: " + totalArea);
        return totalArea;
    }


}
