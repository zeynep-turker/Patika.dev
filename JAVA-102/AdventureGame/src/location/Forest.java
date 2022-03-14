package location;

import obstacle.Vampire;
import util.Player;

public class Forest extends BattleLoc {

	public Forest(Player player) {
		super(player, 4,"Orman", new Vampire(),"Firewood");
	}
}
