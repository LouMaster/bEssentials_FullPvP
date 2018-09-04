package bEssentials.Comandos.HomeCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import bEssentials.Prefix;
import bEssentials.Configuração.Managers.HomeManager;

public class CommandSethome implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("sethome")){
			if (!p.hasPermission("bEssentials.sethome")){
				p.sendMessage(Prefix.PREFIX_ERROR+"§cVocê não tem permissao para usar esse comando.");
			} else {
				if (args.length == 0){
					p.sendMessage("§cUso correto: /sethome <nome>");
				} else {
					String home = args[0];
					HomeManager homes = new HomeManager();
					
					homes.setHome(p, home);
				}
			}	
		}
		return false;
	}
}
