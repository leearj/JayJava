import java.util.Random;
import java.util.Scanner;

/*
 *  Use when we want to define the class of an object at runtime;
 *  We don't know what object we want to create on runtime(Example: random enemy spawn)
 * */

public class $03_FactoryPattern {
	public static void main(String args[]) {

		// a factory that randomly generate enemies.
		EnemyRandFactory enemyRandFactory = new EnemyRandFactory();

		Scanner sc = new Scanner(System.in);
		System.out.print("[Select Enemy1 type] W/O/S\nW-Wolf, O-Orc, S-Succubus : ");
		Enemy enemy1 = enemyRandFactory.createNewEnemy(sc.next().charAt(0));

		System.out.print("[Select Enemy2 type] W/O/S\nW-Wolf, O-Orc, S-Succubus : ");
		Enemy enemy2 = enemyRandFactory.createNewEnemy(sc.next().charAt(0));

		System.out.println();

		Player player1 = new Player("ERIC", 100, 18); // Name, HP, baseDmg
		Player player2 = new Player("JOHN", 150, 24);

		// PvP Mode with Enemies: Player can fight each other, but Enemies are same
		// team.
		if (enemy1 != null || enemy2 != null) {
			player1.printInfo();
			player2.printInfo();
			enemy1.printInfo();
			enemy2.printInfo();
			player1.attack(enemy1);
			player2.attack(player1);
			enemy1.attack(player1);
			enemy2.attack(player2);
			System.out.println("\n");
			player1.printInfo();
			player2.printInfo();
			enemy1.printInfo();
			enemy2.printInfo();
		}
	}
}

class EnemyRandFactory {
	Enemy createNewEnemy(char newEnemyType) {

		int enemyDefaultHP = new Random().nextInt(100) + 50; // 50~100hp
		int enemyDefaultDmg = new Random().nextInt(20) + 10; // 10~20 dmg

		if (newEnemyType == 'W')
			return new Wolf("Wolf", enemyDefaultHP, enemyDefaultDmg);
		else if (newEnemyType == 'O')
			return new Orc("Orc", enemyDefaultHP, enemyDefaultDmg);
		else if (newEnemyType == 'S')
			return new Succubus("Wolf", enemyDefaultHP, enemyDefaultDmg);

		else
			return null;
	}
}

abstract class GameObject {
	private String name;
	private int hp;
	private int baseDmg;

	GameObject(String n, int h, int b) {
		name = n;
		hp = h;
		baseDmg = b;
	}

	abstract void attack(Player p);

	abstract void attack(Enemy e);

	public void printInfo() {
		System.out.printf("%-10s: %-6s, hp:%-3d, baseDmg:%3d \n", this.getClass().getName(), this.getName(),
				this.getHp(), this.getBaseDmg());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getBaseDmg() {
		return baseDmg;
	}

	public void setBaseDmg(int baseDmg) {
		this.baseDmg = baseDmg;
	}
}

class Player extends GameObject {

	Player(String n, int l, int b) {
		super(n, l, b);
	}

	@Override
	void attack(Enemy e) {
		// Player does 200% damage to the enemies.
		e.setHp(e.getHp() - (this.getBaseDmg() * 2));
		System.out.printf("\n%-4s dealt %5d to %4s", this.getName(), (this.getBaseDmg() * 2), e.getName());
	}

	@Override
	void attack(Player p) {
		// Player does 100% damage to other players.
		p.setHp(p.getHp() - this.getBaseDmg());
		System.out.printf("\n%-4s dealt %5d to %4s", this.getName(), this.getBaseDmg(), p.getName());
	}
}

class Enemy extends GameObject {

	Enemy(String n, int h, int b) {
		super(n, h, b);
	}

	@Override
	void attack(Player p) {
		// Enemy does 100% damage to the player.
		p.setHp(p.getHp() - this.getBaseDmg());
		System.out.printf("\n%-4s dealt %5d to %4s", this.getName(), this.getBaseDmg(), p.getName());
	}

	@Override
	void attack(Enemy e) {
		// Enemy attacking another enemy is disabled for now.
		System.out.println("Can't attack same team!");
	}
}

/** the baseDmg gets scaled based on each enemy **/
class Wolf extends Enemy {
	Wolf(String n, int h, int b) {
		super(n, h, b);
	}
}

class Orc extends Enemy {
	Orc(String n, int h, int b) {
		super(n, h, b * 3);
	}
}

class Succubus extends Enemy {
	Succubus(String n, int h, int b) {
		super(n, h, b * 2);
	}
}
