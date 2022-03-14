package util;

import location.*;
import util.Player;

import java.util.Scanner;

public class Game {
	Player player;
	Location chosenLocation = null;
	Scanner scan = new Scanner(System.in);

	public void login() {
		Scanner in = new Scanner(System.in);
		System.out.println("Macera Oyununa Hoþgeldiniz!");
		System.out.println("Oyuna baþlamadan önce isminizi giriniz : ");
		String playerName = in.nextLine();
		player = new Player(playerName);
		player.selectChar();
		start();
	}

	public void printCompleteSuccess() {
		System.out.println("Bu yerdeki görevini baþarýlý bir þekilde gerçekleþtirdin.");
	}

	/**
	 * Oyunun asýl yönetildiði kýsýmdýr
	 */
	public void start() {
		boolean temp = true;
		Location [] locations = {new SafeHouse(player),new ToolStore(player), new Cave(player), new Forest(player), new River(player), new Mine(player) };
		while (temp) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("Gitmek istediðiniz yeri seçiniz : ");

			for (int i=0; i<locations.length; ++i)
				System.out.println("ID: "+ locations[i].getId() + " Yer: "+ locations[i].getName());
			System.out.println("ID: 0 Çýkýþ");
			System.out.print("Gitmek istediðiniz yer : ");

			int selLoc = scan.nextInt();
			while (selLoc < 0 || selLoc > 6) {
				System.out.print("Lütfen geçerli bir yer seçiniz : ");
				selLoc = scan.nextInt();
			}

			chosenLocation = null;
			switch (selLoc) {
			case 1:
				chosenLocation = new SafeHouse(player); //oyuncunun canýnýn yenilendiði yerdir
				break;
			case 2:
				chosenLocation = new ToolStore(player); //oyuncunun envanter satýn alabileceði yerdir
				break;
			case 3:
				if (player.getInventory().getFood()) { //oyuncu, maðaradaki görevini yerine getirdiyse bu yere bir daha gidilmez
					printCompleteSuccess();
					break;
				}
				chosenLocation = new Cave(player);
				break;
			case 4:
				if(player.getInventory().getFirewood()) { //oyuncu, ormandaki görevini yerine getirdiyse bu yere bir daha gidilmez
					printCompleteSuccess();
					break;
				}
				chosenLocation = new Forest(player);
				break;
			case 5:
				if(player.getInventory().getWater()) { //oyuncu, nehirdeki görevini yerine getirdiyse bu yere bir daha gidilmez
					printCompleteSuccess();
					break;
				}
				chosenLocation = new River(player);
				break;
			case 6:
				chosenLocation = new Mine(player);
				break;
			case 0:
				temp = false;
				System.out.println("Oyun Bitti!");
				break;
			default:
				chosenLocation = new SafeHouse(player);
			}
			if(chosenLocation != null) {
				if (!chosenLocation.onLocation()) {
					System.out.println("Oyun Bitti!");
					break;
				}
			}
		}
	}
}
