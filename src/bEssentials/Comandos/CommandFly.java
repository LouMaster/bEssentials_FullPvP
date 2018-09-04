package bEssentials.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import bEssentials.Prefix;

public class CommandFly implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("fly")){
			if (!p.hasPermission("bEssentials.fly")){
				p.sendMessage(Prefix.PREFIX_ERROR+"§cVocê não tem permissao para usar esse comando.");
			} else {
				if (!p.getAllowFlight()){
					p.setAllowFlight(true);
					p.setFlying(true);
					
					p.sendMessage(Prefix.PREFIX_SUCESS+"Você está voando.");
				} else {
					p.setAllowFlight(false);
					p.setFlying(false);
					
					p.sendMessage(Prefix.PREFIX_SUCESS+"Você não está mais voando");
				}
			}
		}
		return false;
	}
}
