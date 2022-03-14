package location;

import util.Player;

public class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player, 1,"Güvenli Ev");
	}
	
	public boolean onLocation() {
		boolean food = this.getPlayer().getInventory().getFood();
		boolean firewood = this.getPlayer().getInventory().getFirewood();
		boolean water = this.getPlayer().getInventory().getWater();
		if(food && firewood && water){ //Oyuncu orman, nehir ve maðaradaki görevini yerine getirip 'Güvenli Ev'e döndüðünde oyunu bitirir
			System.out.println(this.getPlayer().getName() + " Tebrikler. Bütün görevlerinizi tamamlamýþ bulunmaktasýnýz.");
			return false;
		}
		else {
			if(this.getPlayer().getHealth() == this.getPlayer().getActualHealth()) { //oyuncunun caný zaten full ise oyuncuya bu bilgi bildirilir
				System.out.println("Canýn zaten full!");
				return true;
			}
			this.getPlayer().setHealth(this.getPlayer().getActualHealth()); //caný full deðilse caný karakterin asýl canýna getirilir
			System.out.println("Güvenli eve geldiniz. Ýyileþeceksiniz..");
			System.out.println("Ýyileþtiniz...");
			System.out.println(getName() + " güncel deðerlerin aþaðýdaki gibidir");
			getPlayer().playerInfo();
			return true;
		}
	}
}
