package TEssentials.Utilidades.Combatlog;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import bEssentials.Prefix;

public class Commandlog implements CommandExecutor {

	public static boolean COMBAT_LOG = true;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (sender instanceof Player){
			Player p = (Player)sender;
			if (cmd.getName().equalsIgnoreCase("combatlog")){
				if (!p.hasPermission("bEssentials.combatlog")){
					p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem permissão para usar esse comando.");
				} else {
					if (args.length == 0){
						p.sendMessage("§cUso correto: /combatlog <ativar|desativar>");
						p.sendMessage("§cUso correto: /combatlog removerjogadores");
					} else {
						if (args[0].equalsIgnoreCase("ativar")){
							if (COMBAT_LOG){
								p.sendMessage(Prefix.PREFIX_ERROR+"Combatlog já está ativado.");
							} else {
								COMBAT_LOG = true;
								
								p.sendMessage("§aCombatlog foi ativado!");
								Bukkit.broadcastMessage(Prefix.PREFIX_COMBAT+"Combatlog habilitado!");
							}
						} else if (args[0].equalsIgnoreCase("desativar")){
							if (!COMBAT_LOG){
								p.sendMessage(Prefix.PREFIX_ERROR+"Combatlog já está desativado.");
							} else {
								COMBAT_LOG = false;
								
								p.sendMessage("§aCombatlog foi desativado!");
								Bukkit.broadcastMessage(Prefix.PREFIX_COMBAT+"Combatlog desabilitado!");
							}
						} else if (args[0].equalsIgnoreCase("removerjogadores")){
							for (Player on : Bukkit.getOnlinePlayers()){
								if (EntityAttack.combattag.contains(on.getName())){
									EntityAttack.combattag.remove(on.getName());
									
									if (on != p){
										on.sendMessage(Prefix.PREFIX_COMBAT+"Você foi retirado do combate por: "+p.getName());
									}
								}
							}
							p.sendMessage(Prefix.PREFIX_COMBAT+"Todos em combate foram retirados de combate!");
						}
					}
				}
			}
		}
		return false;
	}
}
