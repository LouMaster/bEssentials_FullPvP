package bEssentials;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Convert {
	
	static DecimalFormat twoDPlaces = new DecimalFormat("#,###.##");
	static DecimalFormat currencyFormat = new DecimalFormat("#0.00", DecimalFormatSymbols.getInstance(Locale.US));
	
	public static String formatLong(int value){
		currencyFormat.setRoundingMode(RoundingMode.FLOOR);
		String str = currencyFormat.format(value);
		
		return str;
	}
	
	public static String formatInt(int value){
		twoDPlaces.setRoundingMode(RoundingMode.HALF_UP);
		return twoDPlaces.format(value);
	}
}
