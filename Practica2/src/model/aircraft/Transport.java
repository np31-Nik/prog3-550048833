package model.aircraft;

import model.Orientation;
/**
 * Clase Transport
 * @author Nikita Polyanskiy P550048833
 *
 */
public class Transport extends Aircraft {
	/**
	 * Constructor
	 * @param o orientacion
	 */
	public Transport(Orientation o) {
		super(o,'⇋',"Transport");
		shape = new int[][] {
		      { 0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 1, 1, 1, 0,	
		    	1, 0, 1, 0, 1,
		    	0, 0, 1, 0, 0},
		      { 0, 1, 0, 0, 0,
			0, 0, 1, 0, 0,	
			1, 1, 1, 1, 1,	
			0, 0, 1, 0, 0,
			0, 1, 0, 0, 0},
		      { 0, 0, 1, 0, 0,
			1, 0, 1, 0, 1,	
			0, 1, 1, 1, 0,	
			0, 0, 1, 0, 0,
			0, 0, 1, 0, 0},
		      { 0, 0, 0, 1, 0,
			0, 0, 1, 0, 0,	
			1, 1, 1, 1, 1,	
			0, 0, 1, 0, 0,
			0, 0, 0, 1, 0}}; 

			super.setShape(shape);	
	}
	
	public int getValue() {
		return 18;
	}
}
