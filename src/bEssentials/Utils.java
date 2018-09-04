package bEssentials;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Utils {
	
	public static void createItemMeta(ItemStack item, String nome){
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(nome);
		item.setItemMeta(meta);
	}
	
	public static void CriarItemInventario(Player p, ItemStack mt){	
		p.getInventory().addItem(mt);
	}
	
	public static void setItem(Inventory inv, int local, ItemStack mt){	
		inv.setItem(local, mt);
	}
	
	public static void setItem(Inventory inv, int lugar, Material item, String nome, int quantidade){
		ItemStack pow = new ItemStack(item, quantidade);
		ItemMeta powmeta = pow.getItemMeta();
		powmeta.setDisplayName(nome.replace("&", "§"));
		pow.setItemMeta(powmeta);
		inv.setItem(lugar, pow);
	}
	
	public static void setItem(Inventory inv, int lugar, int id2, Material item, String nome, int quantidade, List<String> list){
		ItemStack pow = new ItemStack(item, quantidade, (short)  id2);
		ItemMeta powmeta = pow.getItemMeta();
		powmeta.setDisplayName(nome.replace("&", "§"));
		powmeta.setLore(list);
		pow.setItemMeta(powmeta);
		inv.setItem(lugar, pow);
	}
	
	public static void setItem(Inventory inv, int lugar, Material item, String nome){
		ItemStack pow = new ItemStack(item);
		ItemMeta powmeta = pow.getItemMeta();
		powmeta.setDisplayName(nome.replace("&", "§"));
		pow.setItemMeta(powmeta);
		inv.setItem(lugar, pow);
	}
	
	public static void setItem(Inventory inv, int lugar, Material item, String nome, Enchantment enchant, int level){
		ItemStack pow = new ItemStack(item);
		pow.addUnsafeEnchantment(enchant, level);
		ItemMeta powmeta = pow.getItemMeta();
		powmeta.setDisplayName(nome.replace("&", "§"));
		pow.setItemMeta(powmeta);
		inv.setItem(lugar, pow);
	}
	
	public static void setItem(Inventory inv, int lugar, Material item, String nome, List<String> list){
		ItemStack pow = new ItemStack(item);
		ItemMeta powmeta = pow.getItemMeta();
		powmeta.setDisplayName(nome.replace("&", "§"));
		powmeta.setLore(list);
		pow.setItemMeta(powmeta);
		inv.setItem(lugar, pow);
	}
	
	public static void setItem(Inventory inv, int lugar, int quantidade, Material item, String nome, List<String> list, Enchantment enchant, int level){
		ItemStack pow = new ItemStack(item, quantidade);
		pow.addUnsafeEnchantment(enchant, level);
		ItemMeta powmeta = pow.getItemMeta();
		powmeta.setDisplayName(nome.replace("&", "§"));
		powmeta.setLore(list);
		pow.setItemMeta(powmeta);
		inv.setItem(lugar, pow);
	}
	
	public static void setItem(Inventory inv, int lugar, Material item, String nome, List<String> list, Enchantment enchant, int level){
		ItemStack pow = new ItemStack(item);
		pow.addUnsafeEnchantment(enchant, level);
		ItemMeta powmeta = pow.getItemMeta();
		powmeta.setDisplayName(nome.replace("&", "§"));
		powmeta.setLore(list);
		pow.setItemMeta(powmeta);
		inv.setItem(lugar, pow);
	}
	
	public static void setItem(Inventory inv, int lugar, int shorte, Material item, String nome){
		ItemStack pow = new ItemStack(item);
		pow.setDurability((short)shorte);
		ItemMeta powmeta = pow.getItemMeta();
		powmeta.setDisplayName(nome.replace("&", "§"));
		pow.setItemMeta(powmeta);
		inv.setItem(lugar, pow);
	}
	
	public static void setItem(Inventory inv, int lugar, int shorte, Material item, String nome, List<String> list){
		ItemStack pow = new ItemStack(item);
		pow.setDurability((short)shorte);
		ItemMeta powmeta = pow.getItemMeta();
		powmeta.setDisplayName(nome.replace("&", "§"));
		powmeta.setLore(list);
		pow.setItemMeta(powmeta);
		inv.setItem(lugar, pow);
	}
	
	public static void setItemSKULL(Player p, Inventory inv, int lugar, String nome){
		ItemStack pow = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
		SkullMeta powmeta = (SkullMeta) pow.getItemMeta();
		powmeta.setOwner(p.getName());
		powmeta.setDisplayName(nome.replace("&", "§"));
		pow.setItemMeta(powmeta);
		inv.setItem(lugar, pow);
	}
	
	public static void setKit(Player p, String kit, Inventory inv, Material item, String nome){
		if (p.hasPermission("kit."+kit)){
			ItemStack pow = new ItemStack(item);
			ItemMeta powmeta = pow.getItemMeta();
			powmeta.setDisplayName(nome.replace("&", "§"));
			pow.setItemMeta(powmeta);
			inv.addItem(pow);
		}
	}
	
	public static void setKit(Player p, String kit, Inventory inv, Material item, String nome, int shorte){
		if (p.hasPermission("kit."+kit)){
			ItemStack pow = new ItemStack(item);
			pow.setDurability((short)shorte);
			ItemMeta powmeta = pow.getItemMeta();
			powmeta.setDisplayName(nome.replace("&", "§"));
			pow.setItemMeta(powmeta);
			inv.addItem(pow);
		}
	}
	
	public static void CriarItemInventario(Player p, ItemStack mt, int lugar){	
		p.getInventory().setItem(lugar, mt);
	}
	
	public static void CriarItemInventarioSKULL(Player p, String nome, int lugar){
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
		SkullMeta itemmeta = (SkullMeta) item.getItemMeta();
		itemmeta.setOwner(p.getName());
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}
	
	public static void CriarItemInventario(Player p, Material mt, String nome, int lugar){
		ItemStack item = new ItemStack(mt);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}
	
	public static void CriarItemInventario(Player p, Material mt, String nome, int lugar, Enchantment enchant, int level){
		ItemStack item = new ItemStack(mt);
		item.addUnsafeEnchantment(enchant, level);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}
	
	public static void fullSoup(Player p){
		if (!p.getInventory().contains(Material.MUSHROOM_SOUP)){
			for (int i = 0; i < 36; i++){
				p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
			}
		}
	}
	
	public static void EncherInventario(Inventory inv, Material item){
		ItemStack it = new ItemStack(item);
		ItemMeta itmeta = it.getItemMeta();
		itmeta.setDisplayName("§6StewGames");
		it.setItemMeta(itmeta);
		
		ItemStack[] inte = inv.getContents();
		for (int i = 0; i < inv.getContents().length; i++){
			ItemStack itens = inte[i];
			if (itens == null){
				inv.setItem(inv.firstEmpty(), it);
			}
		}
	}
	
	public static void EncherInventario(Inventory inv, Material item, String nome){
		ItemStack it = new ItemStack(item);
		ItemMeta itmeta = it.getItemMeta();
		itmeta.setDisplayName(nome);
		it.setItemMeta(itmeta);
		
		ItemStack[] inte = inv.getContents();
		for (int i = 0; i < inv.getContents().length; i++){
			ItemStack itens = inte[i];
			if (itens == null){
				inv.setItem(inv.firstEmpty(), it);
			}
		}
	}
}
