package bEssentials.RankUp;

import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import MySQL.API.PrisionUtil;
import bEssentials.AccountManager;
import bEssentials.Main;
import bEssentials.Prefix;
import bEssentials.Utils;
import bEssentials.Comandos.BolaoCommand;
import bUtils.Packets.TitleManager;

public class RankUp implements Listener, CommandExecutor {
	
	static Plugin plugin;

	public RankUp(Main main) {
		plugin = main;
	}
	
	int ZiY = 5000;
	int YiX = 7000;
	int XiW = 10000;
	int WiV = 13000;
	int ViU = 16000;
	int UiT = 20000;
	int TiS = 22000;
	int SiR = 25000;
	int RiQ = 30000;
	int QiP = 50000;
	int PiO = 65000;
	int OiN = 75000;
	int NiM = 90000;
	int MiL = 100000;
	int LiK = 200000;
	int KiJ = 250000;
	int JiI = 350000;
	int IiH = 450000;
	int HiG = 500000;
	int GiF = 600000;
	int FiE = 1000000;
	int EiD = 1500000;
	int DiC = 2000000;
	int CiB = 5000000;
	int BiA = 10000000;
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("subir")) {
			if(!(sender instanceof Player)){
				System.out.println("Apenas players...");
				return true;
			}
			if(args.length == 0){
				AccountManager conta = new AccountManager();
				if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("Z")){
					if(conta.getMoney(p) < ZiY){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+ZiY);
					}else{
						conta.removerMoney(p, ZiY);
						PrisionUtil.subir(p.getUniqueId().toString(), "Y");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lY§a!");
					}
					
					return true;
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("Y")){
					if(conta.getMoney(p) < YiX){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+YiX);
					}else{
						conta.removerMoney(p, YiX);
						PrisionUtil.subir(p.getUniqueId().toString(), "X");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lX§a!");
					}
					return true;
					
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("X")){
					if(conta.getMoney(p) < XiW){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+XiW);
					}else{
						conta.removerMoney(p, XiW);
						PrisionUtil.subir(p.getUniqueId().toString(), "W");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lW§a!");
					}
					
					return true;
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("W")){
					if(conta.getMoney(p) < WiV){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+WiV);
					}else{
						conta.removerMoney(p, WiV);
						PrisionUtil.subir(p.getUniqueId().toString(), "V");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lV§a!");
					}
					
					return true;
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("V")){
					if(conta.getMoney(p) < ViU){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+ViU);
					}else{
						conta.removerMoney(p, ViU);
						PrisionUtil.subir(p.getUniqueId().toString(), "U");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lU§a!");
					}
					
					return true;
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("U")){
					if(conta.getMoney(p) < UiT){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+UiT);
					}else{
						conta.removerMoney(p, UiT);
						PrisionUtil.subir(p.getUniqueId().toString(), "T");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lT§a!");
					}
					
					return true;
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("T")){
					if(conta.getMoney(p) < TiS){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+TiS);
					}else{
						conta.removerMoney(p, TiS);
						PrisionUtil.subir(p.getUniqueId().toString(), "S");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lS§a!");
					}
					return true;
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("S")){
					if(conta.getMoney(p) < SiR){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+SiR);
					}else{
						conta.removerMoney(p, SiR);
						PrisionUtil.subir(p.getUniqueId().toString(), "R");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lR§a!");
					}
					return true;
					
					
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("R")){
					if(conta.getMoney(p) < RiQ){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+RiQ);
					}else{
						conta.removerMoney(p, RiQ);
						PrisionUtil.subir(p.getUniqueId().toString(), "Q");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lQ§a!");
					}
					return true;
					
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("Q")){
					if(conta.getMoney(p) < QiP){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+QiP);
					}else{
						conta.removerMoney(p, QiP);
						PrisionUtil.subir(p.getUniqueId().toString(), "P");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lP§a!");
					}
					return true;
					
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("P")){
					if(conta.getMoney(p) < PiO){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+PiO);
					}else{
						conta.removerMoney(p, PiO);
						PrisionUtil.subir(p.getUniqueId().toString(), "O");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lO§a!");
					}
					return true;
					
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("O")){
					if(conta.getMoney(p) < OiN){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+OiN);
					}else{
						conta.removerMoney(p, OiN);
						PrisionUtil.subir(p.getUniqueId().toString(), "N");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lN§a!");
					}
					return true;
					
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("N")){
					if(conta.getMoney(p) < NiM){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+NiM);
					}else{
						conta.removerMoney(p, NiM);
						PrisionUtil.subir(p.getUniqueId().toString(), "M");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lM§a!");
					}
					return true;
					
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("M")){
					if(conta.getMoney(p) < MiL){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+MiL);
					}else{
						conta.removerMoney(p, MiL);
						PrisionUtil.subir(p.getUniqueId().toString(), "L");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lL§a!");
					}
					return true;
					
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("L")){
					if(conta.getMoney(p) < LiK){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+LiK);
					}else{
						conta.removerMoney(p, LiK);
						PrisionUtil.subir(p.getUniqueId().toString(), "K");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lK§a!");
					}
					return true;
					
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("K")){
					if(conta.getMoney(p) < KiJ){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+KiJ);
					}else{
						conta.removerMoney(p, KiJ);
						PrisionUtil.subir(p.getUniqueId().toString(), "J");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lJ§a!");
					}
					return true;
					
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("J")){
					if(conta.getMoney(p) < JiI){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+JiI);
					}else{
						conta.removerMoney(p, JiI);
						PrisionUtil.subir(p.getUniqueId().toString(), "I");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lI§a!");
					}
					return true;
					
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("I")){
					if(conta.getMoney(p) < IiH){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+IiH);
					}else{
						conta.removerMoney(p, IiH);
						PrisionUtil.subir(p.getUniqueId().toString(), "H");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lH§a!");
					}
					return true;
					
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("H")){
					if(conta.getMoney(p) < HiG){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+HiG);
					}else{
						conta.removerMoney(p, HiG);
						PrisionUtil.subir(p.getUniqueId().toString(), "G");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lG§a!");
					}
					return true;
					
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("G")){
					if(conta.getMoney(p) < GiF){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+GiF);
					}else{
						conta.removerMoney(p, GiF);
						PrisionUtil.subir(p.getUniqueId().toString(), "F");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lF§a!");
					}
					return true;
					
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("F")){
					if(conta.getMoney(p) < FiE){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+FiE);
					}else{
						conta.removerMoney(p, FiE);
						PrisionUtil.subir(p.getUniqueId().toString(), "E");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lE§a!");
					}
					return true;
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("E")){
					if(conta.getMoney(p) < EiD){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+EiD);
					}else{
						conta.removerMoney(p, EiD);
						PrisionUtil.subir(p.getUniqueId().toString(), "D");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lD§a!");
					}
					return true;
					
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("D")){
					if(conta.getMoney(p) < DiC){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+DiC);
					}else{
						conta.removerMoney(p, DiC);
						PrisionUtil.subir(p.getUniqueId().toString(), "C");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lC§a!");
					}
					return true;
				
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("C")){
					if(conta.getMoney(p) < CiB){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+CiB);
					}else{
						conta.removerMoney(p, CiB);
						PrisionUtil.subir(p.getUniqueId().toString(), "B");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lB§a!");
					}
					return true;
					
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("B")){
					if(conta.getMoney(p) < BiA){
						p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro para subir. Você prescisa de $"+BiA);
					}else{
						conta.removerMoney(p, BiA);
						PrisionUtil.subir(p.getUniqueId().toString(), "A");
						p.sendMessage(Prefix.PREFIX_SUCESS+"Você subiu de nivel para o §6§lA§a!");
					}
					return true;
					
					
				}else if(PrisionUtil.getClan(p.getUniqueId().toString()).equalsIgnoreCase("A")){
					p.sendMessage(Prefix.PREFIX_ERROR+"Você chegou ao nivel máximo.");
					return true;
				}
			}else{
				p.sendMessage(Prefix.PREFIX_ERROR+"/subir");
			}
		}else if (cmd.getName().equalsIgnoreCase("spawnarMN")) {
			Villager villager = (Villager)p.getWorld().spawnCreature(p.getLocation(), EntityType.VILLAGER);
			villager.setProfession(Villager.Profession.PRIEST);
			villager.setCanPickupItems(false);
			villager.setAdult();
			villager.setCustomName("§6Corrupto");
			villager.setCustomNameVisible(true);
			villager.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 180067, 6776767));
			
		}
		return false;
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
	if(e.getEntityType() == EntityType.VILLAGER) {
		if(e.getEntity().getCustomName().equalsIgnoreCase("§6Corrupto")){
	       e.setCancelled(true);
		}	 
	}
	}
	
	@EventHandler
	public void testeMacro(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		Entity r = e.getRightClicked();
		if(r.getType() == EntityType.VILLAGER) {
			if(r.getCustomName().equalsIgnoreCase("§6Corrupto")){
				e.setCancelled(true);
				sendMercadoNegro(p);
			}	 
		}
	}
	
	public static void sendMercadoNegro(Player p){
		Inventory inv = Bukkit.createInventory(p, 27, "§6Mercado Negro");

		Utils.setItem(inv, 11, Material.CHEST, "§aSuborno", Arrays.asList("§7Você tem §e"+PrisionUtil.getSuborno(p.getName(), "S")+"§7 Suborno!"));
		Utils.setItem(inv, 15, Material.ENDER_CHEST, "§aSuper Suborno", Arrays.asList(
		        "§8loja.tattoworld.net", " ", "§7Você tem §e"+PrisionUtil.getSuborno(p.getName(), "SS")+"§7 Super Suborno!", "§7Adquira mais §6Super Suborno§7 em nossa loja!", 
		        " ", "§6Loja: §7loja.tattoworld.net"));
		
        p.openInventory(inv);
	}
	public static void sendConfirmacao(Player p){
		Inventory inv = Bukkit.createInventory(p, 27, "§6Confirme sua corrupção!");
		
		Utils.setItem(inv, 11, 13, Material.STAINED_CLAY, "§aConfirmar", 1, Arrays.asList("§7Quero ser um corrupto."));
		Utils.setItem(inv, 15, 14, Material.STAINED_CLAY, "§cNão confirmar", 1, Arrays.asList("§7Quero ser honesto."));
		
        p.openInventory(inv);
	}
	
	public static void sendConfirmacao2(Player p){
		Inventory inv = Bukkit.createInventory(p, 27, "§6Confirme sua corrupção");
		
		Utils.setItem(inv, 11, 13, Material.STAINED_CLAY, "§aConfirmar", 1, Arrays.asList("§7Quero ser um corrupto."));
		Utils.setItem(inv, 15, 14, Material.STAINED_CLAY, "§cNão confirmar", 1, Arrays.asList("§7Quero ser honesto."));
		
        p.openInventory(inv);
	}
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e){
		if (e.getCurrentItem() != null && (e.getCurrentItem().getItemMeta() != null) && (e.getCurrentItem().getItemMeta().getDisplayName() != null)){
			final Player p = (Player)e.getWhoClicked();
			Inventory i = e.getInventory();
			
			if (i.getTitle().equalsIgnoreCase("§6Mercado Negro")){
				e.setCancelled(true);
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSuborno")){
					if(Integer.parseInt(PrisionUtil.getSuborno(p.getName(), "S")) > 0){
					sendConfirmacao(p);
					}else{
						p.closeInventory();
						p.sendMessage("§cVocê não tem suborno suficiente.");
					}
				}else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSuper Suborno")){
					if(Integer.parseInt(PrisionUtil.getSuborno(p.getName(), "SS")) > 0){
					sendConfirmacao2(p);
				}else{
					p.closeInventory();
					p.sendMessage("§cVocê não tem suborno suficiente.");
				}
				}
			}else if (i.getTitle().equalsIgnoreCase("§6Confirme sua corrupção")){
				e.setCancelled(true);
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aConfirmar")){
					p.closeInventory();
					if (!BolaoCommand.BOLAO_INICIANDO){
						PrisionUtil.removeSuborno(p.getName(), "SS");
						TitleManager title = new TitleManager();
						title.sendActionBar(p, "§aO Corrupto está escolhendo...");
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,
								new Runnable() {
									public void run() {
										TitleManager title = new TitleManager();
										title.sendActionBar(p, "§aVocê ganhou um ");
									}
								}, 100L);
					}else{
						p.sendMessage("§cVocê não pode comprar com o BOLÃO em andamento.");
					}
				}else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNão confirmar")){
					p.closeInventory();
					p.sendMessage(Prefix.PREFIX_ERROR+"Você escolheu o caminho certo.");
				}
				
				
			}else if (i.getTitle().equalsIgnoreCase("§6Confirme sua corrupção!")){
				e.setCancelled(true);
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aConfirmar")){
					p.closeInventory();
					if (!BolaoCommand.BOLAO_INICIANDO){
						PrisionUtil.removeSuborno(p.getName(), "S");
						TitleManager title = new TitleManager();
						title.sendActionBar(p, "§aO Corrupto está escolhendo...");
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,
								new Runnable() {
									public void run() {
										TitleManager title = new TitleManager();
										int r = random(1, 2);
										if(r == 1){
										title.sendActionBar(p, "§aVocê ganhou um §6§lPão§a!");
										p.sendMessage("§aVocê ganhou um §6§lPão§a!");
										p.getInventory().addItem(new ItemStack(Material.BREAD));
										}else if(r == 2){
											title.sendActionBar(p, "§aVocê ganhou um §6§l10 de EXP§a!");
											p.sendMessage("§aVocê ganhou §6§l90 de EXP§a!");
											p.giveExp(90);
										}
									}
								}, 100L);
					}else{
						p.sendMessage("§cVocê não pode comprar com o BOLÃO em andamento.");
					}
				}else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNão confirmar")){
					p.closeInventory();
					p.sendMessage(Prefix.PREFIX_ERROR+"Você escolheu o caminho certo.");
				}
			}
		}
	}
	int random(int min, int max){
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}

}
