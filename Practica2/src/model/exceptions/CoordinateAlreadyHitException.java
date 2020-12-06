package model.exceptions;

import model.Coordinate;

/**
 * Clase Coordinatealreadyhitexception
 * @author Nikita Polyanskiy P550048833
 *
 */
@SuppressWarnings("serial")  
public class CoordinateAlreadyHitException extends BattleshipException{
/**
 * constructor
 * @param c la coordenada
 */
	
	public CoordinateAlreadyHitException (Coordinate c) {
		
	}
	/**
	 * Metodo getmessage
	 * @return el mensaje
	 */
	public String getMessage() {
		return "Coordenada invalida (Ya ha sido golpeada)";

	}
	
	
}