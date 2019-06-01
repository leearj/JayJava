/*
 * Use if you need to dynamically change an algorithm used by an object at run time.
 * 	This allows: eliminating code duplication, separates behavior from super and subclasses.
 * */

public class $02_StrategyPattern {
	public static void main(String[] args) {
		Animal animal1 = new Eagle();
		Animal animal2 = new Ostrich();
		Animal animal3 = new Tiger();

		System.out.printf("%-8s: %10s", animal1.getClass().getName(), animal1.getAnimSound());
		System.out.printf("\n%-8s: %10s", animal1.getClass().getName(), animal1.tryToFly());
		System.out.printf("\n%-8s: %10s", animal2.getClass().getName(), animal2.getAnimSound());
		System.out.printf("\n%-8s: %10s", animal2.getClass().getName(), animal2.tryToFly());
		System.out.printf("\n%-8s: %10s", animal3.getClass().getName(), animal3.getAnimSound());
		System.out.printf("\n%-8s: %10s", animal3.getClass().getName(), animal3.tryToFly());
	}
}

class Animal {
	private String name;
	private String animSound;

	Flys flyType;

	String tryToFly() {
		// returns whether the animal can fly or not, using Flys_instance.
		return flyType.fly();
	}

	public void setFlyingAbility(Flys newFlyType) {
		// allowing the animal to obtain new flying ability.
		flyType = newFlyType;
	}

	/** Getters and Setters for Animal info. **/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnimSound() {
		return animSound;
	}

	public void setAnimSound(String animSound) {
		this.animSound = animSound;
	}
}

interface Flys {
	String fly();
}

class CanFly implements Flys {
	@Override
	public String fly() {
		return "I can fly!!!";
	}
}

class CantFly implements Flys {
	@Override
	public String fly() {
		return "I can't fly...";
	}
}

/*** List of Animals ***/

class Eagle extends Animal {
	Eagle() {
		setName("Eagle");
		setAnimSound("Kwit Kwit !!!");
		flyType = new CanFly();
	}
}

class Ostrich extends Animal {
	Ostrich() {
		setName("Ostrich");
		setAnimSound("Ostrrrr !!!");
		flyType = new CantFly();
	}
}

class Tiger extends Animal {
	Tiger() {
		setName("Tiger");
		setAnimSound("Rawrrrr !!!");
		flyType = new CantFly();
	}
}