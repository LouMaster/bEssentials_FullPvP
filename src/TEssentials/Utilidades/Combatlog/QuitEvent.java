package TEssentials.Utilidades.Combatlog;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import bEssentials.Prefix;

public class QuitEvent implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		
		if (EntityAttack.combattag.contains(p.getName())){
			p.setHealth(0);
			
			EntityAttack.combattag.remove(p.getName());
			Bukkit.broadcastMessage(Prefix.PREFIX_COMBAT+p.getName()+" saiu no meio do combate, que vergonha!");
		}
	}
}
