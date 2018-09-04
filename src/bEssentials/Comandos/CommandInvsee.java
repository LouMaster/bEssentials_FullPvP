package bEssentials.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import bEssentials.Prefix;

public class CommandInvsee implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("invsee")){
			if (!p.hasPermission("bEssentials.invsee")){
				p.sendMessage(Prefix.PREFIX_ERROR+"§cVocê não tem permissao para usar esse comando.");
			} else {
				if (args.length == 0){
					p.sendMessage("§cUso correto: /invsee <player>");
				} else {
					Player p2 = Bukkit.getPlayer(args[0]);
					
					if (p2 == null){
						p.sendMessage(Prefix.PREFIX_ERROR+"Esse player não existe.");
					} else {
						p.openInventory(p2.getInventory());
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você abriu o inventário do: §f"+p2.getName());
					}
				}
			}
		}
		return false;
	}
}
