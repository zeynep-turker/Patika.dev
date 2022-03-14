package location;

import util.Player;

public abstract class NormalLoc extends Location {

	NormalLoc(Player player, int id, String name) {
		super(player, id, name);
	}
	
	@Override
	public boolean onLocation() {
		return true;
	}
}
