
/* 	 -	functionality to an object (not the class) at runtime.
 * 
 *	 -	make decorator classes as abstract class to avoid any direct instantiation,
 * 		since it is just a wrapper which doesn't add any functionality into the shape. 
 * */

public class $05_DecoratorPattern {
	public static void main(String[] args) {
		          
		  Car sportsCar = new SportsCar(new DefaultCar());
		  System.out.print("SportsCar: ");
		  sportsCar.assemble();
		  
		  System.out.println();
		  
		  Car LuxurySportsCar = new SportsCar(new LuxuaryCar(new DefaultCar()));
		  System.out.print("LuxurySportsCar: ");
		  LuxurySportsCar.assemble();
		  
	//	  Car TestCar = new DefaultCar(new SportsCar()); ERROR: Only Cars that extends CarDecorator can do. 	
	}
}

interface Car {
	void assemble();
}
class CarDecorator implements Car{
	protected Car car;
	
	CarDecorator(Car c){
		this.car = c;
	}

	@Override
	public void assemble() {
		this.car.assemble();
	}
}

class DefaultCar implements Car{

	@Override
	public void assemble() {
		System.out.print("Default Car. ");
	}
	
}
class SportsCar extends CarDecorator{

	SportsCar(Car c) {
		super(c);
	}
	
	public void assemble() {
		super.assemble();	// This prints out "Default Car"
		System.out.print("SportsCar. ");
	}
}
class LuxuaryCar extends CarDecorator{

	LuxuaryCar(Car c) {
		super(c);
	}
	
	public void assemble() {
		super.assemble();	// This prints out "Default Car"
		System.out.print("Luxury Car. ");
	}
}
