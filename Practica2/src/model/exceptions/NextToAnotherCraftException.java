package model.exceptions;

import model.Coordinate;

/**
 * 
 * @author Nikita Polyanskiy P550048833
 *
 */
@SuppressWarnings("serial")  
public class NextToAnotherCraftException extends BattleshipException{

	
	public NextToAnotherCraftException (Coordinate c) {
		super(c);

	}
	public String getMessage() {
		return "Coordenada invalida (Cerca de otro barco)";
	}
	
	
}