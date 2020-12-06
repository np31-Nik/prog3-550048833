package model.io;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;

public class PlayerFactory {
	private static  boolean isLong(String s) {
	try {
		long l=Long.parseLong(s);
		return true;
		
	}catch(NumberFormatException e) {
		return false;
	}
	
	}
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
