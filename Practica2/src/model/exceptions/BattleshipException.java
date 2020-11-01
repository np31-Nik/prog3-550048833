package model.exceptions;

import model.Coordinate;

/**
 * Clase Battleship Exception
 * @author Nikita Polyanskiy P550048833
 *
 */
@SuppressWarnings("serial")  
public abstract class BattleshipException extends java.lang.Exception{
	/**
	 * Coordenada
	 */
	private Coordinate c;
	/**
	 * Constructor
	 * @param c la coordenada
	 */
	public BattleshipException (Coordinate c) {
		super("Error");
	}
	/**
	 * Metodo get message
	 * @return mensaje
	 */
	public String getMessage() {
		return "Battleship Exception";
	}
	
	
}