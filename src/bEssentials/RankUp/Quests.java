package bEssentials.RankUp;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import bEssentials.Main;
import bEssentials.Utils;

public class Quests implements Listener, CommandExecutor{
	
	static Plugin plugin;

	public Quests(Main main) {
		plugin = main;
	}
	
	static int Matar1 = 100;
	static int Matar2 = 600;
	static int Matar3 = 1600;
	static int Matar4 = 6600;
	static int Matar5 = 16600;
	
	static int Arco1 = 100;
	static int Arco2 = 600;
	static int Arco3 = 1600;
	static int Arco4 = 6600;
	static int Arco5 = 16600;
	
	public static int Blocos1 = 1000;
	public static int Blocos2 = 6000;
	public static int Blocos3 = 16000;
	public static int Blocos4 = 66000;
	public static int Blocos5 = 166000;
	

	@EventHandler
	public void matar(PlayerDeathEvent e){
		if(e.getEntity().getKiller() instanceof Player){
			Player p = e.getEntity().getKiller();
			int kills = plugin.getConfig().getInt("Quests."+p.getUniqueId()+".matar");
			if(kills != 0){
			plugin.getConfig().set("Quests."+p.getUniqueId()+".matar", kills+1);
			plugin.saveConfig();
			}else if(kills == 0){
				plugin.getConfig().set("Quests."+p.getUniqueId()+".matar", 1);
				plugin.saveConfig();
			}
			if(kills+1 == Quests.Matar1){
				p.sendMessage("§aVocê completou a Quest de matar "+Quests.Matar1+" pessoas!");
				p.sendMessage("§aEntão você ganhou um Espada Lvl 1!");
				ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
				espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
				espada.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				espada.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
				p.getInventory().addItem(espada);
				
			}else if(kills+1 == Quests.Matar2){
				p.sendMessage("§aVocê completou a Quest de matar "+Quests.Matar2+" pessoas!");
				p.sendMessage("§aEntão você ganhou um Espada Lvl 2!");
				ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
				espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
				espada.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				espada.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
				p.getInventory().addItem(espada);
				
			}else if(kills+1 == Quests.Matar3){
				p.sendMessage("§aVocê completou a Quest de matar "+Quests.Matar3+" pessoas!");
				p.sendMessage("§aEntão você ganhou um Espada Lvl 3!");
				ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
				espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
				espada.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
				espada.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
				p.getInventory().addItem(espada);
				
			}else if(kills+1 == Quests.Matar4){
				p.sendMessage("§aVocê completou a Quest de matar "+Quests.Matar4+" pessoas!");
				p.sendMessage("§aEntão você ganhou um Espada Lvl 4!");
				ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
				espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
				espada.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
				espada.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 3);
				p.getInventory().addItem(espada);
				
			}else if(kills+1 == Quests.Matar5){
				p.sendMessage("§aVocê completou a Quest de matar "+Quests.Matar5+" pessoas!");
				p.sendMessage("§aEntão você ganhou um Espada Lvl 5!");
				ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
				espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
				espada.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
				espada.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 3);
				p.getInventory().addItem(espada);
			}
		}
	}
	@EventHandler
	public void kills(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Projectile){
			Projectile projectile = (Projectile) e.getDamager();
			if(e.getEntity() instanceof Player && projectile.getShooter() instanceof Player){
	        Player p = (Player) projectile.getShooter();
			int arcos = plugin.getConfig().getInt("Quests."+p.getUniqueId()+".arco");
			if(arcos != 0){
			plugin.getConfig().set("Quests."+p.getUniqueId()+".arco", arcos+1);
			plugin.saveConfig();
			}else if(arcos == 0){
				plugin.getConfig().set("Quests."+p.getUniqueId()+".arco", 1);
				plugin.saveConfig();
			}
			if(arcos+1 == Quests.Arco1){
				p.sendMessage("§aVocê completou a Quest de acertar "+Quests.Arco1+" flechas!");
				p.sendMessage("§aEntão você ganhou um Arco Lvl 1!");
				ItemStack arco = new ItemStack(Material.BOW);
				arco.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 3);
				arco.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 2);
				arco.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
				arco.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 2);
				p.getInventory().addItem(arco);
				
			}else if(arcos+1 == Quests.Arco2){
				p.sendMessage("§aVocê completou a Quest de acertar "+Quests.Arco2+" flechas!");
				p.sendMessage("§aEntão você ganhou um Arco Lvl 2!");
				ItemStack arco = new ItemStack(Material.BOW);
				arco.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 4);
				arco.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 2);
				arco.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
				arco.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 2);
				p.getInventory().addItem(arco);
				
			}else if(arcos+1 == Quests.Arco3){
				p.sendMessage("§aVocê completou a Quest de acertar "+Quests.Arco3+" flechas!");
				p.sendMessage("§aEntão você ganhou um Arco Lvl 3!");
				ItemStack arco = new ItemStack(Material.BOW);
				arco.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 3);
				arco.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 2);
				arco.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 4);
				arco.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 2);
				p.getInventory().addItem(arco);
				
			}else if(arcos+1 == Quests.Arco4){
				p.sendMessage("§aVocê completou a Quest de acertar "+Quests.Arco4+" flechas!");
				p.sendMessage("§aEntão você ganhou um Arco Lvl 4!");
				ItemStack arco = new ItemStack(Material.BOW);
				arco.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 6);
				arco.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
				p.getInventory().addItem(arco);
				
			}else if(arcos+1 == Quests.Arco5){
				p.sendMessage("§aVocê completou a Quest de acertar "+Quests.Arco5+" flechas!");
				p.sendMessage("§aEntão você ganhou um Arco Lvl 5!");
				ItemStack arco = new ItemStack(Material.BOW);
				arco.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 6);
				arco.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 4);
				arco.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
				p.getInventory().addItem(arco);
			}
		}
		}
	}
	public static void sendInv(Player p){
		Inventory inv = Bukkit.createInventory(p, 27, "§6Quests do "+p.getName());
		int killsLvL = 1;
		int next = Matar1;
		int kills = plugin.getConfig().getInt("Quests."+p.getUniqueId()+".matar");
		if(kills != 0){
			if(kills >= Matar1){
				killsLvL = 2;
				next = Matar2;
			}else if(kills < Matar1){
				killsLvL = 1;
				next = Matar1;
			}
			if(kills >= Matar2){
				next = Matar3;
				killsLvL = 3;
			}
			if(kills >= Matar3){
				next = Matar4;
				killsLvL = 4;
			}
			if(kills >= Matar4){
				next = Matar5;
				killsLvL = 5;
			}
			if(kills >= Matar5){
				next = Matar5;
				killsLvL = 6;
			}
		}
		
		int blockLvL = 1;
		int next2 = Blocos1;
		int blocos = plugin.getConfig().getInt("Quests."+p.getUniqueId()+".blocos");
		if(blocos != 0){
			if(blocos >= Blocos1){
				blockLvL = 2;
				next2 = Blocos2;
			}else if(blocos < Blocos1){
				blockLvL = 1;
				next2 = Blocos1;
			}
			if(blocos >= Blocos2){
				next2 = Blocos3;
				blockLvL = 3;
			}
			if(blocos >= Blocos3){
				next2 = Blocos4;
				blockLvL = 4;
			}
			if(blocos >= Blocos4){
				next2 = Blocos5;
				blockLvL = 5;
			}
			if(blocos >= Blocos5){
				next2 = Blocos5;
				blockLvL = 6;
			}
		}
		
		int arcoLvL = 1;
		int next3 = Arco1;
		int arco = plugin.getConfig().getInt("Quests."+p.getUniqueId()+".arco");
		if(arco != 0){
			if(arco >= Arco1){
				arcoLvL = 2;
				next3 = Arco2;
			}else if(arco < Arco1){
				arcoLvL = 1;
				next3 = Arco1;
			}
			if(arco >= Arco2){
				next3 = Arco3;
				arcoLvL = 3;
			}
			if(arco >= Arco3){
				next3 = Arco4;
				arcoLvL = 4;
			}
			if(arco >= Arco4){
				next3 = Arco5;
				arcoLvL = 5;
			}
			if(arco >= Arco5){
				next3 = Arco5;
				arcoLvL = 6;
			}
		}
		int final1 = next-kills;
		int final2 = next2-blocos;
		int final3 = next3-arco;
		Utils.setItem(inv, 11, Material.DIAMOND_SWORD, "§aKills:§6 "+kills, Arrays.asList("§7Você é level §6"+killsLvL, "§7você precisa de mais §6"+final1+"§7 kills","§7para passar de nivel!"));
		Utils.setItem(inv, 13, Material.BOW, "§aFechas Acertadas:§6 "+arco, Arrays.asList("§7Você é level §6"+arcoLvL, "§7você precisa acertar mais §6"+final3+"§7 flechas","§7para passar de nivel!"));
		Utils.setItem(inv, 15, Material.DIAMOND_ORE, "§aBlocos Quebrados:§6 "+blocos, Arrays.asList("§7Você é level §6"+blockLvL, "§7você precisa quebrar mais §6"+final2+"§7 blocos","§7para passar de nivel!"));
		
        p.openInventory(inv);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("quests")){
			sendInv(p);
		}
		return false;
	}

}
