package TEssentials.Utilidades;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import bEssentials.Prefix;
import TEssentials.Events.ConfigEvent;
import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Blocks implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBlock(BlockPlaceEvent e){
		Player p = e.getPlayer();
		Block b = e.getBlock();
		ConfigEvent config = new ConfigEvent();
		
		if (b.getType() == Material.TNT){
			if (config.hasTrue("Bloquear.TNT")){
				e.setCancelled(true);
				p.sendMessage(Prefix.PREFIX_ERROR+"Esse item está bloqueado por causar bugs/griefing!");
			}
		} else if ((b.getType() == Material.ITEM_FRAME) || (b.getType() == Material.LEATHER) || (b.getType() == Material.ENDER_PEARL)){
			if (config.hasTrue("Bloquear.ITEM_FRAME")){
				PermissionGroup[] group = PermissionsEx.getUser(p.getName()).getGroups();
				for (PermissionGroup grupos : group){
					if ((grupos.getIdentifier().equalsIgnoreCase("Admin"))|| (grupos.getIdentifier().equalsIgnoreCase("build"))|| (grupos.getIdentifier().equalsIgnoreCase("programador"))|| (grupos.getIdentifier().equalsIgnoreCase("gerente"))|| (grupos.getIdentifier().equalsIgnoreCase("master"))){
						e.setCancelled(false);
					} else {
						e.setCancelled(true);
						p.sendMessage(Prefix.PREFIX_ERROR+"Esse item está bloqueado por causar bugs/griefing!");
					}
				}
			}
		}
	}
	
	@EventHandler
	public void FrameProtect(HangingBreakByEntityEvent e){
		if (e.getRemover() instanceof Player){
			Player p = (Player) e.getRemover();
			if (e.getEntity().getType() == EntityType.ITEM_FRAME){
				if (!p.isOp() && (!p.hasPermission("bEssentials.frame.remove"))){
					e.setCancelled(true);
					p.sendMessage(Prefix.PREFIX_ERROR+"Você não pode remover item frames de shops/outras pessoas.");
				}
			}
		}
	}
	
	@EventHandler
	public void FrameProtect1(HangingPlaceEvent e){
		Player p = e.getPlayer();
		if (e.getEntity().getType() == EntityType.ITEM_FRAME){
			if (!p.isOp() && (!p.hasPermission("bEssentials.frame.remove"))){
				e.setCancelled(true);
				p.sendMessage(Prefix.PREFIX_ERROR+"Você não pode remover item frames de shops/outras pessoas.");
			}
		}
	}
	
	@EventHandler
	public void canRotate(PlayerInteractEntityEvent e){
		Entity entity = e.getRightClicked();
		Player p = e.getPlayer();
		if (!entity.getType().equals(EntityType.ITEM_FRAME)){
			return;
		}
		
		ItemFrame frame = (ItemFrame) entity;
		if (frame.getItem().equals(null) || (frame.getItem().getType().equals(Material.AIR))){
			return;
		}
		if (!p.isOp() && (!p.hasPermission("bEssentials.frame.rotation"))){
			e.setCancelled(true);
			p.sendMessage(Prefix.PREFIX_ERROR+"Você não pode reposicionar os itens dos item frame.");
		}
	}
	
	@EventHandler
	public void ItemRemove (EntityDamageByEntityEvent e){
		if (e.getDamager() instanceof Player){
			Player p = (Player) e.getDamager();
			if (e.getEntity().getType() == EntityType.ITEM_FRAME){
				if (!p.isOp() && (!p.hasPermission("bEssentials.frame.itemremove"))){
					e.setCancelled(true);
					p.sendMessage(Prefix.PREFIX_ERROR+"Você não pode remover os itens dos item frame.");
				}
			}
		}
		if (e.getDamager() instanceof Projectile){
			if (e.getEntity().getType() == EntityType.ITEM_FRAME){
				Projectile p = (Projectile) e.getDamager();
				Player player = (Player) p.getShooter();
				if (!player.hasPermission("bEssentials.frame.itemremover") && (!player.isOp())){
					e.setCancelled(true);
					player.sendMessage(Prefix.PREFIX_ERROR+"Você não pode remover os itens dos item frame.");
				}
			}
		}
	}
}