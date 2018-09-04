package bEssentials.Comandos.WarpCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bEssentials.Main;
import bEssentials.Prefix;

public class CommandsWarp implements CommandExecutor {

	static Plugin plugin;

	public CommandsWarp(Main main) {
		plugin = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("setwarp")){
			if (!p.hasPermission("bEssentials.admin.setwarp")){
				p.sendMessage(Prefix.PREFIX_ERROR+"§cVocê não tem permissao para usar esse comando.");
			} else {
				if (args.length < 1){
					p.sendMessage("§cUso correto: /setwarp <nome>");
				} else {
					plugin.getConfig().set("Warps."+args[0].toUpperCase()+"World", p.getLocation().getWorld().getName());
					plugin.getConfig().set("Warps."+args[0].toUpperCase()+"X", Double.valueOf(p.getLocation().getX()));
					plugin.getConfig().set("Warps."+args[0].toUpperCase()+"Y", Double.valueOf(p.getLocation().getY()));
					plugin.getConfig().set("Warps."+args[0].toUpperCase()+"Z", Double.valueOf(p.getLocation().getZ()));
					plugin.getConfig().set("Warps."+args[0].toUpperCase()+"YA", Double.valueOf(p.getLocation().getYaw()));
					plugin.getConfig().set("Warps."+args[0].toUpperCase()+"P", Double.valueOf(p.getLocation().getPitch()));
					plugin.saveConfig();
					p.sendMessage(Prefix.PREFIX_SUCESS+"Warp §6"+args[0]+"§a foi setada com sucesso!");
				}
			}	
		}else if (cmd.getName().equalsIgnoreCase("setspawn")){
			if (!p.hasPermission("bEssentials.admin.setwarp")){
				p.sendMessage(Prefix.PREFIX_ERROR+"§cVocê não tem permissao para usar esse comando.");
			} else {
				if (args.length < 0){
					p.sendMessage("§cUso correto: /setspawn");
				} else {
					plugin.getConfig().set("SpawnWorld", p.getLocation().getWorld().getName());
					plugin.getConfig().set("SpawnX", Double.valueOf(p.getLocation().getX()));
					plugin.getConfig().set("SpawnY", Double.valueOf(p.getLocation().getY()));
					plugin.getConfig().set("SpawnZ", Double.valueOf(p.getLocation().getZ()));
					plugin.getConfig().set("SpawnYA", Double.valueOf(p.getLocation().getYaw()));
					plugin.getConfig().set("SpawnP", Double.valueOf(p.getLocation().getPitch()));
					plugin.saveConfig();
					p.sendMessage(Prefix.PREFIX_SUCESS+"Spawn foi setado com sucesso!");
				}
			}	
		}
		return false;
	}
	
	public boolean eNumero(String s){
		try {
			Double.parseDouble(s);
		} catch (NumberFormatException e){
			return false;
		}
		return true;
	}
}
