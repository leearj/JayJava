/*
* Define a one-to-many dependency between objects. When one object gets changed, 
* the dependents get notified and automatically updated according to the updated data.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class $01_ObserverPattern {
	public static void main(String[] args) {
		Dress dress1 = new Dress("Red Dress");
		Dress dress2 = new Dress("Blue Dress");
		
		System.out.println(dress1.getDressName()+" Price: $"+dress1.getPrice());
		System.out.println(dress2.getDressName()+" Price: $"+dress2.getPrice());
		System.out.println();
		
		User user1 =  new User(dress1);
		user1.setUserName("LILLY");
		
		User user2 = new User(dress1);
		user2.setUserName("JOHN");
		
		dress1.addObserver(user1);
		dress1.addObserver(user2);
		System.out.println();
		
		dress1.setRandPrice();
		dress2.setRandPrice();
	}
}

interface Observer {
	public void update();
	public String getuserName();
}

class User implements Observer {
	String userName;
	Dress dress;

	User(Dress dress){
		this.dress = dress;
	}

	public void setUserName(String userName) {
		this.userName = userName;		
	}

	@Override
	public void update() {
		System.out.println(this.userName+": "+dress.getDressName()+"'s price has changed: " + dress.getPrice());
	}

	@Override
	public String getuserName() {
		return userName;
	}
}

interface Observable {
	void addObserver(Observer o);

	void removeObserver(Observer o);

	void notifyObserver();

	int getPrice();
}

class Dress implements Observable {
	private String dressName;
	
	private List<Observer> observers = new ArrayList<>();
	private int price;

	Dress(String dressName){
		this.dressName = dressName;
		price = new Random().nextInt(100)+20;
	}

	
	
	@Override
	public void addObserver(Observer o) {
		observers.add(o);
		System.out.println(o.getuserName()+" is now subscribing for "+getDressName()+"!!");
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObserver() {
		for(Observer o: observers)
			o.update();
	}

	@Override
	// This is for Observer class to let them get the price value.
	public int getPrice() {
		return price;
	}
	
	public String getDressName() {
		return dressName;
	}
	public void setRandPrice() {
		price = new Random().nextInt(100)+20;
		for(Observer o: observers)
			o.update();
	}

}
