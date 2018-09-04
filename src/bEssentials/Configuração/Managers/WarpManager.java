package bEssentials.Configuração.Managers;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import bEssentials.Main;
import bEssentials.Prefix;
import bEssentials.Configuração.MyConfig;

public class WarpManager {
	
	public MyConfig warp;
	
	public WarpManager(){}
	
	public void setWarp(Player p, String nome){
		warp = Main.manager.getNewConfig("Warps/"+nome+".yml");
		
		String world = p.getWorld().getName();
		Location l = p.getLocation();
		double x = l.getX(); double y = l.getY()+1; double z = l.getZ();
		
		warp.set("Mundo", world);
		warp.set("X", x);
		warp.set("Y", y);
		warp.set("Z", z);
		warp.saveConfig();
		
		p.sendMessage(Prefix.PREFIX_SUCESS+"Você setou a warp '"+nome+"'.");
	}
	
	public void removeWarp(Player p, String nome){
		File file = new File(Main.plugin.getDataFolder(), "Warps/"+nome+".yml");
		if (!file.exists()){
			p.sendMessage(Prefix.PREFIX_ERROR+"Essa warp não existe.");
		} else {
			file.delete();
			
			p.sendMessage(Prefix.PREFIX_SUCESS+"Você removeu a warp '"+nome+"'.");
		}
	}
	
	public void teleportarPlayer(Player p, String warp){
		File home = new File(Main.plugin.getDataFolder(), "Warps/"+warp+".yml");
		if (!home.exists()){
			p.sendMessage(Prefix.PREFIX_ERROR+"Essa warp não existe.");
			p.closeInventory();
		} else {
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(home);
			
			World w = Bukkit.getWorld(cfg.getString("Mundo"));
			double x = cfg.getDouble("X");
			double y = cfg.getDouble("Y");
			double z = cfg.getDouble("Z");
			
			Location loc = new Location(w, x, y, z);
			p.teleport(loc);
			p.sendMessage(Prefix.PREFIX_SUCESS+"Você foi teleportado para a warp '"+warp+"'");
		}
	}
}
