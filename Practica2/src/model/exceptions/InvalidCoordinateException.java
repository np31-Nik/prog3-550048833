package model.exceptions;

import model.Coordinate;

/**
 * 
 * @author Nikita Polyanskiy P550048833
 *
 */
@SuppressWarnings("serial")  
public class InvalidCoordinateException extends BattleshipException{

	
	public InvalidCoordinateException (Coordinate c) {
		super(c);

	}
	public String getMessage() {
		return "Coordenada invalida";
	}
	
	
}