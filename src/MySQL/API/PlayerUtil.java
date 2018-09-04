package MySQL.API;

import java.util.UUID;

import com.google.common.base.Charsets;

public class PlayerUtil {

	public static String getUUID(String player){
		return UUID.nameUUIDFromBytes((player.toLowerCase()).getBytes(Charsets.UTF_8)).toString();
	}
}
