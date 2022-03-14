package location;

import util.Player;
import java.util.Scanner;

public abstract class Location {
	private Player player;
	private int id;
	protected String name;
	Scanner scan = new Scanner(System.in);
	
	Location(Player player, int id, String name){
		this.player = player;
		this.id = id;
		this.name = name;
	}
	
	public abstract boolean onLocation();

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
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
	
	
}
