package location;

import inventory.Armor;
import inventory.Weapon;
import util.Player;

public class ToolStore extends NormalLoc {

	public ToolStore(Player player) {
		super(player, 2, "Maðaza");
	}

	@Override
	public boolean onLocation() {
		System.out.println("Maðazaya Hoþgeldiniz");
		System.out.println("Paranýz: " + getPlayer().getMoney());
		System.out.println("1. Silahlar");
		System.out.println("2. Zýrhlar");
		System.out.println("3. Çýkýþ");
		System.out.print("Seçiminiz: ");

		int selTool = scan.nextInt();
		while(selTool<1 || selTool> 3){
			System.out.println("Lütfen geçerli bir sayý giriniz.");
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
	 * oyuncuya silah menüsü gösterilir
	 * @return oyuncunun silah seçimi
	 */
	public int weaponMenu() {
		System.out.println("\n----- Silahlar -----");
		for(Weapon w: Weapon.weapons()) {
			System.out.println("ID: " + w.getId() + " Ad: " + w.getName() + " Para: " + w.getPrice() + " Hasar: " + w.getDamage());
		}
		System.out.println("ID: 4 Çýkýþ");
		System.out.print("Silah Seçiniz : ");
		int selWeaponID = scan.nextInt();
		while (selWeaponID < 1 ||selWeaponID > 4) {//oyuncu geçersiz seçim yaparsa oyuncuya tekrardan seçim yaptýrýlýr
			System.out.println("Lütfen geçerli bir seçim yapýnýz");
			selWeaponID = scan.nextInt();
		}
		return selWeaponID;
	}

	/**
	 * oyuncunun seçimine göre silah oyuncunun envanterine atanýr
	 * @param itemID oyunucunun seçtiði silahýn id'si
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
			System.out.println("Çýkýlýyor..");
			break;
		default:
			System.out.println("Geçersiz Ýþlem!");
			break;
		}
		if(selectedWeapon != null) {
			if (selectedWeapon.getPrice() > 0) { //oyuncunun yeterli parasý var ise gerekli iþlemler yapýlýr
				if (getPlayer().getMoney() > selectedWeapon.getPrice()) {
					getPlayer().getInventory().getWeapon().setDamage(selectedWeapon.getDamage());
					getPlayer().getInventory().getWeapon().setName(selectedWeapon.getName());
					getPlayer().setMoney(getPlayer().getMoney() - selectedWeapon.getPrice());
					System.out.println(selectedWeapon.getName() + " satýn aldýnýz, Önceki Hasar :" + getPlayer().getDamage() + ", Yeni Hasar : "
							+ getPlayer().getTotalDamage());
					System.out.println("Kalan Para :" + getPlayer().getMoney());
				} else {
					System.out.println("Para yetersiz");
				}
			}
		}
	}

	/**
	 * oyuncuya zýrh menüsü gösterilir
	 * @return oyuncunun zýrh seçimi
	 */
	public int armorMenu() {
		System.out.println("\n----- Silahlar -----");
		for(Armor a: Armor.armors()) {
			System.out.println("ID: "+a.getId() + " Ad: " + a.getName() + " Para: " + a.getPrice() + " Zýrh: " + a.getBlock());
		}
		System.out.println("ID: 4 Çýkýþ");
		System.out.print("Silah Seçiniz : ");
		int selArmorID = scan.nextInt();
		while (selArmorID < 1 ||selArmorID > 4) { //oyuncu geçersiz bir seçim yapmýþ ise tekrardan seçim yaptýrýlýr
			System.out.println("Lütfen geçerli bir seçim yapýnýz");
			selArmorID = scan.nextInt();
		}
		return selArmorID;
	}

	/**
	 * oyuncunun seçimine göre zýrh oyuncunun envanterine atanýr
	 * @param itemID oyuncunun seçmiþ olduðu zýrh id'si
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
				System.out.println("Çýkýlýyor..");
				break;
			default:
				System.out.println("Geçersiz Ýþlem!");
				break;
		}
		if(selectedArmor != null) {
			if (selectedArmor.getPrice() > 0) { //oyuncunun yeterli parasý var ise gerekli iþlemler yapýlýr
				if (getPlayer().getMoney() >= selectedArmor.getPrice()) {
					getPlayer().getInventory().getArmor().setBlock(selectedArmor.getBlock());
					getPlayer().getInventory().getArmor().setName(selectedArmor.getName());
					getPlayer().setMoney(getPlayer().getMoney() - selectedArmor.getPrice());
					System.out.println(selectedArmor.getName() + " satýn aldýnýz, Engellenen Hasar : " + getPlayer().getInventory().getArmor());
					System.out.println("Kalan Para :" + getPlayer().getMoney());
				} else {
					System.out.println("Para yetersiz");
				}
			}
		}
	}
}
