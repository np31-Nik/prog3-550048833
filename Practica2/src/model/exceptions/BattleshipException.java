package model.exceptions;

import model.Coordinate;

/**
 * 
 * @author Nikita Polyanskiy P550048833
 *
 */
@SuppressWarnings("serial")  
public abstract class BattleshipException extends java.lang.Exception{
	private Coordinate c;
	
	public BattleshipException (Coordinate c) {
		c=this.c.copy();
	}
	public String getMessage() {
		return "Battleship Exception";
	}
	
	
}