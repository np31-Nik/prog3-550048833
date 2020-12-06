package model.exceptions;

import model.Coordinate;
@SuppressWarnings("serial")  
public abstract class CoordinateException extends java.lang.Exception{
	/**
	 * Coordenada
	 */
	private Coordinate c;
	/**
	 * Constructor
	 * @param c la coordenada
	 */
	public CoordinateException (Coordinate c) {
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
