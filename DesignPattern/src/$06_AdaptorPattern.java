
/* allow two incompatible interfaces or classes to work together. 
 * */

public class $06_AdaptorPattern {
	public static void main(String[] args) {
		AssignmentWork aw = new AssignmentWork(new PenAdaptor());

		// aw.setP(new PilotPen()); Removed due to the constructor (line 18)

		aw.writeAssignment("I am tired but doing the assignment");
	}
}

class AssignmentWork {
	private Pen p;

	AssignmentWork(Pen p) {
		this.p = p;
	}

	public void writeAssignment(String str) {
		p.write(str); // the pen writes the data.
	}

	public Pen getP() {
		return p;
	}
}

interface Pen {
	void write(String str);
}

class PenAdaptor implements Pen {

	// [1] Whenever you add new type of Pen, add here!!
	PilotPen pp = new PilotPen();
	DrGripPen dp = new DrGripPen();
	StaplePen sp = new StaplePen();

	@Override
	public void write(String str) {

		// [2] Whenever you add new type of Pen, add here!!
		pp.mark(str);
		dp.mark(str);
		sp.mark(str);
	}
}

class DrGripPen {

	void mark(String str) {
		System.out.println(str + " [by DrGripPen]");
	}
}

class PilotPen {
	void mark(String str) {
		System.out.println(str + " [by PilotPen]");
	}
}

class StaplePen {
	void mark(String str) {
		System.out.println(str + " [by StaplePen]");
	}
}
