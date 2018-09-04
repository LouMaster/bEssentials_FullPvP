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

public class HomeManager {

	public MyConfig home;
	
	public HomeManager(){}
	
	public void setHome(Player p, String nome){
		File homes = new File("plugins/bEssentials/Homes/"+p.getUniqueId());
		
		if (!homes.exists()){
			criarHome(p, nome);
		} else if (homes.isDirectory()){
			File[] homeList = homes.listFiles();
			
			int quantidade = 0;
			for (int i = 0; i < homeList.length; i++){
				quantidade++;
			}
			
			if (quantidade == 30){
				if (p.hasPermission("bEssentials.admin.home")){
					if (quantidade == 53){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você atingiu o limite máximo de homes de 53.");
					} else {
						criarHome(p, nome);
					}
				} else {
					p.sendMessage(Prefix.PREFIX_ERROR+"Você atingiu o limite máximo de homes de 30.");	
				}
			} else {
				criarHome(p, nome);
			}
		}
	}
	
	public void criarHome(Player p, String nome){
		home = Main.manager.getNewConfig("Homes/"+p.getUniqueId()+"/"+nome+".yml");
		
		String world = p.getWorld().getName();
		Location l = p.getLocation();
		double x = l.getX(); double y = l.getY()+1; double z = l.getZ();
		
		home.set("Mundo", world);
		home.set("X", x);
		home.set("Y", y);
		home.set("Z", z);
		home.saveConfig();
		
		p.sendMessage(Prefix.PREFIX_SUCESS+"Você setou a sua home '"+nome+"'.");
	}
	
	public void delHome(Player p, String nome){
		File file = new File(Main.plugin.getDataFolder(), "Homes/"+p.getUniqueId()+"/"+nome+".yml");
		if (!file.exists()){
			p.sendMessage(Prefix.PREFIX_ERROR+"Essa home não existe.");
			return;
		}
		file.delete();
		
		p.sendMessage(Prefix.PREFIX_SUCESS+"Você removeu a home '"+nome+"'.");
	}
	
	public void teleportHome(Player p, String nome){
		File home = new File(Main.plugin.getDataFolder(), "Homes/"+p.getUniqueId()+"/"+nome+".yml");
		if (!home.exists()){
			p.sendMessage(Prefix.PREFIX_ERROR+"Essa home não existe.");
			p.closeInventory();
		} else {
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(home);
			
			World w = Bukkit.getWorld(cfg.getString("Mundo"));
			double x = cfg.getDouble("X");
			double y = cfg.getDouble("Y");
			double z = cfg.getDouble("Z");
			
			Location loc = new Location(w, x, y, z);
			p.teleport(loc);
			p.sendMessage(Prefix.PREFIX_SUCESS+"Você foi teleportado para a home '"+nome+"'");
		}
	}
}
