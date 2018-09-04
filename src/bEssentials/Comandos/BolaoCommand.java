package bEssentials.Comandos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import bEssentials.AccountManager;
import bEssentials.Main;
import bEssentials.Prefix;
import bUtils.Packets.TitleManager;
import bUtils.Packets.Tags.TagAPI;

public class BolaoCommand implements CommandExecutor {

	public static boolean BOLAO_INICIANDO = false;
	public static int BOLAO_VALOR_TOTAL = 0;
	public static int BOLAO_VALOR_APOSTAR = 0;
	public static List<String> pessoas = new ArrayList<>();
	
	public int mensage;
	public int inicio1;
	public int inicio2;
	public int inicio3;
	public int inicio4;
	public int sorteio;
	public int sorteio1;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("bolao")){
			if (args.length == 0){
				if (!p.hasPermission("bEssentials.bolao")){
					p.sendMessage("§cUso correto: /bolao entrar");
				} else {
					p.sendMessage("§cUso correto: /bolao entrar");
					p.sendMessage("§cUso correto: /bolao iniciar <quantia>");
					p.sendMessage("§cUso correto: /bolao cancelar");
				}
			} else {
				if (args[0].equalsIgnoreCase("entrar")){
					if (!BOLAO_INICIANDO){
						p.sendMessage("§cNão existe um bolão iniciando.");
					} else {
						AccountManager conta = new AccountManager();
						int quantia = BOLAO_VALOR_APOSTAR;
						if (conta.getMoney(p) >= quantia){
							if (!pessoas.contains(p.getName())){
								p.sendMessage(Prefix.PREFIX_SUCESS+"Você entrou no bolão! Boa sorte.");
								pessoas.add(p.getName());
								BOLAO_VALOR_TOTAL += BOLAO_VALOR_APOSTAR;
							} else {
								p.sendMessage(Prefix.PREFIX_ERROR+"Você já está participando do bolão.");
							}
						} else {
							p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem dinheiro suficiente para entrar no bolão.");
						}
					}
				} else if (args[0].equalsIgnoreCase("iniciar")){
					if (p.hasPermission("bEssentials.bolao")){
						if (BOLAO_INICIANDO){
							p.sendMessage(Prefix.PREFIX_ERROR+"Já existe um bolão iniciado.");
						} else {
							pessoas.clear();
							
							try {
								BOLAO_VALOR_APOSTAR = Integer.parseInt(args[1]);
							} catch (NumberFormatException e){
								p.sendMessage("§cé necessário colocar apenas número na quantia."); return true;
							}
							
							BOLAO_INICIANDO = true;
							p.sendMessage(Prefix.PREFIX_SUCESS+"Você iniciou o bolão na quantia de $"+BOLAO_VALOR_APOSTAR);
							
							Bukkit.broadcastMessage("§aFoi iniciado um bolão, para entrar digite: §6/bolao entrar");
							Bukkit.broadcastMessage("§aCusto necessário para entrar: §e$"+BOLAO_VALOR_APOSTAR);

							mensage = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
								public void run() {
									if (BOLAO_INICIANDO){
										for (Player all : Bukkit.getOnlinePlayers()){
											TitleManager title = new TitleManager();
											title.sendActionBar(all, "§aValor: §e$"+BOLAO_VALOR_APOSTAR+" §f| §6Pessoas: §f"+pessoas.size()+" §f| §aAcumulado: §e$"+BOLAO_VALOR_TOTAL);
										}
									}
								}
							}, 0L, 20L);
							
							inicio1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
								public void run() {
									Bukkit.broadcastMessage("§aFoi iniciado um bolão, para entrar digite: §6/bolao entrar");
									Bukkit.broadcastMessage("§aCusto necessário para entrar: §e$"+BOLAO_VALOR_APOSTAR);

								}
							}, 400L);
							
							inicio2 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
								public void run() {
									Bukkit.broadcastMessage("§aFoi iniciado um bolão, para entrar digite: §6/bolao entrar");
									Bukkit.broadcastMessage("§aCusto necessário para entrar: §e$"+BOLAO_VALOR_APOSTAR);
									
								}
							}, 800L);
							
							inicio3 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
								public void run() {
									Bukkit.broadcastMessage("§aFoi iniciado um bolão, para entrar digite: §6/bolao entrar");
									Bukkit.broadcastMessage("§aCusto necessário para entrar: §e$"+BOLAO_VALOR_APOSTAR);
								}
							}, 1200L);
							
							sorteio = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
								public void run() {
									BOLAO_INICIANDO = false;
									Bukkit.broadcastMessage("§aBolão encerrado! Calculando os resultados...");
								}
							}, 1600L);
							
							sorteio1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
								public void run() {
									BOLAO_INICIANDO = false;
									
									Player ganhador = Bukkit.getPlayer((String)pessoas.get(new Random().nextInt(pessoas.size())));
									
									Bukkit.broadcastMessage("§aOpa! temos um vencedor, e o nome dele é: "+TagAPI.getNametag(ganhador.getName()));
									Bukkit.broadcastMessage("§aQuantia paga ao vencedor: §e$"+BOLAO_VALOR_TOTAL+"§a, Parabéns!");
									
									for (String s : pessoas){
										Player pessoas = Bukkit.getPlayer(s);
										if (pessoas != ganhador){
											AccountManager conta = new AccountManager();
											conta.removerMoney(pessoas, BOLAO_VALOR_APOSTAR);
										}
									}
									AccountManager conta = new AccountManager();
									conta.giveMoney(ganhador, BOLAO_VALOR_TOTAL);
									BOLAO_VALOR_TOTAL = 0;
									BOLAO_VALOR_APOSTAR = 0;
									
									Bukkit.getScheduler().cancelTask(inicio1); Bukkit.getScheduler().cancelTask(inicio2); Bukkit.getScheduler().cancelTask(inicio3);
									Bukkit.getScheduler().cancelTask(inicio4); Bukkit.getScheduler().cancelTask(mensage); Bukkit.getScheduler().cancelTask(sorteio);
									Bukkit.getScheduler().cancelTask(sorteio1);
									pessoas.clear();
								}
							}, 1800L);
						}
					}
				} else if (args[0].equalsIgnoreCase("cancelar")){
					if (p.hasPermission("bEssentials.bolao")){
						if (!BOLAO_INICIANDO){
							p.sendMessage("§cNão existe um bolão iniciando.");
						} else {
							BOLAO_INICIANDO = false;
							BOLAO_VALOR_APOSTAR = 0;
							BOLAO_VALOR_TOTAL = 0;
							pessoas.clear();
							
							Bukkit.getScheduler().cancelTask(inicio1); Bukkit.getScheduler().cancelTask(inicio2); Bukkit.getScheduler().cancelTask(inicio3);
							Bukkit.getScheduler().cancelTask(inicio4); Bukkit.getScheduler().cancelTask(mensage); Bukkit.getScheduler().cancelTask(sorteio);
							Bukkit.getScheduler().cancelTask(sorteio1);
							
							p.sendMessage(Prefix.PREFIX_SUCESS+"Você cancelou o bolão.");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(Prefix.PREFIX_ERROR+"Bolão foi cancelado.");
							Bukkit.broadcastMessage(" ");
						}
					}
				}
			}
		}
		return false;
	}

}
