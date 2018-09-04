package bEssentials.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import bEssentials.Prefix;

public class Commandspawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("spawn")){
			if (!p.hasPermission("bEssentials.spawn")){
				p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem permissão para usar esse comando.");
			} else {
				p.teleport(Bukkit.getWorld("world").getSpawnLocation());
				p.sendMessage(Prefix.PREFIX_SUCESS+"Você foi teleportado para o spawn.");
			}
		}
		return false;
	}
}
