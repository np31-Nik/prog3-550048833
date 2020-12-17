package model.aircraft;

import model.Orientation;
/**
 * Clase Bomber
 * @author Nikita Polyanskiy P550048833
 *
 */
public class Bomber extends Aircraft {
	/**
	 * Constructor
	 * @param o orientacion
	 */
	public Bomber(Orientation o) {
		super(o,'⇶',"Bomber");
		shape = new int[][] {
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	1, 1, 1, 1, 1,	
		    	1, 0, 1, 0, 1,
		    	0, 0, 1, 0, 0},
		      { 0, 1, 1, 0, 0,
			0, 0, 1, 0, 0,	
			1, 1, 1, 1, 0,	
			0, 0, 1, 0, 0,
			0, 1, 1, 0, 0},
		      { 0, 0, 1, 0, 0,
			1, 0, 1, 0, 1,	
			1, 1, 1, 1, 1,	
			0, 0, 1, 0, 0,
			0, 0, 0, 0, 0},
		      { 0, 0, 1, 1, 0,
			0, 0, 1, 0, 0,	
			0, 1, 1, 1, 1,	
			0, 0, 1, 0, 0,
			0, 0, 1, 1, 0}}; 

			super.setShape(shape);	
	}
	/**
	 * funcion que devuelve el valor de la nave
	 * @return el valor
	 */
	public int getValue() {
		return 15;
	}
}
