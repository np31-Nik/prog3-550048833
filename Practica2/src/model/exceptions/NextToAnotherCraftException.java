package model.exceptions;

import model.Coordinate;

/**
 * Clase Nexttoanothercraftexception
 * @author Nikita Polyanskiy P550048833
 *
 */
@SuppressWarnings("serial")  
public class NextToAnotherCraftException extends CoordinateException{
/**
 * Constructor
 * @param c la coordenada
 */
	
	public NextToAnotherCraftException (Coordinate c) {

	}
	/**
	 * Metodo get message
	 * @return el mensaje
	 */
	public String getMessage() {
		return "Coordenada invalida (Cerca de otro barco)";
	}
	
	
}