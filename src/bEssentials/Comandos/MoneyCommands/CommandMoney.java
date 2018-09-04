package bEssentials.Comandos.MoneyCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bEssentials.AccountManager;


public class CommandMoney implements CommandExecutor {

	Plugin plugin;

	public CommandMoney(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("money")){
			if (args.length == 0){
				AccountManager conta = new AccountManager();
				
				conta.sendMessageMoney(p);
			} else {
				if (args[0].equalsIgnoreCase("top")){		
						p.sendMessage(" ");
						p.sendMessage("   §210 JOGADORES MAIS RICOS DO SERVIDOR   ");
						p.sendMessage(" ");
						p.sendMessage(" §a1ª §aMAGNATA "+plugin.getConfig().getString("MoneyTop.1"));
						p.sendMessage(" §a2ª "+plugin.getConfig().getString("MoneyTop.2"));
						p.sendMessage(" §a3ª "+plugin.getConfig().getString("MoneyTop.3"));
						p.sendMessage(" §a4ª "+plugin.getConfig().getString("MoneyTop.4"));
						p.sendMessage(" §a5ª "+plugin.getConfig().getString("MoneyTop.5"));
						p.sendMessage(" §a6ª "+plugin.getConfig().getString("MoneyTop.6"));
						p.sendMessage(" §a7ª "+plugin.getConfig().getString("MoneyTop.7"));
						p.sendMessage(" §a8ª "+plugin.getConfig().getString("MoneyTop.8"));
						p.sendMessage(" §a9ª "+plugin.getConfig().getString("MoneyTop.9"));
						p.sendMessage(" §a10ª "+plugin.getConfig().getString("MoneyTop.10"));
						p.sendMessage(" ");
				} else {
					if (args.length == 1){
						Player p2 = Bukkit.getPlayer(args[0]);					
						if (p2 == null){
							p.sendMessage("§c[§c§l!§c] Esse player não existe.");
						} else {
							AccountManager conta = new AccountManager();
							conta.sendMessageMoney(p, p2);
						}
					}	
				}
			}	
		}
		return false;
	}
}
