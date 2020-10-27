package model.exceptions;

import model.Coordinate;

/**
 * 
 * @author Nikita Polyanskiy P550048833
 *
 */
@SuppressWarnings("serial")  
public class CoordinateAlreadyHitException extends BattleshipException{

	
	public CoordinateAlreadyHitException (Coordinate c) {
		super(c);
		
	}
	public String getMessage() {
		return "Coordenada invalida (Ya ha sido golpeada)";

	}
	
	
}