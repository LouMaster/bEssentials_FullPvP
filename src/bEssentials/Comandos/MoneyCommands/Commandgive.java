package bEssentials.Comandos.MoneyCommands;

import org.bukkit.Bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import bEssentials.AccountManager;
import bEssentials.Prefix;

public class Commandgive implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			if (args.length < 1){
				sender.sendMessage("�cUso correto: /givemoney <player> <quantidade>");
			} else {
				Player p2 = Bukkit.getPlayer(args[0]);
				if (p2 == null){
					sender.sendMessage("�cJogador est� offline ou n�o existe.");
				} else {
					int quantia;
					try {
						quantia = Integer.parseInt(args[1]);
					} catch (NumberFormatException e){
						sender.sendMessage(Prefix.PREFIX_ERROR+"�c� necess�rio colocar em n�meros a quantia.");
						return true;
					}
					
					if (quantia < 0){
						sender.sendMessage(Prefix.PREFIX_ERROR+"Voc� n�o pode colocar money negativo.");
					} else {
						AccountManager conta = new AccountManager();
						conta.giveMoney(p2, quantia);
						sender.sendMessage("�cVoc� givou $"+quantia+" para "+p2.getName()+" com sucesso.");
					}
				}
			}
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("givemoney")){
			if (!p.hasPermission("bEssentials.money.givemoney")){
				p.sendMessage(Prefix.PREFIX_ERROR+"Voc� n�o tem permiss�o para usar esse comando.");
			} else {
				if (args.length == 0){
					p.sendMessage("�cUso correto: /givemoney <player> <quantidade>");
				} else {
					Player p2 = Bukkit.getPlayer(args[0]);
					if (p2 == null){
						sender.sendMessage("�cJogador est� offline ou n�o existe.");
					} else {
						int quantia;
						try {
							quantia = Integer.parseInt(args[1]);
						} catch (NumberFormatException e){
							p.sendMessage(Prefix.PREFIX_ERROR+"�c� necess�rio colocar em n�meros a quantia.");
							return true;
						}
						
						if (quantia < 0){
							p.sendMessage(Prefix.PREFIX_ERROR+"Voc� n�o pode colocar money negativo.");
						} else {
							AccountManager conta = new AccountManager();
							conta.giveMoney(p2, quantia);
							p.sendMessage("�cVoc� givou $"+quantia+" para "+p2.getName()+" com sucesso.");
						}
					}
				}
			}
		}
		return false;
	}

}
