package model.exceptions;

import model.Coordinate;
/**
 * Supresswarnings
 */
@SuppressWarnings("serial")  
/**
 * Excepcion coordinate
 * @author Nikita Polyanskiy P550048833
 */
public abstract class CoordinateException extends BattleshipException{
	/**
	 * Coordenada
	 */
	private Coordinate c;
	/**
	 * Constructor
	 * 
	 */
	public CoordinateException() {
		super();
	}
	/**
	 * Excepcion de coordinate
	 * @param c la coordenada
	 */
	public CoordinateException (Coordinate c) {
		super();
	}
	/**
	 * Metodo get message
	 * @return mensaje
	 */
	public String getMessage() {
		return "Battleship Exception";
	}
	
	
}
