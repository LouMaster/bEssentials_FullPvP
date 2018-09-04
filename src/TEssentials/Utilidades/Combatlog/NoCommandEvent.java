package TEssentials.Utilidades.Combatlog;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import bEssentials.Prefix;

public class NoCommandEvent implements Listener {

	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		
		if (EntityAttack.combattag.contains(p.getName())){
			e.setCancelled(true);
			
			p.sendMessage(Prefix.PREFIX_COMBAT+"Você está em combate, não pode usar nenhum comando!");
			return;
		}
	}
}
