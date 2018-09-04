package bEssentials.Comandos.HomeCommands;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import bEssentials.Prefix;
import bEssentials.Configuração.Managers.HomeManager;

public class CommandHome implements CommandExecutor, Listener {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("home")){
			if (!p.hasPermission("bEssentials.home")){
				p.sendMessage(Prefix.PREFIX_ERROR+"§cVocê não tem permissao para usar esse comando.");
			} else {
				if (args.length == 0){
					File homes = new File("plugins/bEssentials/Homes/"+p.getUniqueId());
					if (!homes.exists()){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem homes disponíveis.");
					} else {
						if (homes.isDirectory()){
							File[] homeList = homes.listFiles();
							
							Inventory inv = Bukkit.createInventory(p, 54, "§8Homes disponíveis:");
							int slot = 0;
							List<String> list = new ArrayList<>();
							for (int i = 0; i < homeList.length; i++){
								list.add(homeList[i].getName().replace(".yml", ""));
							}
							if (list.size() == 0){
								p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem homes disponíveis.");
							} else {
								for (int i = 0; i < list.size(); i++){
									File home = new File("plugins/bEssentials/Homes/"+p.getUniqueId(), (String)list.get(i)+".yml");
									FileConfiguration cfg = YamlConfiguration.loadConfiguration(home);
									String nome = home.getName().replace(".yml", "");
									
									ItemStack item = new ItemStack(Material.PAPER);
									ItemMeta itemmeta = item.getItemMeta();
									itemmeta.setDisplayName("§6Home: §f"+nome.replace(" ", ""));
									List<String> lore = new ArrayList<>();
									lore.add("§aMundo: §7"+cfg.getString("Mundo"));
									lore.add("§aX: §7"+cfg.getDouble("X"));
									lore.add("§aY: §7"+cfg.getDouble("Y"));
									lore.add("§aZ: §7"+cfg.getDouble("Z"));
									itemmeta.setLore(lore);
									item.setItemMeta(itemmeta);
									inv.setItem(slot, item);
									slot++;
								}
								p.openInventory(inv);
							}
						}	
					}
				} else {
					String home = args[0];
					
					HomeManager homes = new HomeManager();
					homes.teleportHome(p, home);
				}
			}	
		}
		return false;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		if (e.getSlot() == e.getRawSlot()){
			Player p = (Player) e.getWhoClicked();
			Inventory inv = e.getInventory();
			if (inv.getTitle().equalsIgnoreCase("§8Homes disponíveis:")){
				e.setCancelled(true);
				ItemStack i = e.getCurrentItem();
				if ((i.getType() != null) && (i.getType() != Material.AIR)){
					String dispname = i.getItemMeta().getDisplayName();
					String nome = ChatColor.stripColor(dispname.replace("§6Home: §f", ""));
					
					HomeManager home = new HomeManager();
					home.teleportHome(p, nome);
				}
			}
		}
	}
}
