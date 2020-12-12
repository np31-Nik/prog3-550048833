package model.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;

import model.exceptions.io.BattleshipIOException;
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
	 * @throws BattleshipIOException filenotfound
	 */
	public static IPlayer createPlayer(String name, String s) throws BattleshipIOException {
		try {
			if((s.indexOf('.'))!=-1 || (s.indexOf('\\'))!=-1 || (s.indexOf('/'))!=-1) {
				FileReader inputString;
				
				inputString = new FileReader(s);
				
				BufferedReader reader = new BufferedReader(inputString);
				return new PlayerFile(name,reader);
				
				
			}else if(isLong(s)) {
				return new PlayerRandom(name,Long.parseLong(s));
			}else {
				return null;
			}
		} catch (FileNotFoundException e) {
			throw new BattleshipIOException(e.getMessage());
		}
		
	}
}
