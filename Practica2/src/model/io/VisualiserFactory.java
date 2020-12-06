package model.io;

import model.Game;
/**
 * Clase visualiserfactory
 * @author Nikita Polyanskiy P550048833
 *
 */
public class VisualiserFactory {
/**
 * Metodo createvisualiser
 * @param n tipo
 * @param g game
 * @return el IVisualiser
 */
	public static IVisualiser createVisualiser(String n, Game g) {
		if(n=="Console") {
			return new VisualiserConsole(g);
			
		}else if (n=="GIF") {
			
			return new VisualiserGIF(g);
		}else {
			
		return null;	
		}
		
	}
}
