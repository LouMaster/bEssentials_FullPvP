package bEssentials.Comandos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import bEssentials.Main;
import bEssentials.Prefix;

public class Commandtpa implements CommandExecutor {

	public static HashMap<String, String> teleporte = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		final Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("tp")){
			if (!p.hasPermission("bEssentials.admin.tp")){
				p.sendMessage(Prefix.PREFIX_ERROR+"§cVocê não tem permissao para usar esse comando.");
			} else {
				if (args.length == 0){
					p.sendMessage("§cUso correto: /tp <player> OU /tp <player> <player>");
				} else {
					Player p2 = Bukkit.getPlayer(args[0]);
					if (p2 == null){
						p.sendMessage(Prefix.PREFIX_ERROR+"Esse player não existe.");
					} else {
						p.teleport(p2);
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você foi teleportado para o "+p2.getName());
					}
				}
			}
		}
		if (cmd.getName().equalsIgnoreCase("tpa")){
			if (args.length == 0){
				p.sendMessage("§cUso correto: /tpa <player>");
			} else {
				Player target = Bukkit.getPlayer(args[0]);
				if (target == null){
					p.sendMessage(Prefix.PREFIX_ERROR+"Esse player não existe.");
				} else {
					if (target == p){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não pode enviar um pedido de teleporte pra si mesmo.");
					} else {
						if (!CommandsTogle.getBoolean(p, "TpaConvite")){
							p.sendMessage(Prefix.PREFIX_ERROR+"Esse player está com pedidos de tpa off.");
						} else {
							if (teleporte.containsKey(p.getName())){
								p.sendMessage(Prefix.PREFIX_ERROR+"Você já pediu para teleportar-se para esse jogador.");
							} else {
								p.sendMessage("§fVocê enviou um pedido de teleporte para §6"+target.getName());
								target.sendMessage("§6"+p.getName()+" §fpediu para teleportar-se até você.");
								target.sendMessage("§fPara aceitar, digite: §c/tpaccept <player>");
								target.sendMessage("§fPara recusar, digite: §c/tpdeny <player>");
								target.sendMessage("§fEsse pedido se esgoratá em §c60 segundos§6.");
								teleporte.put(p.getName(), target.getName());
								
								new BukkitRunnable() {
									public void run() {
										if (teleporte.containsKey(p.getName())){
											p.sendMessage("§6Pedido de teleporte esgotou.");
											teleporte.remove(p.getName());
										}
									}
								}.runTaskLater(Main.plugin, 10*60);
							}
						}
					}
				}
			}	
		}
		if (cmd.getName().equalsIgnoreCase("tpaccept")){
			if (args.length == 0){
				p.sendMessage("§cUso correto: /tpaccept <player>");
			} else {
				Player target = Bukkit.getPlayer(args[0]);
				if (target == null){
					p.sendMessage(Prefix.PREFIX_ERROR+"Esse player não existe.");
				} else {
					if (!CommandsTogle.getBoolean(p, "TpaConvite")){
						p.sendMessage(Prefix.PREFIX_ERROR+"Esse player está com pedidos de tpa off.");
					} else {
						if (!teleporte.containsKey(target.getName())){
							p.sendMessage(Prefix.PREFIX_ERROR+"Esse jogador não pediu para teleportar-se até você.");
						} else {
							String playerTP = teleporte.get(target.getName());
							
							if (playerTP != p.getName()){
								p.sendMessage(Prefix.PREFIX_ERROR+"Esse jogador não pediu para teleportar-se até você.");
							} else {
								target.teleport(p.getLocation().add(0,1,0));
								target.sendMessage("§f"+p.getName()+"§6 aceitou seu pedido de teleporte.");
								p.sendMessage("§6Você aceitou o pedido de teleporte do §f"+target.getName());
								teleporte.remove(p.getName()); teleporte.remove(target.getName());	
							}
						}
					}
				}
			}	
		}
		return false;
	}
}
