package TEssentials.Utilidades;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.Inventory;

public class ChestManager {

	private static final int YAML_EXTENSION_LENGTH = ".chest.yml".length();
	private final File dataFolder;
	private final HashMap<UUID, Inventory> chests;
	
	public ChestManager(File dataFolder){
		this.dataFolder = dataFolder;
		
		this.chests = new HashMap<>();
		load();
	}
	
	private void load(){
		this.dataFolder.mkdirs();
		
		FilenameFilter filter = new FilenameFilter(){
			public boolean accept(File dir, String name){
				return name.endsWith(".chest.yml");
			}
		};
		
		for (File chestFile : this.dataFolder.listFiles(filter)){
			String chestFileName = chestFile.getName();
			
			try {
				try {
					UUID playerUUID = UUID.fromString(chestFileName.substring(0, chestFileName.length() - YAML_EXTENSION_LENGTH));
					this.chests.put(playerUUID, InventoryIO.loadFromYaml(chestFile));
				} catch (IllegalArgumentException e){
					String playerName = chestFileName.substring(0, chestFileName.length() - YAML_EXTENSION_LENGTH);
					for (OfflinePlayer player : Bukkit.getOfflinePlayers()){
						if (player.getName().toLowerCase().equals(playerName)){
							this.chests.put(player.getUniqueId(), InventoryIO.loadFromYaml(chestFile));
							chestFile.deleteOnExit();
						}
					}
				}
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void save(){
		this.dataFolder.mkdirs();
		
		Iterator<Map.Entry<UUID, Inventory>> chestIterator = this.chests.entrySet().iterator();
		while (chestIterator.hasNext()){
			Map.Entry<UUID, Inventory> entry = (Entry<UUID, Inventory>) chestIterator.next();
			UUID playerUUID = (UUID) entry.getKey();
			Inventory chest = (Inventory) entry.getValue();
			
			File chestFile = new File(this.dataFolder, playerUUID.toString()+".chest.yml");
			if (chest == null){
				chestFile.delete();
				chestIterator.remove();
			} else {
				try {
					InventoryIO.saveToYaml(chest, chestFile);
				} catch (IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public Inventory getChest(UUID playerUUID){
		Inventory chest = (Inventory) this.chests.get(playerUUID);
		if (chest == null){
			chest = Bukkit.createInventory(null, 54);
			this.chests.put(playerUUID, chest);
		}
		
		return chest;
	}
	
	public void removeChest(UUID playerUUID){
		this.chests.put(playerUUID, null);
	}
	
	public int getChestCount(){
		return this.chests.size();
	}
}
