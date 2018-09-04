package bEssentials.Eventos;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Chat implements Listener {
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		if(e.getPlayer().getName().equalsIgnoreCase("LouMaster")){
			return;
		}
		if (e.getMessage().toLowerCase().startsWith("/me")) {
			e.setCancelled(true);
		} else if (e.getMessage().toLowerCase().startsWith("/bukkit:me")) {
			e.setCancelled(true);
		} else if (e.getMessage().toLowerCase().startsWith("/plugins")) {
			e.setCancelled(true);
		} else if (e.getMessage().toLowerCase().startsWith("/bukkit:plugins")) {
			e.setCancelled(true);
		} else if (e.getMessage().toLowerCase().startsWith("/pl")) {
			e.setCancelled(true);
		} else if (e.getMessage().toLowerCase().startsWith("/bukkit:pl")) {
			e.setCancelled(true);
		} else if (e.getMessage().toLowerCase().startsWith("/version")) {
			e.setCancelled(true);
		} else if (e.getMessage().toLowerCase().startsWith("/ver")) {
			e.setCancelled(true);
		} else if (e.getMessage().toLowerCase().startsWith("/?")) {
			e.setCancelled(true);
		} else if (e.getMessage().toLowerCase().startsWith("/tellraw")) {
			e.setCancelled(true);
		} else if (e.getMessage().toLowerCase().startsWith("/?")){
			e.setCancelled(true);
		} else if (e.getMessage().toLowerCase().startsWith("/ver")){
			e.setCancelled(true);
		} else if (e.getMessage().toLowerCase().startsWith("/version")){
			e.setCancelled(true);
		} else if (e.getMessage().toLowerCase().startsWith("/tellraw")){
			e.setCancelled(true);
		} else if (e.getMessage().toLowerCase().startsWith("/kill")){
			e.setCancelled(true);
		} else if (e.getMessage().toLowerCase().startsWith("/help")){
			e.setCancelled(true);
		}
	}
}
