package MySQL.API;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.entity.Player;

import MySQL.Query;
import bEssentials.Convert;
import bEssentials.Main;

public class MoneyAPI {

	public static String[] getMoneyTop(){
		String[] array = new String[10];	
		try {
			Statement st = Main.c.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM Money_FullPvP ORDER BY CONVERT(Money, UNSIGNED INTEGER) DESC LIMIT 10;");
			int counter = 0;
			while (res.next()){
				array[counter] = "§2"+res.getString("Nick")+": §e$"+Convert.formatInt(res.getInt("Money"));
				counter++;
				
				if (counter == 10){
					break;
				}
			}
			st.close();
			res.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return array;
	}
	
	public static int getMoneyPlayer(Player p){
		int money = 0;
		String UUID = PlayerUtil.getUUID(p.getName());
		if (Query.conectado){
			try {
				Statement st = Main.c.createStatement();
				String sql = "Select * from Money_FullPvP where UUID = '"+UUID+"'";
				ResultSet res = st.executeQuery(sql);
				while (res.next()){
					money = res.getInt("Money");
					break;
				}
				st.close();
				res.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return money;
	}
	
	public static void setMoneyPlayer(Player p, int moneyNovo){
		String UUID = PlayerUtil.getUUID(p.getName());
		if (Query.conectado){
			try {
				Statement st = Main.c.createStatement();
				String sql = "UPDATE Money_FullPvP SET Money = '"+moneyNovo+"' where UUID = '"+UUID+"'";
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void removeMoneyPlayer(Player p, int removerMoney){
		String UUID = PlayerUtil.getUUID(p.getName());
		if (Query.conectado){
			try {
				Statement st = Main.c.createStatement();
				String sql = "UPDATE Money_FullPvP SET Money = Money - '"+removerMoney+"' where UUID = '"+UUID+"'";
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void addMoneyPlayer(Player p, int adicionarMoney){
		String UUID = PlayerUtil.getUUID(p.getName());
		if (Query.conectado){
			try {
				Statement st = Main.c.createStatement();
				String sql = "UPDATE Money_FullPvP SET Money = Money + '"+adicionarMoney+"' where UUID = '"+UUID+"'";
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e){
				e.printStackTrace();
			} 
		}
	}
}
