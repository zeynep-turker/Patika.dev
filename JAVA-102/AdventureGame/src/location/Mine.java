package location;

import obstacle.Snake;
import util.Player;

public class Mine extends BattleLoc { //Ödev 3 (Yeni bir savaş alanı eklendi)

    public Mine(Player player) {
        super(player, 6,"Maden", new Snake(),"Award/inventory.Weapon/inventory.Armor");
    }
}
