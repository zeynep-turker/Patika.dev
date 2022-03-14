package util;

import character.Archer;
import character.GameChar;
import character.Knight;
import character.Samurai;
import inventory.Inventory;
import java.util.Scanner;

public class Player {
	private int damage, health, money, actualHealth;
	private String name, charName;
	private Inventory inventory;
	Scanner scan = new Scanner(System.in);

	public Player(String name) {
		this.name = name;
		this.inventory = new Inventory();
	}

	/**
	 *
	 * @return oyuncunun se�mi� oldu�u karakter id'si
	 */
	public int charMenu() {
		GameChar[] chars = {new Samurai(), new Archer(), new Knight()};
		System.out.println("------------------------------------------------------------------");
		System.out.println("L�tfen bir karakter se�iniz : ");
		for(int i=0 ; i<chars.length; ++i) {
			System.out.println("ID: " + chars[i].getId() +
					"\t\t Karakter: "+ chars[i].getName() +
					"\t\t Hasar: " + chars[i].getDamage() +
					"\t\t Sa�l�k: " + chars[i].getHealth() +
					"\t\t Para: " + chars[i].getMoney());
		}
		System.out.print("L�tfen bir karakter se�iniz: ");
		int charID = scan.nextInt();

		while (charID < 1 || charID > 3) {
			System.out.print("L�tfen ge�erli bir karakter se�iniz: ");
			charID = scan.nextInt();
		}
		return charID;
	}

	/**
	 * oyunucuya karakter men�s� g�sterilir
	 */
	public void selectChar() {
		switch (charMenu()) {
		case 1:
			initPlayer(new Samurai());
			break;
		case 2:
			initPlayer(new Archer());
			break;
		case 3:
			initPlayer(new Knight());
			break;
		default:
			initPlayer(new Samurai());
			break;
		}
		System.out.println("Karakteriniz Olu�turuldu!\nAd�: " + getCharName() + " Hasar: " + getDamage() + " Sa�l�k: "
				+ getHealth() + " Para:" + getMoney());
	}

	/**
	 *
	 * @return oyuncunun silah ile olan damage'i
	 */
	public int getTotalDamage() {
		return this.getDamage() + this.getInventory().getWeapon().getDamage();
	}

	/**
	 * oyuncunun g�ncel bilgileri g�sterilir
	 */
	public void playerInfo() {
		System.out.println("Can: " + getHealth() + " Hasar: " + getTotalDamage() + " Para: " + getMoney());
		if (getInventory().getWeapon().getDamage() > 0) {
			System.out.print(" Silah: " + getInventory().getWeapon().getName());
		}
		if (getInventory().getArmor().getBlock() > 0) {
			System.out.print(" Z�rh: " + getInventory().getArmor().getBlock());
		}
		System.out.println();
	}

	public void initPlayer(GameChar gameChar) {
		setCharName(gameChar.getName());
		setDamage(gameChar.getDamage());
		setHealth(gameChar.getHealth());
		setMoney(gameChar.getMoney());
		setActualHealth(gameChar.getHealth());
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if(health < 0)
			this.health = 0;
		else this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getActualHealth() {
		return actualHealth;
	}

	public void setActualHealth(int actualHealth) {
		this.actualHealth = actualHealth;
	}
}
