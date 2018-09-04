package bEssentials.Comandos.MoneyCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import bEssentials.AccountManager;
import bEssentials.Prefix;

public class CommandPay implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("pay")){
			if (!p.hasPermission("bEssentials.pay")){
				p.sendMessage(Prefix.PREFIX_ERROR+"§cVocê não tem permissao para usar esse comando.");
			} else {
				if (args.length < 1){
					p.sendMessage("§cUso correto: /pay <player> <quantia>");
				} else {
					AccountManager conta = new AccountManager();
					Player p2 = Bukkit.getPlayer(args[0]);
					if (p2 == null){
						p.sendMessage(Prefix.PREFIX_ERROR+"Esse player não existe.");
					} else {
						if (p2 == p){
							p.sendMessage(Prefix.PREFIX_ERROR+"Você não pode enviar dinheiro a sí mesmo.");
						} else {
							if (args[1].isEmpty()){
								p.sendMessage("§cUso correto: /pay <player> <quantia>");
							} else {
								int quantia;
								try {
									quantia = Integer.parseInt(args[1]);
								} catch (NumberFormatException e){
									sender.sendMessage(Prefix.PREFIX_ERROR+"§cé necessário colocar em números a quantia.");
									return true;
								}
								
								if (quantia < 0){
									p.sendMessage(Prefix.PREFIX_ERROR+"Você não pode enviar money negativo.");
								} else {
									if (conta.getMoney(p) >= quantia){
										conta.giveMoney(p2, quantia);
										conta.removerMoney(p, quantia);
										p.sendMessage(Prefix.PREFIX_SUCESS+"Você enviou §e$"+quantia+"§a para "+p2.getName());
										p2.sendMessage(Prefix.PREFIX_SUCESS+"Você recebeu §e$"+quantia+"§a de "+p.getName());
									} else {
										p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem a quantia que deseja pagar.");
									}	
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}
