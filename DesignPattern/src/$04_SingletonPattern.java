/*
 * SingletonPattern: You want to ensure you can't make more than one instance of class.
 *
 *	1) Provide a default Private constructor.
 *	2) Create a Method for getting the reference to the Singleton Object.
 *	3) Make the Access method Synchronized to prevent Thread Problems.
 *	4) Override the Object clone method to prevent cloning.
 * */

public class $04_SingletonPattern {
	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
	//	Singleton s = new Singleton();				ERROR: constructor is private, can't be accessed

	}
}

/**	Typical Singleton	**/
class Singleton {
	private Singleton() { }

	private final static Singleton inst = new Singleton();

	public static synchronized Singleton getInstance() { // static, so that it can be called as: Singleton.getInstance();
		return inst;
	}
}


// version2 (classic Singleton) 
/*class Singleton{
	private static Singleton inst = null;
	
	private Singleton() {}
	
	static Singleton getInstance() {
		if(inst == null)
			inst = new Singleton();
		return inst;
	}
}*/