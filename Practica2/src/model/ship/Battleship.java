package model.ship;

import model.Orientation;
/**
 * Clase Battleship
 * @author Nikita Polyanskiy P550048833
 *
 */
public class Battleship extends Ship {
	/**
	 * Constructor
	 * @param o orientacion
	 */
	public Battleship(Orientation o) {
		super(o,'O',"Battleship");
		shape = new int[][] {
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0},
		      { 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0,	
			0, 1, 1, 1, 1,	
			0, 0, 0, 0, 0,
			0, 0, 0, 0, 0},
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0},
		      { 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0,	
			0, 1, 1, 1, 1,	
			0, 0, 0, 0, 0,
			0, 0, 0, 0, 0}}; 

		super.setShape(shape);
	}
	/**
	 * funcion que devuelve el valor de la nave
	 * @return el valor
	 */
	public int getValue() {
		return 6;
	}
}
