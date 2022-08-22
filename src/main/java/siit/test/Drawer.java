package siit.test;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Drawer {

    private List<Shape> container = new ArrayList<>();

    public void draw(Shape shape) {
        container.add(shape);
    }

    public List<Shape> getContainer() {
        List<Shape> temp=container;
        return temp;
    }
}
