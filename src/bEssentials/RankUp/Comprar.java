package bEssentials.RankUp;


import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import bEssentials.AccountManager;
import bEssentials.Main;
import bEssentials.Prefix;
import bUtils.Packets.TitleManager;


public class Comprar implements CommandExecutor, Listener{

	static Plugin plugin;

	public Comprar(Main main) {
		plugin = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("cela")){
			if(args.length != 0){
			if(args[0].equalsIgnoreCase("comprar")){
				if(!isArea(p)){
					p.sendMessage(Prefix.PREFIX_ERROR+"Você não está em uma cela.");
					return true;
				}
				if(alreadyHave(p)){
					p.sendMessage(Prefix.PREFIX_ERROR+"Você já comprou essa cela...");
					return true;
				}
				if(checkCelas(p) == 1){
					p.sendMessage(Prefix.PREFIX_ERROR+"Você chegou ao limite de celas. Desculpe.");
					return true;
				}
				if(hasOwner(p)){
					p.sendMessage(Prefix.PREFIX_ERROR+"Essa cela parece já ter um dono...");
					return true;
				}
				AccountManager conta = new AccountManager();
				if(conta.getMoney(p) < 100000){
					p.sendMessage(Prefix.PREFIX_ERROR+"Oops. Você prescisa de $100.000.");
					return true;
				}
				getAreaName(p);
				p.sendMessage(Prefix.PREFIX_SUCESS+"Você comprou essa cela!");
				conta.removerMoney(p, 100000);
				TitleManager title = new TitleManager();
				title.sendActionBar(p, "§c- $100.000");
			}else if(args[0].equalsIgnoreCase("vender")){
				if(!isArea(p)){
					p.sendMessage(Prefix.PREFIX_ERROR+"Você não está em uma cela.");
					return true;
				}
				if(!alreadyHave(p)){
					p.sendMessage(Prefix.PREFIX_ERROR+"Essa cela não é sua...");
					return true;
				}
				AccountManager conta = new AccountManager();
				p.sendMessage(Prefix.PREFIX_SUCESS+"Você vendeu essa cela!");
				conta.giveMoney(p, 90000);
				removePlayer(p);
				TitleManager title = new TitleManager();
				title.sendActionBar(p, "§a+ $90.000");
			} 
			}else if(args.length == 0){
				if(!isArea(p)){
					p.sendMessage(Prefix.PREFIX_ERROR+"Você não está em uma cela.");
					return true;
				}
				p.sendMessage("§7=======================================");
				p.sendMessage("§a Você está "+getOwner(p));
				p.sendMessage("§7=======================================");
			}
		}
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public static boolean isArea(Player p) {
		ApplicableRegionSet region = getWorldGuard1().getRegionManager(
		p.getWorld()).getApplicableRegions(p.getLocation());
		if (!region.allows(DefaultFlag.ENDERDRAGON_BLOCK_DAMAGE)) {
			return true;
		}else if (region.allows(DefaultFlag.ENDERDRAGON_BLOCK_DAMAGE)) {
			return false;
		}
		return false;
	}
	
	public int checkCelas(Player p){
			return plugin.getConfig().getInt("PlayerCela."+p.getUniqueId());
	}
	
	public static void getAreaName(Player p) {
				for(ProtectedRegion r : WGBukkit.getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation())) {
					if(r.getId().contains("prison")){
						r.getOwners().addPlayer(p.getUniqueId());
						plugin.getConfig().set("PlayerCela."+p.getUniqueId(), 1);
					}
			 }
	}
	
	public static void removePlayer(Player p) {
		for(ProtectedRegion r : WGBukkit.getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation())) {
			if(r.getId().contains("prison")){
				if(alreadyHave(p)){
				r.getOwners().removePlayer(p.getUniqueId());
				
				plugin.getConfig().set("PlayerCela."+p.getUniqueId(), 0);
				}
			}
	 }
}
	
	public static boolean alreadyHave(Player p) {
		for(ProtectedRegion r : WGBukkit.getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation())) {
			if(r.getId().contains("prison")){
				if(r.getOwners().getUniqueIds().contains(p.getUniqueId())){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}
	
	public static boolean hasOwner(Player p) {
		for(ProtectedRegion r : WGBukkit.getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation())) {
			if(r.getId().contains("prison")){
				if(!r.getOwners().getUniqueIds().isEmpty()){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}
	
	public static String getOwner(Player p) {
		for(ProtectedRegion r : WGBukkit.getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation())) {
			if(r.getId().contains("prison")){
				if(!hasOwner(p)){
					return "em uma cela sem dono";
				}else{
					return "na cela do(a) "+Bukkit.getOfflinePlayer(UUID.fromString(r.getOwners().getUniqueIds().toString().replace("[", "").replace("]", ""))).getName();
				}
			}
		}
		return null;
	}
	
	public static WorldGuardPlugin getWorldGuard1() {
		Plugin plugin = Bukkit.getServer().getPluginManager()
				.getPlugin("WorldGuard");
		if ((plugin == null) || (!(plugin instanceof WorldGuardPlugin))) {
			return null;
		}
		return (WorldGuardPlugin) plugin;
	}

}
