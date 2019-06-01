SideNote

$01_ObserverPattern: cleaner if Observer isn't interface.

	public abstract class Observer {
   		protected User user;		
   		public abstract void update();
	}

$02_StrategyPattern: 

$05_DecoratorPattern:
	In, Car sportsCar = new Sportscar(CAR TYPE);
	we don't want to have raw interface for CAR TYPE;
 	it needs to be concrete class that implements Car.
 	So if DefaultCar extends CarDecorator, we need to finish up Default Class's assemble() method, using lambda exp.

	So we let DefaultCar implements Car, and other cars(Fancy,AICar...) extends CarDecorator.
