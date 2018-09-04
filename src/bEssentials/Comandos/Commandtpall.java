package bEssentials.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import bEssentials.Prefix;

public class Commandtpall implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		final Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("tpall")){
			if (!p.hasPermission("bEssentials.admin.Tpall")){
				p.sendMessage(Prefix.PREFIX_ERROR+"Voc� n�o tem permiss�o para usar esse comando.");
			} else {
				for (Player todos : Bukkit.getOnlinePlayers()){
					todos.teleport(p);
				}
				Bukkit.broadcastMessage(Prefix.PREFIX_SUCESS+"Todos os jogadores foram teleportados!");
			}
		}
		return false;
	}
}
