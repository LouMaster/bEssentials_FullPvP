package MySQL.API;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import MySQL.Query;
import bEssentials.Main;

public class PrisionUtil implements Listener{
	
	static Plugin plugin;

	public PrisionUtil(Main main) {
		plugin = main;
	}
	
	public static String getClan(String UUID){
		return plugin.getConfig().getString("RankPlayer."+UUID);
	}
	
	
	
	public static void subir(String UUID, String Letra){
			plugin.getConfig().set("RankPlayer."+UUID, Letra);
			plugin.saveConfig();
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		final Player p = e.getPlayer();
		if (!isPlayerRegistred(p.getUniqueId().toString())){
			subir(p.getUniqueId().toString(), "Z");
		}
	}
	
	public static boolean isPlayerRegistred(String p){
		try{
			if(getClan(p) == null){
				return false;
			}else if(getClan(p) != null){
			return true;
			}
		}catch(Exception e){
			return false;
		}
		return false;
	}
	
	public static String getSuborno(String UUID, String TYPE){
		if (Query.conectado){
			try {
				Statement st = Main.c.createStatement();
				String sql = "SELECT * from Money_FullPvP where Nick = '"+UUID+"'";
				ResultSet res = st.executeQuery(sql);
				if(!res.next())
					return null;
				return res.getString(TYPE);
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static String removeSuborno(String UUID, String TYPE){
		if (Query.conectado){
			try {
				Statement st = Main.c.createStatement();
				String sql = "UPDATE `Money_FullPvP` SET `"+TYPE+"`=`"+TYPE+"`-1 WHERE Nick = '"+UUID+"'";
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return null;
	}

}
