package MySQL.API;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import MySQL.Query;
import bEssentials.Main;

public class EntrarMySQL implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		final Player p = e.getPlayer();
		final String UUID = PlayerUtil.getUUID(p.getName());
		
		if (!isPlayerRegistred(p.getName())){
			onUpdater(p, UUID);
			updateNick(p, UUID);
		}
	}
	
	public static boolean isPlayerRegistred(String p){
		String UUID = PlayerUtil.getUUID(p.toLowerCase());
		if (Query.conectado){
			try {
				Statement st = Main.c.createStatement();
				String sql = "Select * from Money_FullPvP where UUID = '"+UUID+"'";
				ResultSet res = st.executeQuery(sql);
				if (res.next()){
					return res.getString("UUID") != null;
				}
				
				st.close();
				
				return false;
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public void onUpdater(Player p, String UUID){
		if (Query.conectado){
			try {
				Statement st = Main.c.createStatement();
				String sql = "INSERT INTO Money_FullPvP (UUID) SELECT * FROM (SELECT '"+UUID+"') AS tmp WHERE NOT EXISTS ( SELECT UUID FROM Money_FullPvP WHERE UUID = '"+UUID+"') LIMIT 1;";
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException ex){
				ex.printStackTrace();
			}
		}
	}
	
	public void updateNick(Player p, String UUID){
		if (Query.conectado){
			try{
				Statement st = Main.c.createStatement();
				String sql = "Update Money_FullPvP set Nick='"+p.getName().toString()+"' where UUID = '"+UUID+"'";
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException ex){
				ex.printStackTrace();
			}
		}
	}
}
