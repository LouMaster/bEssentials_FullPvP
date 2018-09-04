package bEssentials.Comandos.ChatCommands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.scheduler.BukkitScheduler;

import MySQL.API.PrisionUtil;
import bEssentials.Main;
import bEssentials.Prefix;
import bEssentials.Comandos.AdminCommands.Commandadmin;
import bUtils.Packets.Tags.TagAPI;

@SuppressWarnings("deprecation")
public class ChatEvent implements Listener {

	public static int delay_chat_local;
	public static ArrayList<String> delay_local_chat = new ArrayList<String>();
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onChatPlayer(PlayerChatEvent e){
		final Player p = e.getPlayer();
		String radius = e.getMessage().toString();
	    Object scheduler1;
	    
	    if (!delay_local_chat.contains(p.getName())){
	    	if (!p.hasPermission("bEssentials.bypass")){
	    		if (ChatCommand.chat){
		    		if (jogadorChat(p) != null){
		    			Player p2 = jogadorChat(p);
		    			
		    			p2.sendMessage("§e[l] §7[§6"+PrisionUtil.getClan(p.getUniqueId().toString())+"§7] "+TagAPI.getNametag(p.getName())+"§e: "+radius);
						p.sendMessage("§e[l] §7[§6"+PrisionUtil.getClan(p.getUniqueId().toString())+"§7] "+TagAPI.getNametag(p.getName())+"§e: "+radius);
		    		} else {
						p.sendMessage("§e[l] §7[§6"+PrisionUtil.getClan(p.getUniqueId().toString())+"§7] "+TagAPI.getNametag(p.getName())+"§e: "+radius);
						p.sendMessage("§eNinguém próximo para receber a mensagem.");
		    		}
	    			delay_local_chat.add(p.getName());
	    			scheduler1 = Bukkit.getScheduler();
	    			delay_chat_local = ((BukkitScheduler)scheduler1).scheduleSyncDelayedTask(Main.plugin, new Runnable() {
						public void run() {
							delay_local_chat.remove(p.getName());
						}
					}, 100L);	
	    		} else {
	    			p.sendMessage(Prefix.PREFIX_ERROR+"Chat está desabilitado.");
	    		}
	    	} else {
	    		if (jogadorChat(p) != null){
	    			Player p2 = jogadorChat(p);
	    			
	    			p2.sendMessage("§e[l] §7[§6"+PrisionUtil.getClan(p.getUniqueId().toString())+"§7] "+TagAPI.getNametag(p.getName())+"§e: "+radius);
					p.sendMessage("§e[l] §7[§6"+PrisionUtil.getClan(p.getUniqueId().toString())+"§7] "+TagAPI.getNametag(p.getName())+"§e: "+radius);
	    		} else {
					p.sendMessage("§e[l] §7[§6"+PrisionUtil.getClan(p.getUniqueId().toString())+"§7] "+TagAPI.getNametag(p.getName())+"§e: "+radius);
					p.sendMessage("§eNinguém próximo para receber a mensagem.");
	    		}
	    	}
	    } else {
	    	p.sendMessage(Prefix.PREFIX_ERROR+"Espere para falar no chat novamente.");
	    }
	    
	    e.setCancelled(true);
	}
	
	public Player jogadorChat(Player p){
		Player target = null;
		for (Entity ent : p.getNearbyEntities(100D, 100D, 100D)){
			if (ent instanceof Player){
				Player p1 = (Player)ent;
				if (!Commandadmin.admin.contains(p1.getName())){
					if (ent != p){
						target = (Player) ent;
					}
				}
			}
		}
		
		return target;
	}
}
