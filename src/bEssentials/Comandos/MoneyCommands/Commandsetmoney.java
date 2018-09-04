package bEssentials.Comandos.MoneyCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import bEssentials.AccountManager;
import bEssentials.Prefix;

public class Commandsetmoney implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("setmoney")){
			if (!p.hasPermission("bEssentials.admin.setmoney")){
				p.sendMessage(Prefix.PREFIX_ERROR+"Você não tem permissão para usar esse comando.");
			} else {
				if (args.length < 1){
					p.sendMessage("§cUso correto: /setmoney <player> <money>");
				} else {
					Player p2 = Bukkit.getPlayer(args[0]);
					if (p2 == null){
						p.sendMessage(Prefix.PREFIX_ERROR+"Esse jogador não existe ou está offline.");
					} else {
						if (args[1].isEmpty()){
							p.sendMessage("§cUso correto: /setmoney <player> <money>");
						} else {
							int moneyNovo;
							
							try {
								moneyNovo = Integer.parseInt(args[1]);
							} catch (NumberFormatException e){
								p.sendMessage(Prefix.PREFIX_ERROR+"§cColoque apenas números para setar o money.");
								return true;
							}
							
							if (moneyNovo < 0){
								p.sendMessage(Prefix.PREFIX_ERROR+"Você não pode colocar money negativo.");
							} else {
								AccountManager conta = new AccountManager();
								conta.setMoney(p2, moneyNovo);
								p.sendMessage(Prefix.PREFIX_SUCESS+"Você setou o money do "+p2.getName()+" para §e$"+moneyNovo);
							}
						}
					}
				}
			}
		}
		return false;
	}
}
