package location;

import util.Player;

public class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player, 1,"G�venli Ev");
	}
	
	public boolean onLocation() {
		boolean food = this.getPlayer().getInventory().getFood();
		boolean firewood = this.getPlayer().getInventory().getFirewood();
		boolean water = this.getPlayer().getInventory().getWater();
		if(food && firewood && water){ //Oyuncu orman, nehir ve ma�aradaki g�revini yerine getirip 'G�venli Ev'e d�nd���nde oyunu bitirir
			System.out.println(this.getPlayer().getName() + " Tebrikler. B�t�n g�revlerinizi tamamlam�� bulunmaktas�n�z.");
			return false;
		}
		else {
			if(this.getPlayer().getHealth() == this.getPlayer().getActualHealth()) { //oyuncunun can� zaten full ise oyuncuya bu bilgi bildirilir
				System.out.println("Can�n zaten full!");
				return true;
			}
			this.getPlayer().setHealth(this.getPlayer().getActualHealth()); //can� full de�ilse can� karakterin as�l can�na getirilir
			System.out.println("G�venli eve geldiniz. �yile�eceksiniz..");
			System.out.println("�yile�tiniz...");
			System.out.println(getName() + " g�ncel de�erlerin a�a��daki gibidir");
			getPlayer().playerInfo();
			return true;
		}
	}
}
