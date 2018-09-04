package bEssentials;

import org.bukkit.entity.Player;

import MySQL.API.MoneyAPI;

public class AccountManager {
	
	public AccountManager(){}
	
	public void setMoney(Player p, int moneyNovo){
		MoneyAPI.setMoneyPlayer(p, moneyNovo);
	}
	
	public void sendMessageMoney(Player p){
		p.sendMessage(Prefix.PREFIX_SUCESS+"Dinheiro: §f$"+getMoney(p));
	}
	
	public void sendMessageMoney(Player comando, Player outro){
		comando.sendMessage(Prefix.PREFIX_SUCESS+"Dinheiro de "+outro.getName()+": §f$"+getMoney(outro));
	}
	
	public void giveMoney(Player p, int d){
		MoneyAPI.addMoneyPlayer(p, d);
	}
	
	public void removerMoney(Player p, int d){
		if (0 >= getMoney(p)){
			return;
		}
		
		MoneyAPI.removeMoneyPlayer(p, d);
	}
	
	public int getMoney(Player p){
		return MoneyAPI.getMoneyPlayer(p);
	}
}
