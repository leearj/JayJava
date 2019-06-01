import java.util.ArrayList;
import java.util.List;

/*
 * Base Component / Leaf / Composite
 *
 * Base Component: interface for all objects ( is-a relationship: Circle is-a Shape) with paint method.
 * 
 * Composite Object: 1) contains group of leaf objects. 2) allow to add/delete/clear leaf.
 * 
 * Leaf: the subs.
 *
 * */
public class $07_CompositePattern {
	public static void main(String[] args) {
		Shape t1 = new Triangle();
		Shape c1 = new Circle();
		Shape r1 = new Rectangle();

		// Add three shapes to the list and paint them RED.
		Drawing drawing = new Drawing();
		drawing.add(t1);
		drawing.add(c1);
		drawing.add(r1);
		drawing.paint("RED");

		// Clear, add one Circle to the list and paint them GREEN.
		drawing.clear();
		drawing.add(c1);
		drawing.paint("GREEN");

	}
}

//[Base Component]
interface Shape {
	void paint(String color);
}

// [Composite Object]
class Drawing implements Shape {

	private List<Shape> shapes = new ArrayList<>();

	@Override
	public void paint(String color) {
	}

	void add(Shape s) {
	}

	void remove(Shape s) {
	}

	void clear() {
	}
}

// [Leaf]
class Triangle implements Shape {

}

class Circle implements Shape {

}

class Rectangle implements Shape {

}
