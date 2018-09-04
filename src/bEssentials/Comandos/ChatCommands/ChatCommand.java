package bEssentials.Comandos.ChatCommands;

import bEssentials.AccountManager;
import bEssentials.Main;
import bEssentials.Prefix;
import bUtils.Packets.Tags.TagAPI;
import bUtils.Packets.TitleManager;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import MySQL.API.PrisionUtil;

public class ChatCommand implements CommandExecutor {
	
	public static ArrayList<String> chat_global_delay = new ArrayList<>();
	public static boolean chat = true;
	
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args){
		if (!(sender instanceof Player)){
			return true;
		}
		final Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("g")){
			if (args.length == 0){
				p.sendMessage("Uso correto: /g <mensagem>");
			} else {
				AccountManager conta = new AccountManager();
				
				int money = conta.getMoney(p);
				if (money >= 100){
					if (!chat_global_delay.contains(p.getName())){
						if (chat == true){
							StringBuilder build = new StringBuilder();
							for (int i = 0; i < args.length; i++){
								build.append(args[i]).append(" ");
							}
							
							if (!p.hasPermission("bEssentials.chat.delay")){
								chat_global_delay.add(p.getName());
								conta.removerMoney(p, 100);
								TitleManager title = new TitleManager();
								title.sendActionBar(p, "§c- $100");
							}
							if (!p.hasPermission("bEssentials.Cor")){
								Bukkit.broadcastMessage("§7[g] §7[§6"+PrisionUtil.getClan(p.getUniqueId().toString())+"§7] "+TagAPI.getNametag(p.getName())+"§7: "+build.toString().trim());
							} else {
								Bukkit.broadcastMessage("§7[g] §7[§6"+PrisionUtil.getClan(p.getUniqueId().toString())+"§7] "+TagAPI.getNametag(p.getName())+"§7: "+build.toString().trim().replace("&", "§"));
							}
						} else {
							p.sendMessage(Prefix.PREFIX_ERROR+"O Chat está desabilitado.");
						}
						new BukkitRunnable() {
							public void run() {
								chat_global_delay.remove(p.getName());
							}
						}.runTaskLater(Main.plugin, 160L);
					} else {
						p.sendMessage(Prefix.PREFIX_ERROR+"Espere para falar no chat global novamente.");
					}
				} else {
					p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem money suficiente para falar no chat global.");
				}
			}
		}
		if (cmd.getName().equalsIgnoreCase("chat")){
			if (!p.hasPermission("bEssentials.chat")){
				p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem permissão para usar esse comando.");
			} else {
				if (args.length == 0){
					p.sendMessage("§cUso correto: /chat <on|off>");
				} else {
					if (args[0].equalsIgnoreCase("on")){
						if (chat){
							p.sendMessage(Prefix.PREFIX_ERROR+"O Chat já está ativado.");
						} else {
							chat = true;
							Bukkit.broadcastMessage(Prefix.PREFIX_SUCESS+"Chat foi habilitado.");
						}
					} else if (args[0].equalsIgnoreCase("off")){
						if (!chat){
							p.sendMessage(Prefix.PREFIX_ERROR+"O Chat já está desativado.");
						} else {
							chat = false;
							Bukkit.broadcastMessage(Prefix.PREFIX_SUCESS+"Chat foi desabilitado.");
						}
					}
				}
			}
		}
		return false;
	}
}