package bEssentials.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import bEssentials.Prefix;

public class CommandBroadcast implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("broadcast")){
			if (!p.hasPermission("bEssentials.admin.broadcast")){
				p.sendMessage(Prefix.PREFIX_ERROR+"§cVocê não tem permissao para usar esse comando.");
			} else {
				if (args.length == 0){
					p.sendMessage("§cUso correto: /broadcast <mensagem>");
				} else {
					StringBuilder build = new StringBuilder();
					for (int i = 0; i < args.length; i++){
						build.append(args[i]).append(" ");
					}
					String chat = build.toString().trim().replace("&", "§");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage("§c[§c§l!§c] "+chat);
					Bukkit.broadcastMessage(" ");
				}
			}
		}
		return false;
	}
}
