package model.aircraft;

import model.Craft;
import model.Orientation;

/**
 * Clase Ship
 *
 */
public abstract class Aircraft extends Craft {
	/**
	 * Constructor
	 * @param o orientacion
	 * @param s simbolo
	 * @param n nombre
	 */
	public Aircraft(Orientation o, char s, String n) {
		super(o,s,n);
	}
	
}