package bEssentials.Eventos;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import bEssentials.Main;
import bEssentials.Comandos.KitCommands.Commandkit;

public class Quit implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		
		File cooldown = new File(Main.plugin.getDataFolder(), "Cooldowns.yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(cooldown);
		
		config.set(p.getName()+".comida", Commandkit.cooldownCOMIDA.get(p.getName()));
		config.set(p.getName()+".membro", Commandkit.cooldownMEMBRO.get(p.getName()));
		config.set(p.getName()+".iron", Commandkit.cooldownIRON.get(p.getName()));
		config.set(p.getName()+".gold", Commandkit.cooldownGOLD.get(p.getName()));
		config.set(p.getName()+".diamond", Commandkit.cooldownDIAMOND.get(p.getName()));
		config.set(p.getName()+".emerald", Commandkit.cooldownEMERALD.get(p.getName()));
		config.set(p.getName()+".legendary", Commandkit.cooldownLEGENDARY.get(p.getName()));
		
		try {
			config.save(cooldown);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
