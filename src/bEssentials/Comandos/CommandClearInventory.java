package bEssentials.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import bEssentials.Prefix;

public class CommandClearInventory implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("clear")){
			if (!p.hasPermission("bEssentials.admin.clear")){
				p.sendMessage(Prefix.PREFIX_ERROR+"§cVocê não tem permissao para usar esse comando.");
			} else {
				if (args.length == 0){
					p.sendMessage(Prefix.PREFIX_SUCESS+"Seu inventário foi limpo.");
					
					p.getInventory().clear();
					p.getInventory().setArmorContents(null);
				} else {
					if (args.length == 1){
						Player p2 = Bukkit.getPlayer(args[0]);
						
						if (p2 == null){
							p.sendMessage(Prefix.PREFIX_ERROR+"Esse player não existe.");
						} else {
							p.sendMessage(Prefix.PREFIX_SUCESS+"Você limpou com sucesso o inventário do §f"+p2.getName());
							p2.getInventory().clear();
							p2.getInventory().setArmorContents(null);
						}
					}
				}
			}	
		}
		return false;
	}
}
