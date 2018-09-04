package TEssentials.Utilidades.Combatlog;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class KickEvent implements Listener {

	@EventHandler
	public void onKick(PlayerKickEvent e){
		Player p = e.getPlayer();
		
		if (EntityAttack.combattag.contains(p.getName())){
			EntityAttack.combattag.remove(p.getName());
		}
	}
}
