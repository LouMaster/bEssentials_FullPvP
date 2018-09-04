package bEssentials.Comandos.WarpCommands;

import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import bEssentials.Main;
import bEssentials.Prefix;
import bEssentials.Utils;
import bEssentials.Configuração.Managers.WarpManager;

public class CommandWarp implements CommandExecutor, Listener {
	
	
	static Plugin plugin;

	public CommandWarp(Main main) {
		plugin = main;
	}
	
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e){
		if (e.getCurrentItem() != null && (e.getCurrentItem().getItemMeta() != null) && (e.getCurrentItem().getItemMeta().getDisplayName() != null)){
			Player p = (Player)e.getWhoClicked();
			Inventory i = e.getInventory();
			
			if (i.getTitle().equalsIgnoreCase("§6Menu de Warps")){
				e.setCancelled(true);
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Warps Rank")){
					sendWarpsRank(p);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Warps VIPs")){
					sendWarpVips(p);
				}
			}
		}
	}
	
	public static void sendWarpsRank(Player p){
		Inventory inv = Bukkit.createInventory(p, 45, "§6Warps RANK disponíveis");

		Utils.setItem(inv, 2, Material.COAL_ORE, "§6Z");
		Utils.setItem(inv, 3, Material.COAL_ORE, "§6Y");
		Utils.setItem(inv, 4, Material.COAL_ORE, "§6X");
		Utils.setItem(inv, 5, Material.COAL_ORE, "§6W");
		Utils.setItem(inv, 6, Material.COAL_ORE, "§6V");
		Utils.setItem(inv, 10, Material.IRON_ORE, "§6U");
		Utils.setItem(inv, 11, Material.IRON_ORE, "§6T");
		Utils.setItem(inv, 12, Material.IRON_ORE, "§6S");
		Utils.setItem(inv, 13, Material.IRON_ORE, "§6R");
		Utils.setItem(inv, 14, Material.IRON_ORE, "§6Q");
		Utils.setItem(inv, 15, Material.IRON_ORE, "§6P");
		Utils.setItem(inv, 16, Material.IRON_ORE, "§6O");
		Utils.setItem(inv, 19, Material.GOLD_ORE, "§6N");
		Utils.setItem(inv, 20, Material.GOLD_ORE, "§6M");
		Utils.setItem(inv, 21, Material.GOLD_ORE, "§6L");
		Utils.setItem(inv, 22, Material.GOLD_ORE, "§6K");
		Utils.setItem(inv, 23, Material.GOLD_ORE, "§6J");
		Utils.setItem(inv, 24, Material.GOLD_ORE, "§6I");
		Utils.setItem(inv, 25, Material.GOLD_ORE, "§6H");
		Utils.setItem(inv, 28, Material.DIAMOND_ORE, "§6G");
		Utils.setItem(inv, 29, Material.DIAMOND_ORE, "§6F");
		Utils.setItem(inv, 30, Material.DIAMOND_ORE, "§6E");
		Utils.setItem(inv, 31, Material.DIAMOND_ORE, "§6D");
		Utils.setItem(inv, 32, Material.DIAMOND_ORE, "§6C");
		Utils.setItem(inv, 33, Material.DIAMOND_ORE, "§6B");
		Utils.setItem(inv, 34, Material.DIAMOND_ORE, "§6A");
		
        Utils.setItem(inv, 40, Material.ARROW, "§aVoltar", Arrays.asList("§7Volte ao menu de warps."));
        p.openInventory(inv);
	}
	
	@SuppressWarnings("deprecation")
	public void sendWarpVips(Player p){
        Inventory inv = Bukkit.createInventory(p, 45, "§6Warps VIPs disponíveis");
        
        Utils.setItem(inv, 10, Material.IRON_BLOCK, "§7VIPIron");
        Utils.setItem(inv, 11, Material.GOLD_BLOCK, "§6VIPGold");
        Utils.setItem(inv, 13, Material.DIAMOND_BLOCK, "§bVIPDiamond");
        Utils.setItem(inv, 15, Material.EMERALD_BLOCK, "§aVIPEmerald");
        Utils.setItem(inv, 16, 5, Material.getMaterial(351), "§5VIPLegendary");
          
        Utils.setItem(inv, 39, Material.ARROW, "§aVoltar", Arrays.asList("§7Volte ao menu de Warps."));
        Utils.setItem(inv, 40, Material.PAPER, "§6Compre VIP! §7(Clique)", Arrays.asList(
        "§8loja.tattoworld.net", " ", "§7Adquira §6VIP§7 em nosso site para", "§7poder ir para o warp correspondende", 
        "§7ao §6VIP§7 que você adquiriu.", " ", "§6Loja: §7loja.tattoworld.net"));
        p.openInventory(inv);
	}
	
	public void sendWarpMenu(Player p){
		Inventory inv = Bukkit.createInventory(p, 27, "§6Menu de Warps");
		
		Utils.setItem(inv, 12, Material.STONE_SWORD, "§6Warps Rank");
		Utils.setItem(inv, 14, Material.DIAMOND_SWORD, "§6Warps VIPs");
		
		p.openInventory(inv);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("warp")){
			if (args.length == 0){
				sendWarpMenu(p);
			} else {
				if (!p.hasPermission("bEssentials.warp."+args[0].toLowerCase())){
					p.sendMessage("§cVocê não tem permissão para teleportar para essa warp.");
				} else {
					WarpManager warp = new WarpManager();
					warp.teleportarPlayer(p, args[0].toLowerCase());	
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
			if (inv.getTitle().equalsIgnoreCase("§8Warps disponíveis:")){
				e.setCancelled(true);
				ItemStack i = e.getCurrentItem();
				if ((i.getType() != null) && (i.getType() != Material.AIR)){
					String dispname = i.getItemMeta().getDisplayName();
					String nome = ChatColor.stripColor(dispname.replace("§6Warp: §f", ""));
					
					WarpManager warp = new WarpManager();
					warp.teleportarPlayer(p, nome.toLowerCase());
				}
			}
		}
	}
	
	
	
    @EventHandler
    public void onClickSendKit(InventoryClickEvent e){
		if (e.getCurrentItem() != null && (e.getCurrentItem().getItemMeta() != null) && (e.getCurrentItem().getItemMeta().getDisplayName() != null)){
			Player p = (Player)e.getWhoClicked();
			Inventory i = e.getInventory();
			
			if (i.getTitle().equalsIgnoreCase("§6Warps RANK disponíveis")){
				e.setCancelled(true);
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVoltar")){
					p.closeInventory();
					sendWarpMenu(p);
				}else{
					try{
					World w = Bukkit.getWorld(plugin.getConfig().getString("Warps."+e.getCurrentItem().getItemMeta().getDisplayName().replace("§6", "")+"World"));
					int x = plugin.getConfig().getInt("Warps."+e.getCurrentItem().getItemMeta().getDisplayName().replace("§6", "")+"X");
					int y = plugin.getConfig().getInt("Warps."+e.getCurrentItem().getItemMeta().getDisplayName().replace("§6", "")+"Y");
					int z = plugin.getConfig().getInt("Warps."+e.getCurrentItem().getItemMeta().getDisplayName().replace("§6", "")+"Z");
					float YA = plugin.getConfig().getInt("Warps."+e.getCurrentItem().getItemMeta().getDisplayName().replace("§6", "")+"YA");
					int PI = plugin.getConfig().getInt("Warps."+e.getCurrentItem().getItemMeta().getDisplayName().replace("§6", "")+"PI");
					Location l = new Location(w, x, y, z);
					l.setPitch(PI);
					l.setYaw(YA);
					p.teleport(l);
					p.sendMessage(Prefix.PREFIX_SUCESS+"Você foi para a warp "+e.getCurrentItem().getItemMeta().getDisplayName()+"§a!");
					}catch(Exception e1){
						p.sendMessage(Prefix.PREFIX_ERROR+"Essa WARP não existe. Desculpe.");
					}
				}
			}
			if (i.getTitle().equalsIgnoreCase("§6Warps VIPs disponíveis")){
				e.setCancelled(true);
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVoltar")){
					p.closeInventory();
					sendWarpMenu(p);
				}else{
					try{
					World w = Bukkit.getWorld(plugin.getConfig().getString("Warps."+e.getCurrentItem().getItemMeta().getDisplayName().replace("§7", "").replace("§b", "").replace("§a", "").replace("§6", "")+"World"));
					int x = plugin.getConfig().getInt("Warps."+e.getCurrentItem().getItemMeta().getDisplayName().replace("§7", "").replace("§b", "").replace("§a", "").replace("§6", "")+"X");
					int y = plugin.getConfig().getInt("Warps."+e.getCurrentItem().getItemMeta().getDisplayName().replace("§7", "").replace("§b", "").replace("§a", "").replace("§6", "")+"Y");
					int z = plugin.getConfig().getInt("Warps."+e.getCurrentItem().getItemMeta().getDisplayName().replace("§7", "").replace("§b", "").replace("§a", "").replace("§6", "")+"Z");
					float YA = plugin.getConfig().getInt("Warps."+e.getCurrentItem().getItemMeta().getDisplayName().replace("§7", "").replace("§b", "").replace("§a", "").replace("§6", "")+"YA");
					int PI = plugin.getConfig().getInt("Warps."+e.getCurrentItem().getItemMeta().getDisplayName().replace("§7", "").replace("§b", "").replace("§a", "").replace("§6", "")+"PI");
					Location l = new Location(w, x, y, z);
					l.setPitch(PI);
					l.setYaw(YA);
					p.teleport(l);
					p.sendMessage(Prefix.PREFIX_SUCESS+"Você foi para a warp "+e.getCurrentItem().getItemMeta().getDisplayName()+"§a!");
					}catch(Exception e1){
						p.sendMessage(Prefix.PREFIX_ERROR+"Essa WARP não existe. Desculpe.");
					}
				}
			}
		}
    }
}
