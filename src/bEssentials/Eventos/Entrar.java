package bEssentials.Eventos;

import java.io.File;
import java.util.Collection;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

import TEssentials.Utilidades.Grupos;
import bEssentials.Configs;
import bEssentials.Main;
import bEssentials.Prefix;
import bEssentials.Comandos.CommandsTogle;
import bEssentials.Comandos.KitCommands.Commandkit;
import bEssentials.RankUp.Quests;

public class Entrar implements Listener{
  
	static Plugin plugin;

	public Entrar(Main main) {
		plugin = main;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		e.setJoinMessage(null);
		Grupos.grupo(e.getPlayer());
		Player p = e.getPlayer();
		Configs config = new Configs();
		
		if (config.getConfigPlayer(p, "MoneyRecivied")){
			CommandsTogle.setBoolean(p, "MoneyRecivied", true);	
			
		} else if (config.getConfigPlayer(p, "TellMessage")){
			CommandsTogle.setBoolean(p, "TellMessage", true);	
			
		} else if (config.getConfigPlayer(p, "DeathMessage")){
			CommandsTogle.setBoolean(p, "DeathMessage", false);	
			
		} else if (config.getConfigPlayer(p, "TpaConvite")){
			CommandsTogle.setBoolean(p, "TpaConvite", true);	
			
		}
		
		File cooldown = new File(Main.plugin.getDataFolder(), "Cooldowns.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(cooldown);
		
		Commandkit.cooldownCOMIDA.put(p.getName(), cfg.getLong(p.getName()+".comida"));
		Commandkit.cooldownMEMBRO.put(p.getName(), cfg.getLong(p.getName()+".membro"));
		Commandkit.cooldownIRON.put(p.getName(), cfg.getLong(p.getName()+".iron"));
		Commandkit.cooldownGOLD.put(p.getName(), cfg.getLong(p.getName()+".gold"));
		Commandkit.cooldownDIAMOND.put(p.getName(), cfg.getLong(p.getName()+".diamond"));
		Commandkit.cooldownEMERALD.put(p.getName(), cfg.getLong(p.getName()+".emerald"));
		Commandkit.cooldownLEGENDARY.put(p.getName(), cfg.getLong(p.getName()+".legendary"));
		try{
			World w = Bukkit.getWorld(plugin.getConfig().getString("SpawnWorld"));
			int x = plugin.getConfig().getInt("SpawnX");
			int y = plugin.getConfig().getInt("SpawnY");
			int z = plugin.getConfig().getInt("SpawnZ");
			float YA = plugin.getConfig().getInt("SpawnYA");
			int PI = plugin.getConfig().getInt("SpawnPI");
			Location l = new Location(w, x, y, z);
			l.setPitch(PI);
			l.setYaw(YA);
			p.teleport(l);
			}catch(Exception e1){
				p.sendMessage(Prefix.PREFIX_ERROR+"Não foi possivel ir para o spawn. Desculpe.");
			}
	}
	
	Random rand = new Random();
	@SuppressWarnings("incomplete-switch")
	public boolean getOre(Block b){
	    switch (b.getType()) {
	    case BOOK: 
	    case BREAD: 
	    case COOKED_BEEF: 
	    case DIAMOND_LEGGINGS: 
	    case DIAMOND_ORE: 
	    case GOLD_HOE: 
	      return true;
	    }
	    return false;
	  }
	
	  @SuppressWarnings("unused")
	public void blockBreak(Player player, Collection<ItemStack> drops, BlockBreakEvent event){
	    boolean fortune = false;
	    if ((player.getItemInHand() != null) && (getOre(event.getBlock())) && 
	      (player.getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS))) {
	      fortune = true;
	    }
	    for (ItemStack finaldrop : drops) {
	      if (player.getInventory().firstEmpty() != -1){
	        if (fortune){
	          int level = player.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
	          for (int x = level; level > 0; level--){
	            int r = this.rand.nextInt(3);
	            if (r == 1) {
	              player.getInventory().addItem(new ItemStack[] { finaldrop });
	            }
	          }
	          player.getInventory().addItem(new ItemStack[] { finaldrop });
	        }else{
	          player.getInventory().addItem(new ItemStack[] { finaldrop });
	        }
	      }else{
	        player.getWorld().dropItemNaturally(event.getBlock().getLocation(), finaldrop);
	        player.sendMessage(Prefix.PREFIX_ERROR+"Você está com o inventário cheio.");
	        player.updateInventory();
	      }
	    }
	    if ((player.getItemInHand() != null) && (player.getItemInHand().getType().getMaxDurability() > 0)) {
	    	player.getItemInHand().setDurability((short)(player.getItemInHand().getDurability() + 1));
	    }
	    if (player.getItemInHand().getDurability() >= player.getItemInHand().getType().getMaxDurability()){
	      player.setItemInHand(new ItemStack(Material.AIR));
	      player.playSound(player.getLocation(), Sound.ITEM_BREAK, 1.0F, 1.0F);
	    }
	    player.updateInventory();
	    event.getBlock().setType(Material.AIR);
	    event.setCancelled(true);
	  }
	
	
	  @EventHandler(priority=EventPriority.HIGH)
	  public void PlayerBreak(BlockBreakEvent event){
	    WorldGuardPlugin wg = Main.getWorldGuard();
	    Player player = event.getPlayer();
	    Player p = event.getPlayer();
	    Block block = event.getBlock();
	    Collection<ItemStack> drops = event.getBlock().getDrops();
	    if (player.getGameMode() == GameMode.CREATIVE) {
	      return;
	    }
	    if (wg.canBuild(player, block) || player.hasPermission("minerar.mineraBoy") || wg == null) {	   
			int blocos = plugin.getConfig().getInt("Quests."+p.getUniqueId()+".blocos");
			if(blocos != 0){
			plugin.getConfig().set("Quests."+p.getUniqueId()+".blocos", blocos+1);
			plugin.saveConfig();
			if(blocos+1 == Quests.Blocos1){
				p.sendMessage("§aVocê completou a Quest de quebrar "+Quests.Blocos1+" blocos!");
				p.sendMessage("§aEntão você ganhou uma Picareta Lvl 1!");
				ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
				pick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 5);
				pick.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
				pick.addUnsafeEnchantment(Enchantment.DIG_SPEED, 30);
				p.getInventory().addItem(pick);
			}else if(blocos+1 == Quests.Blocos2){
				p.sendMessage("§aVocê completou a Quest de quebrar "+Quests.Blocos2+" blocos!");
				p.sendMessage("§aEntão você ganhou uma Picareta Lvl 2!");
				ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
				pick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 5);
				pick.addUnsafeEnchantment(Enchantment.DURABILITY, 4);
				pick.addUnsafeEnchantment(Enchantment.DIG_SPEED, 35);
				p.getInventory().addItem(pick);
			}else if(blocos+1 == Quests.Blocos3){
				p.sendMessage("§aVocê completou a Quest de quebrar "+Quests.Blocos3+" blocos!");
				p.sendMessage("§aEntão você ganhou uma Picareta Lvl 3!");
				ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
				pick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 5);
				pick.addUnsafeEnchantment(Enchantment.DIG_SPEED, 40);
				p.getInventory().addItem(pick);
			}else if(blocos+1 == Quests.Blocos4){
				p.sendMessage("§aVocê completou a Quest de quebrar "+Quests.Blocos4+" blocos!");
				p.sendMessage("§aEntão você ganhou uma Picareta Lvl 4!");
				ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
				pick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 6);
				pick.addUnsafeEnchantment(Enchantment.DIG_SPEED, 37);
				p.getInventory().addItem(pick);
			}else if(blocos+1 == Quests.Blocos5){
				p.sendMessage("§aVocê completou a Quest de quebrar "+Quests.Blocos5+" blocos!");
				p.sendMessage("§aEntão você ganhou uma Picareta Lvl 5!");
				ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
				pick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 7);
				pick.addUnsafeEnchantment(Enchantment.DIG_SPEED, 37);
				p.getInventory().addItem(pick);
			}
			}else if(blocos == 0){
				plugin.getConfig().set("Quests."+p.getUniqueId()+".blocos", 1);
				plugin.saveConfig();
			}
	            blockBreak(player, drops, event);
	    }
	  }
	  
	  
	/**@EventHandler
	public void quebrar(BlockBreakEvent e){
		if(e.getBlock().getType().equals(Material.LAPIS_ORE)){
			if(e.getPlayer().getItemInHand().getType().equals(Material.DIAMOND_PICKAXE)||e.getPlayer().getItemInHand().getType().equals(Material.GOLD_PICKAXE)
					||e.getPlayer().getItemInHand().getType().equals(Material.IRON_PICKAXE)){
				int lvl = getLuck(e.getPlayer().getItemInHand().getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS));
				if(lvl == 0){
					lvl = 1;
				}
				for(ItemStack teste : e.getBlock().getDrops()){
					ItemStack afterrFo = teste;
					afterrFo.setAmount(lvl);
					e.getPlayer().getInventory().addItem(afterrFo);
				}
			}
			e.getBlock().setType(Material.AIR);
			e.setCancelled(true);
		}else if(e.getBlock().getType().equals(Material.EMERALD_ORE)){
			if(e.getPlayer().getItemInHand().getType().equals(Material.DIAMOND_PICKAXE)||e.getPlayer().getItemInHand().getType().equals(Material.GOLD_PICKAXE)
					||e.getPlayer().getItemInHand().getType().equals(Material.IRON_PICKAXE)){
				int lvl = getLuck(e.getPlayer().getItemInHand().getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS));
				if(lvl == 0){
					lvl = 1;
				}
				for(ItemStack teste : e.getBlock().getDrops()){
					ItemStack afterrFo = teste;
					afterrFo.setAmount(lvl);
					e.getPlayer().getInventory().addItem(afterrFo);
				}
			}
			e.getBlock().setType(Material.AIR);
			e.setCancelled(true);
		}else if(e.getBlock().getType().equals(Material.DIAMOND_ORE)){
			if(e.getPlayer().getItemInHand().getType().equals(Material.DIAMOND_PICKAXE)||e.getPlayer().getItemInHand().getType().equals(Material.GOLD_PICKAXE)
					||e.getPlayer().getItemInHand().getType().equals(Material.IRON_PICKAXE)){
				int lvl = getLuck(e.getPlayer().getItemInHand().getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS));
				if(lvl == 0){
					lvl = 1;
				}
				for(ItemStack teste : e.getBlock().getDrops()){
					ItemStack afterrFo = teste;
					afterrFo.setAmount(lvl);
					e.getPlayer().getInventory().addItem(afterrFo);
				}
			}
			e.getBlock().setType(Material.AIR);
			e.setCancelled(true);
		}else if(e.getBlock().getType().equals(Material.GOLD_ORE)){
			if(e.getPlayer().getItemInHand().getType().equals(Material.DIAMOND_PICKAXE)||e.getPlayer().getItemInHand().getType().equals(Material.GOLD_PICKAXE)
					||e.getPlayer().getItemInHand().getType().equals(Material.IRON_PICKAXE)){
				int lvl = getLuck(e.getPlayer().getItemInHand().getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS));
				if(lvl == 0){
					lvl = 1;
				}
				for(ItemStack teste : e.getBlock().getDrops()){
					ItemStack afterrFo = teste;
					afterrFo.setAmount(lvl);
					e.getPlayer().getInventory().addItem(afterrFo);
				}
			}
			e.getBlock().setType(Material.AIR);
			e.setCancelled(true);
		}else if(e.getBlock().getType().equals(Material.IRON_ORE)){
			if(e.getPlayer().getItemInHand().getType().equals(Material.DIAMOND_PICKAXE)||e.getPlayer().getItemInHand().getType().equals(Material.GOLD_PICKAXE)
					||e.getPlayer().getItemInHand().getType().equals(Material.IRON_PICKAXE)){
				int lvl = getLuck(e.getPlayer().getItemInHand().getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS));
				if(lvl == 0){
					lvl = 1;
				}
				for(ItemStack teste : e.getBlock().getDrops()){
					ItemStack afterrFo = teste;
					afterrFo.setAmount(lvl);
					e.getPlayer().getInventory().addItem(afterrFo);
				}
			}
			e.getBlock().setType(Material.AIR);
			e.setCancelled(true);
		}else if(e.getBlock().getType().equals(Material.COAL_ORE)){
			if(e.getPlayer().getItemInHand().getType().equals(Material.DIAMOND_PICKAXE)||e.getPlayer().getItemInHand().getType().equals(Material.GOLD_PICKAXE)
					||e.getPlayer().getItemInHand().getType().equals(Material.IRON_PICKAXE)){
				int lvl = getLuck(e.getPlayer().getItemInHand().getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS));
				if(lvl == 0){
					lvl = 1;
				}
				for(ItemStack teste : e.getBlock().getDrops()){
					ItemStack afterrFo = teste;
					afterrFo.setAmount(lvl);
					e.getPlayer().getInventory().addItem(afterrFo);
				}
			}
			e.getBlock().setType(Material.AIR);
			e.setCancelled(true);
		}else if(e.getBlock().getType().equals(Material.REDSTONE_ORE)){
			if(e.getPlayer().getItemInHand().getType().equals(Material.DIAMOND_PICKAXE)||e.getPlayer().getItemInHand().getType().equals(Material.GOLD_PICKAXE)
					||e.getPlayer().getItemInHand().getType().equals(Material.IRON_PICKAXE)){
				int lvl = getLuck(e.getPlayer().getItemInHand().getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS));
				for(ItemStack teste : e.getBlock().getDrops()){
					ItemStack afterrFo = teste;
					afterrFo.setAmount(lvl);
					e.getPlayer().getInventory().addItem(afterrFo);
				}
			}
			e.getBlock().setType(Material.AIR);
			e.setCancelled(true);
		}
	}**/
	
}
