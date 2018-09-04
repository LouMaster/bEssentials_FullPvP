package bEssentials.Comandos.KitCommands.KitItens;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import bEssentials.Utils;

public class KitFactions {

	public KitFactions(){}
	
	public void sendKitMembro(Player p){
		Utils.CriarItemInventario(p, new ItemStack(Material.STONE_SWORD, 1));
		Utils.CriarItemInventario(p, new ItemStack(Material.LEATHER_HELMET, 1));
		Utils.CriarItemInventario(p, new ItemStack(Material.LEATHER_CHESTPLATE, 1));
		Utils.CriarItemInventario(p, new ItemStack(Material.LEATHER_LEGGINGS, 1));
		Utils.CriarItemInventario(p, new ItemStack(Material.LEATHER_BOOTS, 1));
		Utils.CriarItemInventario(p, new ItemStack(Material.STONE_PICKAXE, 1));
		Utils.CriarItemInventario(p, new ItemStack(Material.STONE_AXE, 1));
	}
	
	public void sendKitIron(Player p){
		ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
		espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
		espada.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
		espada.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1);
		p.getInventory().addItem(espada);
		
		ItemStack arco = new ItemStack(Material.BOW);
		arco.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 2);
		arco.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		arco.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
		p.getInventory().addItem(arco);
		
		ItemStack armor = new ItemStack(Material.DIAMOND_HELMET);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		armor.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
		ItemStack armor1 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		armor1.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
		ItemStack armor2 = new ItemStack(Material.DIAMOND_LEGGINGS);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		armor2.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
		ItemStack armor3 = new ItemStack(Material.DIAMOND_BOOTS);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		armor3.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
		p.getInventory().addItem(armor);
		p.getInventory().addItem(armor1);
		p.getInventory().addItem(armor2);
		p.getInventory().addItem(armor3);
		
		ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
		pick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 5);
		pick.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		pick.addUnsafeEnchantment(Enchantment.DIG_SPEED, 30);
		p.getInventory().addItem(pick);
		
		ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
		axe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
		axe.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		axe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 20);
		p.getInventory().addItem(axe);
		
		ItemStack spade = new ItemStack(Material.DIAMOND_SPADE);
		spade.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
		spade.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		spade.addUnsafeEnchantment(Enchantment.DIG_SPEED, 20);
		p.getInventory().addItem(spade);
		
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 1, (short)1));
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 8));
		Utils.CriarItemInventario(p, new ItemStack(Material.ARROW, 1));
	}
	
	public void sendKitGold(Player p){
		ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
		espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
		espada.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		espada.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
		p.getInventory().addItem(espada);
		
		ItemStack arco = new ItemStack(Material.BOW);
		arco.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 3);
		arco.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 2);
		arco.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
		arco.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 2);
		p.getInventory().addItem(arco);
		
		ItemStack armor = new ItemStack(Material.DIAMOND_HELMET);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		armor.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 2);
		ItemStack armor1 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		armor1.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 2);
		ItemStack armor2 = new ItemStack(Material.DIAMOND_LEGGINGS);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		armor2.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 2);
		ItemStack armor3 = new ItemStack(Material.DIAMOND_BOOTS);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		armor3.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 2);
		p.getInventory().addItem(armor);
		p.getInventory().addItem(armor1);
		p.getInventory().addItem(armor2);
		p.getInventory().addItem(armor3);
		
		ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
		pick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 6);
		pick.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
		pick.addUnsafeEnchantment(Enchantment.DIG_SPEED, 34);
		p.getInventory().addItem(pick);
		
		ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
		axe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 5);
		axe.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
		axe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 24);
		p.getInventory().addItem(axe);
		
		ItemStack spade = new ItemStack(Material.DIAMOND_SPADE);
		spade.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 5);
		spade.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
		spade.addUnsafeEnchantment(Enchantment.DIG_SPEED, 24);
		p.getInventory().addItem(spade);
		
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1));
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 10));
		Utils.CriarItemInventario(p, new ItemStack(Material.ARROW, 1));
	}
	
	public void sendKitDiamond(Player p){
		ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
		espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
		espada.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		espada.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 3);
		p.getInventory().addItem(espada);
		
		ItemStack arco = new ItemStack(Material.BOW);
		arco.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 4);
		arco.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 3);
		arco.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 3);
		arco.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 3);
		p.getInventory().addItem(arco);
		
		ItemStack armor = new ItemStack(Material.DIAMOND_HELMET);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		armor.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 3);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 3);
		ItemStack armor1 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		armor1.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 3);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 3);
		ItemStack armor2 = new ItemStack(Material.DIAMOND_LEGGINGS);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		armor2.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 3);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 3);
		ItemStack armor3 = new ItemStack(Material.DIAMOND_BOOTS);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		armor3.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 3);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 3);
		p.getInventory().addItem(armor);
		p.getInventory().addItem(armor1);
		p.getInventory().addItem(armor2);
		p.getInventory().addItem(armor3);
		
		ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
		pick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 7);
		pick.addUnsafeEnchantment(Enchantment.DURABILITY, 7);
		pick.addUnsafeEnchantment(Enchantment.DIG_SPEED, 38);
		p.getInventory().addItem(pick);
		
		ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
		axe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 6);
		axe.addUnsafeEnchantment(Enchantment.DURABILITY, 6);
		axe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 30);
		p.getInventory().addItem(axe);
		
		ItemStack spade = new ItemStack(Material.DIAMOND_SPADE);
		spade.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 6);
		spade.addUnsafeEnchantment(Enchantment.DURABILITY, 6);
		spade.addUnsafeEnchantment(Enchantment.DIG_SPEED, 30);
		p.getInventory().addItem(spade);
		
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 2, (short)1));
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 12));
		Utils.CriarItemInventario(p, new ItemStack(Material.ARROW, 1));
	}
	
	public void sendKitEmerald(Player p){
		ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
		espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
		espada.addUnsafeEnchantment(Enchantment.DURABILITY, 4);
		espada.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 4);
		p.getInventory().addItem(espada);
		
		ItemStack arco = new ItemStack(Material.BOW);
		arco.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 5);
		arco.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 4);
		arco.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 4);
		p.getInventory().addItem(arco);
		
		ItemStack armor = new ItemStack(Material.DIAMOND_HELMET);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
		armor.addUnsafeEnchantment(Enchantment.DURABILITY, 4);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
		ItemStack armor1 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
		armor1.addUnsafeEnchantment(Enchantment.DURABILITY, 4);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
		ItemStack armor2 = new ItemStack(Material.DIAMOND_LEGGINGS);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
		armor2.addUnsafeEnchantment(Enchantment.DURABILITY, 4);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
		ItemStack armor3 = new ItemStack(Material.DIAMOND_BOOTS);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
		armor3.addUnsafeEnchantment(Enchantment.DURABILITY, 4);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
		p.getInventory().addItem(armor);
		p.getInventory().addItem(armor1);
		p.getInventory().addItem(armor2);
		p.getInventory().addItem(armor3);
		
		ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
		pick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 8);
		pick.addUnsafeEnchantment(Enchantment.DURABILITY, 8);
		pick.addUnsafeEnchantment(Enchantment.DIG_SPEED, 48);
		p.getInventory().addItem(pick);
		
		ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
		axe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
		axe.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		axe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 35);
		p.getInventory().addItem(axe);
		
		ItemStack spade = new ItemStack(Material.DIAMOND_SPADE);
		spade.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
		spade.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		spade.addUnsafeEnchantment(Enchantment.DIG_SPEED, 35);
		p.getInventory().addItem(spade);
		
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 4, (short)1));
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 12));
		Utils.CriarItemInventario(p, new ItemStack(Material.ARROW, 1));
	}
	
	public void sendKitLegendary(Player p){
		ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
		espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
		espada.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
		espada.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 5);
		p.getInventory().addItem(espada);
		
		ItemStack arco = new ItemStack(Material.BOW);
		arco.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 6);
		arco.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 5);
		arco.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 5);
		p.getInventory().addItem(arco);
		
		ItemStack armor = new ItemStack(Material.DIAMOND_HELMET);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
		armor.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5);
		armor.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
		ItemStack armor1 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
		armor1.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5);
		armor1.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
		ItemStack armor2 = new ItemStack(Material.DIAMOND_LEGGINGS);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
		armor2.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5);
		armor2.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
		ItemStack armor3 = new ItemStack(Material.DIAMOND_BOOTS);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
		armor3.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5);
		armor3.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
		p.getInventory().addItem(armor);
		p.getInventory().addItem(armor1);
		p.getInventory().addItem(armor2);
		p.getInventory().addItem(armor3);
		
		ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
		pick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 9);
		pick.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		pick.addUnsafeEnchantment(Enchantment.DIG_SPEED, 60);
		p.getInventory().addItem(pick);
		
		ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
		axe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 12);
		axe.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		axe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 38);
		p.getInventory().addItem(axe);
		
		ItemStack spade = new ItemStack(Material.DIAMOND_SPADE);
		spade.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 12);
		spade.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		spade.addUnsafeEnchantment(Enchantment.DIG_SPEED, 38);
		p.getInventory().addItem(spade);
		
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 6, (short)1));
		Utils.CriarItemInventario(p, new ItemStack(Material.GOLDEN_APPLE, 18));
		Utils.CriarItemInventario(p, new ItemStack(Material.ARROW, 1));
	}
}
