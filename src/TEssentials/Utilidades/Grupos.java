package TEssentials.Utilidades;

import org.bukkit.entity.Player;

import bUtils.Packets.Tags.TagAPI;
import bUtils.Packets.Tags.Core.TagManager;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Grupos {

	@SuppressWarnings("deprecation")
	public static void grupo(Player p){
	TagManager.clear(p.getName());
	  if(PermissionsEx.getUser(p.getName()).getGroups()[0].getName() != null){
	  String grupo = PermissionsEx.getUser(p.getName()).getGroups()[0].getName();
	  
	  if (grupo.equalsIgnoreCase("VipIron")){
	   TagAPI.setPrefix(p.getName(), "§7VIP §r");
	  } else if (grupo.equalsIgnoreCase("VipGold")){
	   TagAPI.setPrefix(p.getName(), "§6VIP §r");
	  } else if (grupo.equalsIgnoreCase("VipDiamond")){
	   TagAPI.setPrefix(p.getName(), "§bVIP §r");
	  } else if (grupo.equalsIgnoreCase("VipEmerald")){
	   TagAPI.setPrefix(p.getName(), "§aVIP §r");
	  } else if (grupo.equalsIgnoreCase("VipLegendary")){
	   TagAPI.setPrefix(p.getName(), "§5VIP §r");
	  } else if (grupo.equalsIgnoreCase("YouTuber")){
	   TagAPI.setPrefix(p.getName(), "§bYT §r");
	  } else if (grupo.equalsIgnoreCase("Ajudante")){
	   TagAPI.setPrefix(p.getName(), "§eAJD §r");
	  } else if (grupo.equalsIgnoreCase("Moderador")){
	   TagAPI.setPrefix(p.getName(), "§2MOD §r");
	  } else if (grupo.equalsIgnoreCase("Admin")){
	   TagAPI.setPrefix(p.getName(), "§cADMIN §r");
	  } else if (grupo.equalsIgnoreCase("build")){
	   TagAPI.setPrefix(p.getName(), "§5BUILDER §r");
	  } else if (grupo.equalsIgnoreCase("BuildMaster")){
	   TagAPI.setPrefix(p.getName(), "§9MBUILDER §r");
	  } else if (grupo.equalsIgnoreCase("programador")){
	   TagAPI.setPrefix(p.getName(), "§3DEV §r");
	  } else if (grupo.equalsIgnoreCase("gerente")){
	   TagAPI.setPrefix(p.getName(), "§bGER §r");
	  } else if (grupo.equalsIgnoreCase("Master")){
	   TagAPI.setPrefix(p.getName(), "§4MASTER §r");
	  } else if (grupo.equalsIgnoreCase("Membro")){
	   TagAPI.setPrefix(p.getName(), "§7");
	  } else {
	   TagAPI.setPrefix(p.getName(), "§7");
	  }
	  
	  
	  TagManager.sendTeamsToPlayer(p);
	TagManager.sendTeamsToPlayer( p );
	  }else{
		  TagAPI.setPrefix(p.getName(), "§7");
	  }
	}
}
