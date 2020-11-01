package model.exceptions;

import model.Coordinate;

/**
 * Clase Occupiedcoordinateexception
 * @author Nikita Polyanskiy P550048833
 *
 */
@SuppressWarnings("serial")  
public class OccupiedCoordinateException extends BattleshipException{

	/**
	 * Constructor
	 * @param c la coordenada
	 */
	public OccupiedCoordinateException (Coordinate c) {
		super(c);

	}
	/**
	 * Metodo get message
	 * @return el mensaje
	 */
	public String getMessage() {
		return "Coordenada invalida (Ya esta ocupada)";
	}
	
	
}