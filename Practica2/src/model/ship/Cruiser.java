package model.ship;

import model.Orientation;
/**
 * Clase Cruiser
 * @author Nikita Polyanskiy P550048833
 *
 */
public class Cruiser extends Ship{
	/**
	 * Constructor
	 * @param o orientacion
	 */
	public Cruiser(Orientation o) {
		super(o,'Ø',"Cruiser");
		shape = new int[][] {
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 0, 0, 0},
		      { 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0,	
			0, 1, 1, 1, 0,	
			0, 0, 0, 0, 0,
			0, 0, 0, 0, 0},
		      { 0, 0, 0, 0, 0,
			0, 0, 1, 0, 0,	
			0, 0, 1, 0, 0,	
			0, 0, 1, 0, 0,
			0, 0, 0, 0, 0},
		      { 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0,	
			0, 1, 1, 1, 0,	
			0, 0, 0, 0, 0,
			0, 0, 0, 0, 0}}; 

		super.setShape(shape);
	}
	/**
	 * funcion que devuelve el valor de la nave
	 * @return el valor
	 */
	public int getValue() {
		return 5;
	}
}
