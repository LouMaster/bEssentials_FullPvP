package TEssentials.Utilidades;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import bEssentials.Prefix;

public class CommandChest implements CommandExecutor {

	public final ChestManager chestManager;
	
	public CommandChest(ChestManager chests) {
		chestManager = chests;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (sender instanceof Player){
			Player p = (Player)sender;
			if (cmd.getName().equalsIgnoreCase("chest")){
				if (!p.hasPermission("bEssentials.chest")){
					p.sendMessage("§cVocê não tem permissao para usar esse comando.");
				} else {
					if (args.length == 0){
						Inventory chest = chestManager.getChest(p.getUniqueId());
						p.openInventory(chest);
					} else {
						if (args.length == 1){
							if (p.hasPermission("bEssentials.admin.chest")){
								for (OfflinePlayer player : Bukkit.getOfflinePlayers()){
									if (player.getName().equals(args[1])){
										Inventory chest = chestManager.getChest(player.getUniqueId());
										p.openInventory(chest);
									}
								}
							} else {
								p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem permissão para usar esse comando.");
							}
						}
					}
				}
			}	
		}
		return false;
	}
}
