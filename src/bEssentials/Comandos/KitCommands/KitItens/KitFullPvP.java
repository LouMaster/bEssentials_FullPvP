package bEssentials.Comandos.KitCommands.KitItens;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import bEssentials.Utils;

public class KitFullPvP {

	public KitFullPvP(){}
	
	public void sendKitMembro(Player p){
		Utils.CriarItemInventario(p, new ItemStack(Material.IRON_SWORD));
		Utils.CriarItemInventario(p, new ItemStack(Material.CHAINMAIL_HELMET));
		Utils.CriarItemInventario(p, new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		Utils.CriarItemInventario(p, new ItemStack(Material.CHAINMAIL_LEGGINGS));
		Utils.CriarItemInventario(p, new ItemStack(Material.CHAINMAIL_BOOTS));
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 5));
	}
	
	public void sendKitvipiron(Player p){
		ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
		espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
		espada.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		espada.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
		p.getInventory().addItem(espada);
		
		ItemStack armor = new ItemStack(Material.DIAMOND_HELMET);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		armor.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		ItemStack armor1 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		armor1.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		ItemStack armor2 = new ItemStack(Material.DIAMOND_LEGGINGS);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		armor2.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		ItemStack armor3 = new ItemStack(Material.DIAMOND_BOOTS);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		armor3.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		p.getInventory().addItem(armor);
		p.getInventory().addItem(armor1);
		p.getInventory().addItem(armor2);
		p.getInventory().addItem(armor3);
		
		ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
		pick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
		pick.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		pick.addUnsafeEnchantment(Enchantment.DIG_SPEED, 3);
		p.getInventory().addItem(pick);
		
		ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
		axe.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		axe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 3);
		axe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
		p.getInventory().addItem(axe);
		
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 10, (short)1));
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 15));
	}
	
	public void sendKitvipgold(Player p){
		ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
		espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
		espada.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		espada.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
		p.getInventory().addItem(espada);
		
		ItemStack armor = new ItemStack(Material.DIAMOND_HELMET);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		armor.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		ItemStack armor1 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		armor1.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		ItemStack armor2 = new ItemStack(Material.DIAMOND_LEGGINGS);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		armor2.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		ItemStack armor3 = new ItemStack(Material.DIAMOND_BOOTS);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		armor3.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		p.getInventory().addItem(armor);
		p.getInventory().addItem(armor1);
		p.getInventory().addItem(armor2);
		p.getInventory().addItem(armor3);
		
		ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
		pick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
		pick.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		pick.addUnsafeEnchantment(Enchantment.DIG_SPEED, 4);
		p.getInventory().addItem(pick);
		
		ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
		axe.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		axe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 4);
		axe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 2);
		p.getInventory().addItem(axe);
		
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 15, (short)1));
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 20));
	}
	
	public void sendKitvipdiamond(Player p){
		ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
		espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
		espada.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		espada.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
		p.getInventory().addItem(espada);
		
		ItemStack armor = new ItemStack(Material.DIAMOND_HELMET);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		armor.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		ItemStack armor1 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		armor1.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		ItemStack armor2 = new ItemStack(Material.DIAMOND_LEGGINGS);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		armor2.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		ItemStack armor3 = new ItemStack(Material.DIAMOND_BOOTS);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		armor3.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		p.getInventory().addItem(armor);
		p.getInventory().addItem(armor1);
		p.getInventory().addItem(armor2);
		p.getInventory().addItem(armor3);
		
		ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
		pick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
		pick.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		pick.addUnsafeEnchantment(Enchantment.DIG_SPEED, 4);
		p.getInventory().addItem(pick);
		
		ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
		axe.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		axe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 4);
		axe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
		p.getInventory().addItem(axe);
		
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 20, (short)1));
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 25));
	}
	
	public void sendKitvipemerald(Player p){
		ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
		espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
		espada.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		espada.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
		p.getInventory().addItem(espada);
		
		ItemStack armor = new ItemStack(Material.DIAMOND_HELMET);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		armor.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		ItemStack armor1 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		armor1.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		ItemStack armor2 = new ItemStack(Material.DIAMOND_LEGGINGS);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		armor2.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		ItemStack armor3 = new ItemStack(Material.DIAMOND_BOOTS);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		armor3.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		p.getInventory().addItem(armor);
		p.getInventory().addItem(armor1);
		p.getInventory().addItem(armor2);
		p.getInventory().addItem(armor3);
		
		ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
		pick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
		pick.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		pick.addUnsafeEnchantment(Enchantment.DIG_SPEED, 5);
		p.getInventory().addItem(pick);
		
		ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
		axe.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		axe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 5);
		axe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
		p.getInventory().addItem(axe);
		
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 25, (short)1));
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 30));
	}
	
	public void sendKitviplegendary(Player p){
		ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
		espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
		espada.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		espada.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
		p.getInventory().addItem(espada);
		
		ItemStack armor = new ItemStack(Material.DIAMOND_HELMET);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		armor.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		ItemStack armor1 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		armor1.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		ItemStack armor2 = new ItemStack(Material.DIAMOND_LEGGINGS);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		armor2.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		ItemStack armor3 = new ItemStack(Material.DIAMOND_BOOTS);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		armor3.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		p.getInventory().addItem(armor);
		p.getInventory().addItem(armor1);
		p.getInventory().addItem(armor2);
		p.getInventory().addItem(armor3);
		
		ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
		pick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 6);
		pick.addUnsafeEnchantment(Enchantment.DURABILITY, 6);
		pick.addEnchantment(Enchantment.DIG_SPEED, 30);
		p.getInventory().addItem(pick);
		
		ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
		axe.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		axe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 5);
		axe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
		p.getInventory().addItem(axe);
		
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 30, (short)1));
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 35));
	}
}
