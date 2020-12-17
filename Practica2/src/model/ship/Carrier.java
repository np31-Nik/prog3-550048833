package model.ship;

import model.Orientation;
/**
 * Clase Carrier
 * @author Nikita Polyanskiy P550048833
 *
 */
public class Carrier extends Ship {
	/**
	 * Constructor
	 * @param o orientacion
	 */
	public Carrier(Orientation o) {
		super(o,'®',"Carrier");
		shape = new int[][] {
		      { 0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0},
		      { 0, 0, 0, 0, 0,
		        0, 0, 0, 0, 0,	
			1, 1, 1, 1, 1,	
			0, 0, 0, 0, 0,
			0, 0, 0, 0, 0},
		      { 0, 0, 1, 0, 0,
			0, 0, 1, 0, 0,	
			0, 0, 1, 0, 0,	
			0, 0, 1, 0, 0,
			0, 0, 1, 0, 0},
		      { 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0,	
			1, 1, 1, 1, 1,	
			0, 0, 0, 0, 0,
			0, 0, 0, 0, 0}}; 

		super.setShape(shape);
	}
	/**
	 * funcion que devuelve el valor de la nave
	 * @return el valor
	 */
	public int getValue() {
		return 8;
	}
}
