package bEssentials.Comandos;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.bukkit.Bukkit;
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

import bEssentials.Main;
import bUtils.Utils;

public class CommandsTogle implements CommandExecutor, Listener {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("toggle")){
			sendInventory(p);
			p.sendMessage("§aMenu de configurações aberto.");
		}
		return false;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		if (e.getCurrentItem() != null && (e.getCurrentItem().getItemMeta() != null) && (e.getCurrentItem().getItemMeta().getDisplayName() != null)){
			Player p = (Player) e.getWhoClicked();
			Inventory i = e.getInventory();
			
			if (i.getTitle().equalsIgnoreCase("§6Configurações editáveis:")){
				e.setCancelled(true);
				
				if (e.getSlot() == 9){
					if (getBoolean(p, "MoneyRecivied")){
						setBoolean(p, "MoneyRecivied", false);
						p.sendMessage("§aConfiguração modificada com sucesso.");
						sendInventory(p);
					} else {
						setBoolean(p, "MoneyRecivied", true);
						p.sendMessage("§aConfiguração modificada com sucesso.");
						sendInventory(p);
					}
				} else if (e.getSlot() == 11){
					if (getBoolean(p, "TellMessage")){
						setBoolean(p, "TellMessage", false);
						p.sendMessage("§aConfiguração modificada com sucesso.");
						sendInventory(p);
					} else {
						setBoolean(p, "TellMessage", true);
						p.sendMessage("§aConfiguração modificada com sucesso.");
						sendInventory(p);
					}
				} else if (e.getSlot() == 13){
					if (getBoolean(p, "DeathMessage")){
						setBoolean(p, "DeathMessage", false);
						p.sendMessage("§aConfiguração modificada com sucesso.");
						sendInventory(p);
					} else {
						setBoolean(p, "DeathMessage", true);
						p.sendMessage("§aConfiguração modificada com sucesso.");
						sendInventory(p);
					}
				} else if (e.getSlot() == 15){
					if (getBoolean(p, "TpaConvite")){
						setBoolean(p, "TpaConvite", false);
						p.sendMessage("§aConfiguração modificada com sucesso.");
						sendInventory(p);
					} else {
						setBoolean(p, "TpaConvite", true);
						p.sendMessage("§aConfiguração modificada com sucesso.");
						sendInventory(p);
					}
				}
			}
		}
	}
	
	public static void setBoolean(Player p, String path, boolean b){
		File file = new File(Main.plugin.getDataFolder(), "Configuraçoes.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		cfg.set(p.getUniqueId().toString()+"."+path, b);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static  boolean getBoolean(Player p, String path){
		File file = new File(Main.plugin.getDataFolder(), "Configuraçoes.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		return cfg.getBoolean(p.getUniqueId().toString()+"."+path);
	}
	
	@SuppressWarnings("deprecation")
	public static  void setAtivadoOuDesativadoItem(Inventory inv, int local, Player p, String nome, String path){
		File file = new File(Main.plugin.getDataFolder(), "Configuraçoes.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		if (cfg.get(p.getUniqueId().toString()+"."+path) == null){
			cfg.set(p.getUniqueId().toString()+"."+path, true);
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (cfg.getBoolean(p.getUniqueId().toString()+"."+path) == true){
			Utils.setItem(inv, local, 5, Material.getMaterial(160), nome+"§aAtivado");
		} else {
			Utils.setItem(inv, local, 14, Material.getMaterial(160), nome+"§cDesativado");
		}
	}
	
	public static  void sendInventory(Player p){
		Inventory inv = Bukkit.createInventory(p, 54, "§6Configurações editáveis:");
		
		Utils.setItem(inv, 0, Material.DIAMOND, "§6Receber money?", Arrays.asList(
		"§7Ativando ou desativando essa opção", "§7você passará a receber ou não receber", "§7dinheiro de outros jogadores."));
		setAtivadoOuDesativadoItem(inv, 9, p, "§6Receber money: ", "MoneyRecivied");
		
		Utils.setItem(inv, 2, Material.PAPER, "§6Mensagens privadas?", Arrays.asList(
		"§7Ativando ou desativando essa opção", "§7você passará a receber ou não receber", "§7mensagens enviada pelo comando /tell."));
		setAtivadoOuDesativadoItem(inv, 11, p, "§6Mensagens privadas: ",  "TellMessage");
		
		Utils.setItem(inv, 4, Material.DIAMOND_SWORD, "§6Mensagens de mortes?", Arrays.asList(
		"§7Ativando ou desativando essa opção", "§7você passará a receber ou não receber", "§7mensagens de mortes de jogadores."));
		setAtivadoOuDesativadoItem(inv, 13, p, "§6Mensagens de mortes: ",  "DeathMessage");
		
		Utils.setItem(inv, 6, Material.ENDER_PEARL, "§6Convites de tpa?", Arrays.asList(
		"§7Ativando ou desativando essa opção", "§7você passará a receber ou não receber", "§7convites de teleporte por jogadores."));
		setAtivadoOuDesativadoItem(inv, 15, p, "§6Convites de tpa: ",  "TpaConvite");
		
		p.openInventory(inv);
	}
}