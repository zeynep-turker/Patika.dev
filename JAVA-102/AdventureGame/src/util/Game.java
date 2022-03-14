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
		System.out.println("Macera Oyununa Ho�geldiniz!");
		System.out.println("Oyuna ba�lamadan �nce isminizi giriniz : ");
		String playerName = in.nextLine();
		player = new Player(playerName);
		player.selectChar();
		start();
	}

	public void printCompleteSuccess() {
		System.out.println("Bu yerdeki g�revini ba�ar�l� bir �ekilde ger�ekle�tirdin.");
	}

	/**
	 * Oyunun as�l y�netildi�i k�s�md�r
	 */
	public void start() {
		boolean temp = true;
		Location [] locations = {new SafeHouse(player),new ToolStore(player), new Cave(player), new Forest(player), new River(player), new Mine(player) };
		while (temp) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("Gitmek istedi�iniz yeri se�iniz : ");

			for (int i=0; i<locations.length; ++i)
				System.out.println("ID: "+ locations[i].getId() + " Yer: "+ locations[i].getName());
			System.out.println("ID: 0 ��k��");
			System.out.print("Gitmek istedi�iniz yer : ");

			int selLoc = scan.nextInt();
			while (selLoc < 0 || selLoc > 6) {
				System.out.print("L�tfen ge�erli bir yer se�iniz : ");
				selLoc = scan.nextInt();
			}

			chosenLocation = null;
			switch (selLoc) {
			case 1:
				chosenLocation = new SafeHouse(player); //oyuncunun can�n�n yenilendi�i yerdir
				break;
			case 2:
				chosenLocation = new ToolStore(player); //oyuncunun envanter sat�n alabilece�i yerdir
				break;
			case 3:
				if (player.getInventory().getFood()) { //oyuncu, ma�aradaki g�revini yerine getirdiyse bu yere bir daha gidilmez
					printCompleteSuccess();
					break;
				}
				chosenLocation = new Cave(player);
				break;
			case 4:
				if(player.getInventory().getFirewood()) { //oyuncu, ormandaki g�revini yerine getirdiyse bu yere bir daha gidilmez
					printCompleteSuccess();
					break;
				}
				chosenLocation = new Forest(player);
				break;
			case 5:
				if(player.getInventory().getWater()) { //oyuncu, nehirdeki g�revini yerine getirdiyse bu yere bir daha gidilmez
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
