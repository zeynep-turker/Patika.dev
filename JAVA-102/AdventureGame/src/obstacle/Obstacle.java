package obstacle;

import java.util.Random;

public class Obstacle {
	private int id;
	private String name;
	private int damage, award, health, number;
	Random r = new Random();

	public Obstacle(String name, int id, int damage, int health, int award, int maxNumber) {
		this.id = id;
		this.name = name;
		if(id==4) this.damage = randomNumber(3,6);
		else this.damage = damage;
		this.award = award;
		this.health = health;
		this.number = this.randomNumber(1, maxNumber);
	}
	
	public int randomNumber(int minNumber, int maxNumber) {
		return r.nextInt(maxNumber-minNumber) + minNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getAward() {
		return award;
	}

	public void setAward(int award) {
		this.award = award;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
