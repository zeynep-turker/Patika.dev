package location;

import obstacle.Zombie;
import util.Player;

public class Cave extends BattleLoc {

	public Cave(Player player) {
		super(player,3, "Ma�ara", new Zombie(),"Food");
	}

}
