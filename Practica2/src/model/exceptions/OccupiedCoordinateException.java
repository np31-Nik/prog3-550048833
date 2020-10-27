package model.exceptions;

import model.Coordinate;

/**
 * 
 * @author Nikita Polyanskiy P550048833
 *
 */
@SuppressWarnings("serial")  
public class OccupiedCoordinateException extends BattleshipException{

	
	public OccupiedCoordinateException (Coordinate c) {
		super(c);

	}
	public String getMessage() {
		return "Coordenada invalida (Ya esta ocupada)";
	}
	
	
}