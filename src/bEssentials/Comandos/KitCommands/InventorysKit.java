package bEssentials.Comandos.KitCommands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import bEssentials.Utils;

public class InventorysKit {

	public InventorysKit() {}
	
	public void sendKitMember(Player p){
		Inventory inv = Bukkit.createInventory(p, 45, "§6Kits membro disponíveis");

		Utils.setItem(inv, 11, Material.COOKED_BEEF, "§6Kit Comida");
		Utils.setItem(inv, 15, Material.STONE_SWORD, "§6Kit PvP");
		
        Utils.setItem(inv, 40, Material.ARROW, "§aVoltar", Arrays.asList("§7Volte ao menu de kits."));
        p.openInventory(inv);
	}
	
	@SuppressWarnings("deprecation")
	public void sendKitVips(Player p){
        Inventory inv = Bukkit.createInventory(p, 45, "§6Kits vip disponíveis");
        
        Utils.setItem(inv, 10, Material.IRON_BLOCK, "§7VIP Iron");
        Utils.setItem(inv, 11, Material.GOLD_BLOCK, "§6VIP Gold");
        Utils.setItem(inv, 13, Material.DIAMOND_BLOCK, "§bVIP Diamond");
        Utils.setItem(inv, 15, Material.EMERALD_BLOCK, "§aVIP Emerald");
        Utils.setItem(inv, 16, 5, Material.getMaterial(351), "§5VIP Legendary");
          
        Utils.setItem(inv, 39, Material.ARROW, "§aVoltar", Arrays.asList("§7Volte ao menu de kits."));
        Utils.setItem(inv, 40, Material.PAPER, "§6Compre VIP! §7(Clique)", Arrays.asList(
        "§8loja.tattoworld.net", " ", "§7Adquira §6VIP§7 em nosso site para", "§7poder pegar o kit correspondende", 
        "§7ao §6VIP§7 que você adquiriu.", " ", "§6Loja: §7loja.tattoworld.net"));
        p.openInventory(inv);
	}
	
	public void sendKitMenu(Player p){
		Inventory inv = Bukkit.createInventory(p, 27, "§6Menu de Kits");
		
		Utils.setItem(inv, 12, Material.STONE_SWORD, "§6Kits Membros");
		Utils.setItem(inv, 14, Material.DIAMOND_SWORD, "§6Kits VIPs");
		
		p.openInventory(inv);
	}
}
