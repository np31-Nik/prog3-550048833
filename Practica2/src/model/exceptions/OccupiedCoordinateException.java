package model.exceptions;

import model.Coordinate;

/**
 * Clase Occupiedcoordinateexception
 * @author Nikita Polyanskiy P550048833
 *
 */
@SuppressWarnings("serial")  
public class OccupiedCoordinateException extends CoordinateException{

	/**
	 * Constructor
	 * @param c la coordenada
	 */
	public OccupiedCoordinateException (Coordinate c) {

	}
	/**
	 * Metodo get message
	 * @return el mensaje
	 */
	public String getMessage() {
		return "Coordenada invalida (Ya esta ocupada)";
	}
	
	
}