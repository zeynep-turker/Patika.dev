package location;

import obstacle.Bear;
import util.Player;

public class River extends BattleLoc {

	public River(Player player) {
		super(player, 5,"Nehir", new Bear(),"Water");
	}

}
