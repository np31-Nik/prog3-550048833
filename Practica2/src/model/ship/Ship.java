package model.ship;

import model.Craft;
import model.Orientation;

/**
 * Clase Ship
 *
 */
public abstract class Ship extends Craft {
	/**
	 * Constructor
	 * @param o orientacion
	 * @param s simbolo
	 * @param n nombre
	 */
	public Ship(Orientation o, char s, String n) {
		super(o,s,n);
	}
	
}