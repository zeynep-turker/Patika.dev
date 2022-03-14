package location;

import inventory.Armor;
import inventory.Weapon;
import util.Player;

public class ToolStore extends NormalLoc {

	public ToolStore(Player player) {
		super(player, 2, "Ma�aza");
	}

	@Override
	public boolean onLocation() {
		System.out.println("Ma�azaya Ho�geldiniz");
		System.out.println("Paran�z: " + getPlayer().getMoney());
		System.out.println("1. Silahlar");
		System.out.println("2. Z�rhlar");
		System.out.println("3. ��k��");
		System.out.print("Se�iminiz: ");

		int selTool = scan.nextInt();
		while(selTool<1 || selTool> 3){
			System.out.println("L�tfen ge�erli bir say� giriniz.");
			selTool = scan.nextInt();
		}

		int selItemID;
		switch (selTool) {
		case 1:
			selItemID = weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2:
			selItemID = armorMenu();
			buyArmor(selItemID);
			break;
		default:
			break;
		}

		return true;
	}

	/**
	 * oyuncuya silah men�s� g�sterilir
	 * @return oyuncunun silah se�imi
	 */
	public int weaponMenu() {
		System.out.println("\n----- Silahlar -----");
		for(Weapon w: Weapon.weapons()) {
			System.out.println("ID: " + w.getId() + " Ad: " + w.getName() + " Para: " + w.getPrice() + " Hasar: " + w.getDamage());
		}
		System.out.println("ID: 4 ��k��");
		System.out.print("Silah Se�iniz : ");
		int selWeaponID = scan.nextInt();
		while (selWeaponID < 1 ||selWeaponID > 4) {//oyuncu ge�ersiz se�im yaparsa oyuncuya tekrardan se�im yapt�r�l�r
			System.out.println("L�tfen ge�erli bir se�im yap�n�z");
			selWeaponID = scan.nextInt();
		}
		return selWeaponID;
	}

	/**
	 * oyuncunun se�imine g�re silah oyuncunun envanterine atan�r
	 * @param itemID oyunucunun se�ti�i silah�n id'si
	 */
	public void buyWeapon(int itemID) {
		Weapon selectedWeapon = null;
		switch (itemID) {
		case 1:
		case 2:
		case 3:
			selectedWeapon = Weapon.getWeaponObjById(itemID);
			break;
		case 4:
			System.out.println("��k�l�yor..");
			break;
		default:
			System.out.println("Ge�ersiz ��lem!");
			break;
		}
		if(selectedWeapon != null) {
			if (selectedWeapon.getPrice() > 0) { //oyuncunun yeterli paras� var ise gerekli i�lemler yap�l�r
				if (getPlayer().getMoney() > selectedWeapon.getPrice()) {
					getPlayer().getInventory().getWeapon().setDamage(selectedWeapon.getDamage());
					getPlayer().getInventory().getWeapon().setName(selectedWeapon.getName());
					getPlayer().setMoney(getPlayer().getMoney() - selectedWeapon.getPrice());
					System.out.println(selectedWeapon.getName() + " sat�n ald�n�z, �nceki Hasar :" + getPlayer().getDamage() + ", Yeni Hasar : "
							+ getPlayer().getTotalDamage());
					System.out.println("Kalan Para :" + getPlayer().getMoney());
				} else {
					System.out.println("Para yetersiz");
				}
			}
		}
	}

	/**
	 * oyuncuya z�rh men�s� g�sterilir
	 * @return oyuncunun z�rh se�imi
	 */
	public int armorMenu() {
		System.out.println("\n----- Silahlar -----");
		for(Armor a: Armor.armors()) {
			System.out.println("ID: "+a.getId() + " Ad: " + a.getName() + " Para: " + a.getPrice() + " Z�rh: " + a.getBlock());
		}
		System.out.println("ID: 4 ��k��");
		System.out.print("Silah Se�iniz : ");
		int selArmorID = scan.nextInt();
		while (selArmorID < 1 ||selArmorID > 4) { //oyuncu ge�ersiz bir se�im yapm�� ise tekrardan se�im yapt�r�l�r
			System.out.println("L�tfen ge�erli bir se�im yap�n�z");
			selArmorID = scan.nextInt();
		}
		return selArmorID;
	}

	/**
	 * oyuncunun se�imine g�re z�rh oyuncunun envanterine atan�r
	 * @param itemID oyuncunun se�mi� oldu�u z�rh id'si
	 */
	public void buyArmor(int itemID) {
		Armor selectedArmor = null;
		switch (itemID) {
			case 1:
			case 2:
			case 3:
				selectedArmor = Armor.getArmorObjById(itemID);
				break;
			case 4:
				System.out.println("��k�l�yor..");
				break;
			default:
				System.out.println("Ge�ersiz ��lem!");
				break;
		}
		if(selectedArmor != null) {
			if (selectedArmor.getPrice() > 0) { //oyuncunun yeterli paras� var ise gerekli i�lemler yap�l�r
				if (getPlayer().getMoney() >= selectedArmor.getPrice()) {
					getPlayer().getInventory().getArmor().setBlock(selectedArmor.getBlock());
					getPlayer().getInventory().getArmor().setName(selectedArmor.getName());
					getPlayer().setMoney(getPlayer().getMoney() - selectedArmor.getPrice());
					System.out.println(selectedArmor.getName() + " sat�n ald�n�z, Engellenen Hasar : " + getPlayer().getInventory().getArmor());
					System.out.println("Kalan Para :" + getPlayer().getMoney());
				} else {
					System.out.println("Para yetersiz");
				}
			}
		}
	}
}
