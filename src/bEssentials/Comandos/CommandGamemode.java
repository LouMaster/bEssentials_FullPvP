package bEssentials.Comandos;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import bEssentials.Prefix;

public class CommandGamemode implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("gamemode")){
			if (!p.hasPermission("bEssentials.admin.gamemode")){
				p.sendMessage(Prefix.PREFIX_ERROR+"§cVocê não tem permissao para usar esse comando.");
			} else {
				if (args.length == 0){
					p.sendMessage("§cUso correto: /gamemode <0|1|2>");
				} else {
					if (args[0].equalsIgnoreCase("0")){
						p.setGameMode(GameMode.SURVIVAL);
						
						p.sendMessage(Prefix.PREFIX_SUCESS+"Seu modo de jogo foi atualizado para: §fSurvival");
					} else if (args[0].equalsIgnoreCase("1")){
						p.setGameMode(GameMode.CREATIVE);
						
						p.sendMessage(Prefix.PREFIX_SUCESS+"Seu modo de jogo foi atualizado para: §fCriativo");
					} else if (args[0].equalsIgnoreCase("2")){
						p.setGameMode(GameMode.ADVENTURE);
						
						p.sendMessage(Prefix.PREFIX_SUCESS+"Seu modo de jogo foi atualizado para: §fAventureiro");
					} else {
						p.sendMessage("§cUso correto: /gamemode <0|1|2>");
					}
				}
			}
		}
		return false;
	}
}
