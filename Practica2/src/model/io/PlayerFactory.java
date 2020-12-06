package model.io;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
/**
 * Clase PlayerFactory
 * @author Nikita Polyanskiy P550048833
 *
 */
public class PlayerFactory {
	/**
	 * Metodo islong
	 * @param s el string
	 * @return v o f
	 */
	private static  boolean isLong(String s) {
	try {
		long l=Long.parseLong(s);
		return true;
		
	}catch(NumberFormatException e) {
		return false;
	}
	
	}
	
	/**
	 * Metodo createplayer
	 * @param name el nombre
	 * @param s el string
	 * @return el player
	 */
	public static IPlayer createPlayer(String name, String s) {
		if((s.indexOf('.'))!=-1 || (s.indexOf('\\'))!=-1 || (s.indexOf('/'))!=-1) {
			Reader inputString = new StringReader(s);
			BufferedReader reader = new BufferedReader(inputString);
			return new PlayerFile(name,reader);
			
			
		}else if(isLong(s)) {
			return new PlayerRandom(name,Long.parseLong(s));
		}else {
			return null;
		}
		
	}
}
