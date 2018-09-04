package TEssentials.Utilidades.Combatlog;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {

	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		if (e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			
			if (EntityAttack.combattag.contains(p.getName())){
				EntityAttack.combattag.remove(p.getName());
			}
		}
	}
}
