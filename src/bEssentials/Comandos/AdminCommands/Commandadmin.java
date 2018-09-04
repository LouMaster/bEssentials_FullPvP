package bEssentials.Comandos.AdminCommands;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import bEssentials.Prefix;
import bEssentials.Utils;

public class Commandadmin implements CommandExecutor {

	public static ArrayList<Player> admin = new ArrayList<Player>();
	public static HashMap<Player, ItemStack[]> InventoryPLAYER = new HashMap<>();
	public static HashMap<Player, ItemStack[]> ArmorPLAYER = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("admin")){
			if (!p.hasPermission("bEssentials.admin.admin")){
				p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem permissão para usar esse comando!");
			} else {
				if (!admin.contains(p)){
					p.sendMessage(Prefix.PREFIX_SUCESS+"Você entrou no modo admin!");
					
					admin.add(p);
					p.setGameMode(GameMode.CREATIVE);
					InventoryPLAYER.put(p, p.getInventory().getContents());
					ArmorPLAYER.put(p, p.getInventory().getArmorContents());
					p.getInventory().clear(); p.getInventory().setArmorContents(null);
					for (Player all : Bukkit.getOnlinePlayers()){
						all.hidePlayer(p);
						if (all.hasPermission("bEssentials.admin.admin")){
							all.showPlayer(p);
						}
					}
					
					Utils.CriarItemInventario(p, Material.GLASS_BOTTLE, "§6Sair/Entrar no modo Admin", 0);
				} else {
					p.sendMessage(Prefix.PREFIX_SUCESS+"Você saiu do modo admin.");
					
					admin.remove(p);
					p.getInventory().clear();
					p.setGameMode(GameMode.SURVIVAL);
					
					p.getInventory().setContents(InventoryPLAYER.get(p));
					p.getInventory().setArmorContents(ArmorPLAYER.get(p));
					for (Player all : Bukkit.getOnlinePlayers()){
						all.showPlayer(p);
					}
				}
			}
		}
		return false;
	}
}
