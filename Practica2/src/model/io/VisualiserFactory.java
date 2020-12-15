package model.io;

import java.lang.reflect.Constructor;

import model.Craft;
import model.Game;
import model.Orientation;
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
		IVisualiser vis;
		String dir="model.io.Visualiser"+n;
		
		try {
			Class<?> c=Class.forName(dir);
			Class<?>[] paramTypes=new Class[] {Game.class};
			Constructor<?> m = c.getConstructor(paramTypes);

			vis=(IVisualiser) m.newInstance(g);
			return vis;

			} catch (Exception e) {
				return null;
			}
		
		/*
		
		if(n=="Console") {
			return new VisualiserConsole(g);
			
		}else if (n=="GIF") {
			
			return new VisualiserGIF(g);
		}else {
			
		return null;	
		}*/
		
	}
}
