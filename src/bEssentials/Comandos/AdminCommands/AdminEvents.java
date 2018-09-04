package bEssentials.Comandos.AdminCommands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import bEssentials.Prefix;

public class AdminEvents implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		for (Player adm : Commandadmin.admin){
			if (adm.isOnline()){
				p.hidePlayer(adm);
				if (p.hasPermission("StewHG.Admin")){
					p.showPlayer(adm);
				}
			}
		}
	}
	
	@EventHandler
	public void noPickup(PlayerPickupItemEvent e){
		Player p = e.getPlayer();
		if (Commandadmin.admin.contains(p)){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void noDrop(PlayerDropItemEvent e){
		Player p = e.getPlayer();
		if (Commandadmin.admin.contains(p)){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void Inventory1(PlayerInteractEntityEvent e){
		Player p = e.getPlayer();
		if (e.getRightClicked() instanceof Player){
			if (Commandadmin.admin.contains(p)){
				if (p.getItemInHand().getType() == Material.AIR){
					Player p2 = (Player)e.getRightClicked();
					p.sendMessage(Prefix.PREFIX_SUCESS+"Você abriu o inventário do §f"+p2.getName());
					p.openInventory(p2.getInventory());
				}
			}
		}
	}
}
