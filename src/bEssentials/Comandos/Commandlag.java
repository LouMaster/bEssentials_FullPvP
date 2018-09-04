package bEssentials.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import bEssentials.Prefix;

public class Commandlag implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("lag")){
			if (!p.hasPermission("bEssentials.admin.lag")){
				p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem permissão para usar esse comando.");
			} else {
				p.sendMessage("§6Memória máxima: §c"+Long.valueOf(Runtime.getRuntime().maxMemory() / 1024L / 1024L)+"MB");
				p.sendMessage("§6Memória alocada: §c"+Long.valueOf(Runtime.getRuntime().totalMemory() / 1024L / 1024L)+"MB");
				p.sendMessage("§6Memória disponível: §c"+Long.valueOf(Runtime.getRuntime().freeMemory() / 1024L / 1024L)+"MB");
			}
		}
		return false;
	}
}
