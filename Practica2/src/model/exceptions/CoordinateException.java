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
	 * @param c la coordenada
	 */
	public CoordinateException() {
		super();
	}
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
