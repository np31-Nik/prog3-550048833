package model;

import model.ship.Carrier;
import model.ship.Battleship;
import model.ship.Cruiser;
import model.ship.Destroyer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import model.aircraft.Bomber;
import model.aircraft.Fighter;
import model.aircraft.Transport;
/**
 * Clase CraftFactory
 * @author Nikita Polyanskiy P550048833
 *
 */

public class CraftFactory{
/**
 * Metodo createCraft
 * @param type tipo
 * @param orientation orientacion
 * @return el craft
 */
	public static Craft createCraft(String type, Orientation orientation) {
		Craft craft;
		String dir="model."+type;
		
		try {
			Class<?> c=Class.forName(dir);
			Class<?>[] paramTypes=new Class[] {Orientation.class};
			Constructor<?> m = c.getConstructor(paramTypes);

			craft=(Craft) m.newInstance(orientation);
			return craft;

			} catch (Exception e) {
				return null;
			}
		/*
		switch(type) {
		case "Carrier":
			craft=new Carrier(orientation);
			break;
		case "Cruiser":
			craft=new Cruiser(orientation);
			break;
		case "Destroyer":
			craft=new Destroyer(orientation);
			break;
		case "Battleship":
			craft=new Battleship(orientation);
			break;
		case "Bomber":
			craft=new Bomber(orientation);
			break;
		case "Fighter":
			craft=new Fighter(orientation);
			break;
		case "Transport":
			craft=new Transport(orientation);
			break;
		default:
			craft=null;
				break;
		}*/
	}
}
