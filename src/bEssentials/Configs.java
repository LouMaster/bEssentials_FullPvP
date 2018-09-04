package bEssentials;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Configs {

	public Configs(){}
	
	public boolean getBoolean(Player p, String path){
		File file = new File(Main.plugin.getDataFolder(), "Configuraçoes.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		return cfg.getBoolean(p.getUniqueId().toString()+"."+path);
	}
	
	public boolean getConfigPlayer(Player p, String path){
		File file = new File(Main.plugin.getDataFolder(), "Configuraçoes.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		if (cfg.get(p.getUniqueId().toString()) == null){
			return true;
		}
		
		return false;
	}
}
