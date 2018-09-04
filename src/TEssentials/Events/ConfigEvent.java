package TEssentials.Events;

import bEssentials.Main;

public class ConfigEvent {

	public ConfigEvent(){}
	
	public boolean hasTrue(String path){
		if (Main.plugin.getConfig().getBoolean(path)){
			return true;
		}
		
		return false;
	}
}
