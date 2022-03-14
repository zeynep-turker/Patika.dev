package location;
import inventory.Armor;
import inventory.Weapon;
import obstacle.Obstacle;
import util.Player;
import java.util.Arrays;
import java.util.Random;

public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected String award;
	private int obstacleCount;
	private Random r = new Random();

	BattleLoc(Player player, int id, String name, Obstacle obstacle, String award) {
		super(player, id, name);
		this.obstacle = obstacle;
		this.award = award;
	}

	@Override
	public boolean onLocation() {
		int obsCount = this.getObstacle().getNumber();
		System.out.println("------------------------------------------------------------------");
		System.out.println("Bulundu�unuz Yer : " + this.getName());
		System.out.println("Dikkatli ol! Burada " + obsCount + " tane " + getObstacle().getName() + " ya��yor!");
		System.out.print("Sava�(S) veya Ka�(K) :");

		String selCase = scan.nextLine();
		String[] cases = {"S","s","K","k"};

		while (!(Arrays.asList(cases).contains(selCase))) {
			System.out.print("L�tfen ge�erli bir eylem se�iniz : ");
			selCase = scan.nextLine();
		}
		selCase = selCase.toUpperCase();

		if (selCase.equals("S")) {
			if (combat(obsCount)) {
				System.out.println(this.getName() + " b�lgesindeki t�m d��manlar� temizlediniz!");
				if(obstacle.getId() != 4) {
					System.out.println(this.award + " Kazand�n�z! ");
					if (this.award.equals("Food") && !getPlayer().getInventory().getFood()) {
						getPlayer().getInventory().setFood(true);
					} else if (this.award.equals("Water") && !getPlayer().getInventory().getWater()) {
						getPlayer().getInventory().setWater(true);
					} else if (this.award.equals("Firewood") && !getPlayer().getInventory().getFirewood()) {
						getPlayer().getInventory().setFirewood(true);
					}
				}
				getPlayer().playerInfo();
				return true;
			}
			
			if(getPlayer().getHealth() <= 0) {
				System.out.println("�ld�n�z !");
				return false;
			}
		}
		return true;
	}

	/**
	 * madendeki sava�tan elde edilen random �d�l hesaplan�r
	 */
	public void setBattleAward() {
		if (this.getObstacle().getId() == 4) {
			double randomAward = r.nextInt(99) + 1;
			if (randomAward < 15) {
				double randomWeapon = r.nextInt(99) + 1;
				if (randomWeapon < 20) {
					System.out.println("T�fek Kazand�n");
					this.getPlayer().getInventory().setWeapon(new Weapon("T�fek", 3, 7, 45));
				} else if (randomWeapon < 50) {
					System.out.println("K�l�� Kazand�n");
					this.getPlayer().getInventory().setWeapon(new Weapon("K�l��", 2, 3, 35));
				} else {
					System.out.println("Tabanca Kazand�n");
					this.getPlayer().getInventory().setWeapon(new Weapon("Tabanca", 1, 2, 25));
				}
				this.getPlayer().setDamage(this.getPlayer().getInventory().getWeapon().getDamage());
			} else if (randomAward < 30) {
				double randomArmor = r.nextInt(99) + 1;
				if (randomArmor < 20) {
					System.out.println("A��r Z�rh Kazand�n");
					this.getPlayer().getInventory().setArmor(new Armor(3, "A��r", 5, 40));
				} else if (randomArmor < 50) {
					System.out.println("Orta Z�rh Kazand�n");
					this.getPlayer().getInventory().setArmor(new Armor(2, "Orta", 3, 25));
				} else {
					System.out.println("Hafif Z�rh Kazand�n");
					this.getPlayer().getInventory().setArmor(new Armor(1, "Hafif", 1, 15));
				}
				int newHealthy = this.getPlayer().getHealth() + Armor.getArmorObjById(3).getBlock();
				this.getPlayer().setHealth(newHealthy);

			} else if (randomAward < 55) {
				double randomPrice = r.nextInt(99) + 1;
				int newPrice = 0;
				if (randomPrice < 20) {
					System.out.println("10 Para Kazand�n");
					newPrice = this.getPlayer().getMoney() + 10;
					this.getPlayer().setMoney(newPrice);

				} else if (randomPrice < 50) {
					System.out.println("5 Para Kazand�n");
					newPrice = this.getPlayer().getMoney() + 5;

				} else {
					System.out.println("1 Para Kazand�n");
					newPrice = this.getPlayer().getMoney() + 1;
				}
				this.getPlayer().setMoney(newPrice);
			} else {
				System.out.println("Hi�bir �ey kazanamad�n�z :(");
			}
			System.out.println();
		}
	}

	/**
	 * oyuncu ve canavar aras�nda ilk kimin ba�layaca�� %50 �ans ile hesaplan�r
	 * @return ilk kimin vuraca��
	 */
	private int whoStart() {
		int whoStart = r.nextInt(2) + 1;
		if(whoStart == 1) {
			System.out.println("�lk siz vuracaks�n�z\n");
		}
		else {
			System.out.println("�lk "+ getObstacle().getName() + " vuracak\n");
		}
		return whoStart;
	}

	/**
	 *
	 * @param obsCount canavar say�s�
	 * @return e�er oyuncu t�m d��manlar� yendiyse true aksi takdirde false
	 */
	public boolean combat(int obsCount) {
		for (int i = 0; i < obsCount; i++) {
			System.out.println("\n****** "+(i+1)+". "+ obstacle.getName() +" ile Sava� Ba�l�yor!******");
			int whoStart = whoStart();
			int defObsHealth = obstacle.getHealth();
			//oyuncu ve canavar�n g�ncel de�erleri g�sterilir
			playerValues();
			obstacleValues();
			while (getPlayer().getHealth() > 0 && obstacle.getHealth() > 0) {
				if(whoStart == 1){ //s�ra oyuncuda ise
					if(getPlayer().getHealth() > 0) {
						System.out.println("Vur(V) veya Ka�(K) :");

						String selCase = scan.nextLine();
						selCase = selCase.toUpperCase();
						if (selCase.equals("V")) {
							System.out.println("Siz vurdunuz!");
							int damage = obstacle.getHealth() - getPlayer().getTotalDamage();
							if(obstacle.getHealth() - getPlayer().getTotalDamage() < 0)
								damage = 0;
							obstacle.setHealth(damage);
							currentValues();
						} else {
							return false;
						}
					}
				}
				else { //s�ra canavarda ise
					if (obstacle.getHealth() > 0) {
						System.out.println(obstacle.getName() + " size vurdu!");
						getPlayer().setHealth(getPlayer().getHealth() - (obstacle.getDamage() - getPlayer().getInventory().getArmor().getBlock()));
						currentValues();
					}
				}
				//s�ralar de�i�ir
				if(whoStart == 1) whoStart = 2;
				else if(whoStart == 2) whoStart = 1;
			}

			if (obstacle.getHealth() < getPlayer().getHealth()) {
				System.out.println((i+1) + ". " + obstacle.getName() + " �ld�" );

				if(obstacle.getId() != 4) {
					getPlayer().setMoney(getPlayer().getMoney() + obstacle.getAward());
					System.out.println(obstacle.getAward() + " Para Kazand�n�z");
				}
				else {
					setBattleAward();
				}
				obstacle.setHealth(defObsHealth);
			} else {
				return false;
			}
		}
		return true;
	}

	public void playerValues() {
		System.out.println("--------Oyuncu De�erleri--------");
		getPlayer().playerInfo();
	}

	public void obstacleValues() {
		System.out.println("---------"+obstacle.getName() + " De�erleri----------");
		System.out.print("Can: " + obstacle.getHealth() + " Hasar: " + obstacle.getDamage());
		if(obstacle.getId() != 4)
			System.out.print(" �d�l: " + obstacle.getAward());
		else {
			System.out.print(" �d�l: " + "Para/Silah/Z�rh");
		}
		System.out.println();
		System.out.println();
	}

	public void currentValues() {
		System.out.println("Oyuncu Can�: " + getPlayer().getHealth());
		System.out.println(obstacle.getName() + " Can�: " + obstacle.getHealth());
		System.out.println();
	}

	public Obstacle getObstacle() {
		return obstacle;
	}

	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}

	public int getObstacleCount() {
		return obstacleCount;
	}

	public void setObstacleCount(int obstacleCount) {
		this.obstacleCount = obstacleCount;
	}

	public Random getR() {
		return r;
	}

	public void setR(Random r) {
		this.r = r;
	}
}
