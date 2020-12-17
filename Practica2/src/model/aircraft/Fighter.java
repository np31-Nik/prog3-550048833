package model.aircraft;

import model.Orientation;
/**
 * Clase Fighter
 * @author Nikita Polyanskiy P550048833
 *
 */
public class Fighter extends Aircraft {
	/**
	 * Constructor
	 * @param o orientacion
	 */
	public Fighter(Orientation o) {
		super(o,'⇄',"Fighter");
		shape = new int[][] {
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 1, 1, 1, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0},
		      { 0, 0, 0, 0, 0,
			0, 0, 1, 0, 0,	
			1, 1, 1, 1, 0,	
			0, 0, 1, 0, 0,
			0, 0, 0, 0, 0},
		      { 0, 0, 1, 0, 0,
			0, 0, 1, 0, 0,	
			0, 1, 1, 1, 0,	
			0, 0, 1, 0, 0,
			0, 0, 0, 0, 0},
		      { 0, 0, 0, 0, 0,
			0, 0, 1, 0, 0,	
			0, 1, 1, 1, 1,	
			0, 0, 1, 0, 0,
			0, 0, 0, 0, 0}}; 

			super.setShape(shape);	
	}
	/**
	 * funcion que devuelve el valor de la nave
	 * @return el valor
	 */
	public int getValue() {
		return 10;
	}
}
