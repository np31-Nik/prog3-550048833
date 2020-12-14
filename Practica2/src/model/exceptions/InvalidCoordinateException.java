package model.exceptions;

import model.Coordinate;

/**
 * Clase Invalidcoordinateexception
 * @author Nikita Polyanskiy P550048833
 *
 */
@SuppressWarnings("serial")  
public class InvalidCoordinateException extends CoordinateException{
/**
 * Constructor
 * @param c la coordenada
 */
	
	public InvalidCoordinateException (Coordinate c) {

	}
	/**
	 * Metodo getmessage
	 * @return el mensaje
	 */
	public String getMessage() {
		return "Coordenada invalida";
	}
	
	
}