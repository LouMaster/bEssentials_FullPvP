package TEssentials.Utilidades.Combatlog;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import bEssentials.Main;
import bEssentials.Prefix;

public class EntityAttack implements Listener {

	public static ArrayList<String> combattag = new ArrayList<>();
	public static HashMap<String, Integer> noUse = new HashMap<>();
	
	@EventHandler
	public void onEntity(EntityDamageByEntityEvent e){
		if (e.isCancelled()){
			return;
		}
		
		if (e.getEntity() instanceof Player){
			final Player p = (Player) e.getEntity();
			if (e.getDamager() instanceof Player){
				final Player p2 = (Player) e.getDamager();
				if (Commandlog.COMBAT_LOG){
					if (Main.emPvP(p) && (Main.emPvP(p2))){
						if ((e.getCause().equals(DamageCause.ENTITY_ATTACK)) || (e.getCause().equals(DamageCause.PROJECTILE))){
							if ((!combattag.contains(p.getName())) && (!combattag.contains(p2.getName()))){
								p.sendMessage(Prefix.PREFIX_COMBAT+"Você entrou em combate com "+p2.getName()+", não deslogue.");
								p2.sendMessage(Prefix.PREFIX_COMBAT+"Você entrou em combate com "+p.getName()+", não deslogue.");
								
								combattag.add(p.getName());
								combattag.add(p2.getName());
								
								int id = Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
									public void run() {
										p.sendMessage(Prefix.PREFIX_COMBAT+"Você não está mais em combate, já pode deslogar!");
										p2.sendMessage(Prefix.PREFIX_COMBAT+"Você não está mais em combate, já pode deslogar!");
										
										combattag.remove(p.getName());
										combattag.remove(p2.getName());
										Bukkit.getScheduler().cancelTask(noUse.get(p.getName()));
										noUse.remove(p.getName());
									}
								}, 15 * 20L).getTaskId();
								noUse.put(p.getName(), id);
							}
						}
					}
				}
			}
		}
	}
}
