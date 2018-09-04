package bEssentials.Comandos.KitCommands;

import bEssentials.Comandos.KitCommands.KitItens.KitFactions;
import bEssentials.Comandos.KitCommands.KitItens.KitFullPvP;
import bEssentials.Main;
import bEssentials.Prefix;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Commandkit implements CommandExecutor, Listener {
	
	public static HashMap<String, Long> cooldownCOMIDA = new HashMap<String, Long>();
	public static HashMap<String, Long> cooldownMEMBRO = new HashMap<String, Long>();
	public static HashMap<String, Long> cooldownIRON = new HashMap<String, Long>();
	public static HashMap<String, Long> cooldownGOLD = new HashMap<String, Long>();
	public static HashMap<String, Long> cooldownDIAMOND = new HashMap<String, Long>();
	public static HashMap<String, Long> cooldownEMERALD = new HashMap<String, Long>();
	public static HashMap<String, Long> cooldownLEGENDARY = new HashMap<String, Long>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args){
		if (sender instanceof Player){
			Player p = (Player)sender;
			InventorysKit kitInventory = new InventorysKit();
			if (cmd.getName().equalsIgnoreCase("kit")){
				kitInventory.sendKitMenu(p);
			}
		}
		return false;
	}
	
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e){
		if (e.getCurrentItem() != null && (e.getCurrentItem().getItemMeta() != null) && (e.getCurrentItem().getItemMeta().getDisplayName() != null)){
			Player p = (Player)e.getWhoClicked();
			Inventory i = e.getInventory();
			InventorysKit kitInventory = new InventorysKit();
			
			if (i.getTitle().equalsIgnoreCase("§6Menu de Kits")){
				e.setCancelled(true);
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kits Membros")){
					kitInventory.sendKitMember(p);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kits VIPs")){
					kitInventory.sendKitVips(p);
				}
			}
		}
	}
    
    @EventHandler
    public void onClickSendKit(InventoryClickEvent e){
		if (e.getCurrentItem() != null && (e.getCurrentItem().getItemMeta() != null) && (e.getCurrentItem().getItemMeta().getDisplayName() != null)){
			Player p = (Player)e.getWhoClicked();
			Inventory i = e.getInventory();
			
			KitFactions facKit = new KitFactions();
			KitFullPvP fullKit = new KitFullPvP ();
			
			if (i.getTitle().equalsIgnoreCase("§6Kits membro disponíveis")){
				e.setCancelled(true);
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kit PvP")){
					p.closeInventory();
					if ((!cooldownMEMBRO.containsKey(p.getName())) || (((Long)cooldownMEMBRO.get(p.getName())).longValue() <= System.currentTimeMillis())){
						if (Main.HookedServer().equalsIgnoreCase("Factions")){
							facKit.sendKitMembro(p);
							
							cooldownMEMBRO.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(300L)));
				            p.sendMessage(Prefix.PREFIX_SUCESS + "Você pegou o kit 'Membro' com sucesso.");
						} else if (Main.HookedServer().equalsIgnoreCase("FullPvP")){
							fullKit.sendKitMembro(p);
							
							cooldownMEMBRO.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(300L)));
				            p.sendMessage(Prefix.PREFIX_SUCESS + "Você pegou o kit 'PvP' com sucesso.");
						}
					} else {
						p.sendMessage("§cVocê só pode pegar esse kit novamente em "+secToDays(TimeUnit.MILLISECONDS.toSeconds(cooldownMEMBRO.get(p.getName()).longValue() - System.currentTimeMillis())));
					}
				} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kit Comida")){
					p.closeInventory();
					if ((!cooldownCOMIDA.containsKey(p.getName())) || (((Long)cooldownCOMIDA.get(p.getName())).longValue() <= System.currentTimeMillis())){
						p.closeInventory();
						
						ItemStack bife = new ItemStack(Material.COOKED_BEEF, 5);
						ItemStack peix = new ItemStack(Material.COOKED_FISH, 5);
						ItemStack gali = new ItemStack(Material.COOKED_CHICKEN, 5);
						p.getInventory().addItem(new ItemStack[] {bife, peix, gali});
						
						p.sendMessage(Prefix.PREFIX_SUCESS + "Você pegou o kit 'Comida' com sucesso.");
						cooldownCOMIDA.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(300L)));
					} else {
						p.sendMessage("§cVocê só pode pegar esse kit novamente em "+secToDays(TimeUnit.MILLISECONDS.toSeconds(cooldownCOMIDA.get(p.getName()).longValue() - System.currentTimeMillis())));
					}
				}
			}
		}
    }
    @EventHandler
    public void onClickSendKitVip(InventoryClickEvent e){
		if (e.getCurrentItem() != null && (e.getCurrentItem().getItemMeta() != null) && (e.getCurrentItem().getItemMeta().getDisplayName() != null)){
			Player p = (Player)e.getWhoClicked();
			Inventory i = e.getInventory();
			
			KitFactions facKit = new KitFactions();
			KitFullPvP fullKit = new KitFullPvP ();
			
			if (i.getTitle().equalsIgnoreCase("§6Kits vip disponíveis")){
				e.setCancelled(true);
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7VIP Iron")){
					p.closeInventory();
					if (p.hasPermission("bEssentials.kit.vipiron")){
						if ((!cooldownIRON.containsKey(p.getName())) || (((Long)cooldownIRON.get(p.getName())).longValue() <= System.currentTimeMillis())){
							if (Main.HookedServer().equalsIgnoreCase("Factions")){
								facKit.sendKitIron(p);
								
					            p.sendMessage(Prefix.PREFIX_SUCESS + "Você pegou o kit 'Vip Iron' com sucesso.");
								cooldownIRON.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(86400L)));
							} else if (Main.HookedServer().equalsIgnoreCase("FullPvP")){
								fullKit.sendKitvipiron(p);
								
					            p.sendMessage(Prefix.PREFIX_SUCESS + "Você pegou o kit 'Vip Iron' com sucesso.");
					            cooldownIRON.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(86400L)));
							}
						} else {
							p.sendMessage("§cVocê só pode pegar esse kit novamente em "+secToDays(TimeUnit.MILLISECONDS.toSeconds(cooldownIRON.get(p.getName()).longValue() - System.currentTimeMillis())));
						}
					} else {
						p.sendMessage("§cVocê não tem permissão para pegar esse kit.");
					}
				} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6VIP Gold")){
					p.closeInventory();
					if (p.hasPermission("bEssentials.kit.vipgold")){
						if ((!cooldownGOLD.containsKey(p.getName())) || (((Long)cooldownGOLD.get(p.getName())).longValue() <= System.currentTimeMillis())){
							if (Main.HookedServer().equalsIgnoreCase("Factions")){
								facKit.sendKitGold(p);
								
					            cooldownGOLD.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(172800L)));
					            p.sendMessage(Prefix.PREFIX_SUCESS + "Você pegou o kit 'Vip Gold' com sucesso.");
							} else if (Main.HookedServer().equalsIgnoreCase("FullPvP")){
								fullKit.sendKitvipgold(p);
								
					            cooldownGOLD.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(172800L)));
					            p.sendMessage(Prefix.PREFIX_SUCESS + "Você pegou o kit 'Vip Gold' com sucesso.");
							}
						} else {
							p.sendMessage("§cVocê só pode pegar esse kit novamente em "+secToDays(TimeUnit.MILLISECONDS.toSeconds(cooldownGOLD.get(p.getName()).longValue() - System.currentTimeMillis())));
						}
					} else {
						p.sendMessage("§cVocê não tem permissão para pegar esse kit.");
					}
				} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bVIP Diamond")){
					p.closeInventory();
					if (p.hasPermission("bEssentials.kit.vipdiamond")){
						if ((!cooldownDIAMOND.containsKey(p.getName())) || (((Long)cooldownDIAMOND.get(p.getName())).longValue() <= System.currentTimeMillis())){
							if (Main.HookedServer().equalsIgnoreCase("Factions")){
								facKit.sendKitDiamond(p);
								
					            cooldownDIAMOND.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(259200L)));
					            p.sendMessage(Prefix.PREFIX_SUCESS + "Você pegou o kit 'Vip Diamond' com sucesso.");
							} else if (Main.HookedServer().equalsIgnoreCase("FullPvP")){
								fullKit.sendKitvipdiamond(p);
								
					            cooldownDIAMOND.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(259200L)));
					            p.sendMessage(Prefix.PREFIX_SUCESS + "Você pegou o kit 'Vip Diamond' com sucesso.");
							}
						} else {
							p.sendMessage("§cVocê só pode pegar esse kit novamente em "+secToDays(TimeUnit.MILLISECONDS.toSeconds(cooldownDIAMOND.get(p.getName()).longValue() - System.currentTimeMillis())));
						}
					} else {
						p.sendMessage("§cVocê não tem permissão para pegar esse kit.");
					}
				} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVIP Emerald")){
					p.closeInventory();
					if (p.hasPermission("bEssentials.kit.vipemerald")){
						if ((!cooldownEMERALD.containsKey(p.getName())) || (((Long)cooldownEMERALD.get(p.getName())).longValue() <= System.currentTimeMillis())){
							if (Main.HookedServer().equalsIgnoreCase("Factions")){
								facKit.sendKitEmerald(p);
								
								cooldownEMERALD.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(259200L)));
					            p.sendMessage(Prefix.PREFIX_SUCESS + "Você pegou o kit 'Vip Emerald' com sucesso.");
							} else if (Main.HookedServer().equalsIgnoreCase("FullPvP")){
								fullKit.sendKitvipemerald(p);
								
								cooldownEMERALD.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(259200L)));
					            p.sendMessage(Prefix.PREFIX_SUCESS + "Você pegou o kit 'Vip Emerald' com sucesso.");
							}
						} else {
							p.sendMessage("§cVocê só pode pegar esse kit novamente em "+secToDays(TimeUnit.MILLISECONDS.toSeconds(cooldownEMERALD.get(p.getName()).longValue() - System.currentTimeMillis())));
						}
					} else {
						p.sendMessage("§cVocê não tem permissão para pegar esse kit.");
					}
				} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5VIP Legendary")){
					p.closeInventory();
					if (p.hasPermission("bEssentials.kit.viplegendary")){
						if ((!cooldownLEGENDARY.containsKey(p.getName())) || (((Long)cooldownLEGENDARY.get(p.getName())).longValue() <= System.currentTimeMillis())){
							if (Main.HookedServer().equalsIgnoreCase("Factions")){
								facKit.sendKitLegendary(p);
								
								cooldownLEGENDARY.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(259200L)));
					            p.sendMessage(Prefix.PREFIX_SUCESS + "Você pegou o kit 'Vip Legendary' com sucesso.");
							} else if (Main.HookedServer().equalsIgnoreCase("FullPvP")){
								fullKit.sendKitviplegendary(p);
								
								cooldownLEGENDARY.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(259200L)));
					            p.sendMessage(Prefix.PREFIX_SUCESS + "Você pegou o kit 'Vip Legendary' com sucesso.");
							}
						} else {
							p.sendMessage("§cVocê só pode pegar esse kit novamente em "+secToDays(TimeUnit.MILLISECONDS.toSeconds(cooldownLEGENDARY.get(p.getName()).longValue() - System.currentTimeMillis())));
						}
					} else {
						p.sendMessage("§cVocê não tem permissão para pegar esse kit.");
					}
				}
			}
		}
    }
    @EventHandler
    public void onInventoryKits(InventoryClickEvent e){
    	if (e.getCurrentItem() != null && (e.getCurrentItem().getItemMeta() != null && (e.getCurrentItem().getItemMeta().getDisplayName() != null))){
    		Player p = (Player)e.getWhoClicked();
    		Inventory i = e.getInventory();
    		InventorysKit kitInventory = new InventorysKit();
    		
    		if (i.getTitle().equalsIgnoreCase("§6Kits membro disponíveis")){
    			e.setCancelled(true);
    			
    			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVoltar")){
    				kitInventory.sendKitMenu(p);
    			}
    		}if (i.getTitle().equalsIgnoreCase("§6Kits vip disponíveis")){
    			e.setCancelled(true);
    			
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVoltar")){
					kitInventory.sendKitMenu(p);
				} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Compre VIP! §7(Clique)")){
					p.closeInventory(); p.sendMessage("§6Visite: §7http://loja.tattoworld.net/");
				}
    		}
    	}
    }
    
    public static String secToDays(long time){
    	long dias = TimeUnit.SECONDS.toDays(time);
    	long horas = TimeUnit.SECONDS.toHours(time) - dias * 24L;
    	long minutos = TimeUnit.SECONDS.toMinutes(time) - TimeUnit.SECONDS.toHours(time) * 60;
        long segundos = TimeUnit.SECONDS.toSeconds(time) - TimeUnit.SECONDS.toMinutes(time) * 60L;
        
        String s = (segundos < 10L ? "0" : "") + segundos;
        String m = (minutos < 10L ? "0" : "") + minutos;
        String h = (horas < 10L ? "0" : "") + horas;
        String d = (dias < 10L ? "0" : "") + dias;
        
        String f = d+":"+h+":"+m+":"+s;
        return f;
    }
}
