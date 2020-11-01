package model.exceptions;

import model.Coordinate;

/**
 * Clase Invalidcoordinateexception
 * @author Nikita Polyanskiy P550048833
 *
 */
@SuppressWarnings("serial")  
public class InvalidCoordinateException extends BattleshipException{
/**
 * Constructor
 * @param c la coordenada
 */
	
	public InvalidCoordinateException (Coordinate c) {
		super(c);

	}
	/**
	 * Metodo getmessage
	 * @return el mensaje
	 */
	public String getMessage() {
		return "Coordenada invalida";
	}
	
	
}