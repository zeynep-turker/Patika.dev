package inventory;

public class Inventory {
	private Weapon weapon;
	private Armor armor;
	boolean water;
	boolean firewood;
	boolean food;

	public Inventory(){
		this.weapon = new Weapon("Yumruk", 0, 0, 0);
		this.armor = new Armor(0, "Paçavra", 0, 0);
		this.water = false;
		this.firewood = false;
		this.food = false;
	}

	public boolean getWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}

	public boolean getFirewood() {
		return firewood;
	}

	public void setFirewood(boolean firewood) {
		this.firewood = firewood;
	}

	public boolean getFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}
}
