package model;
import model.ship.Coordinate2D;
import model.aircraft.Coordinate3D;

public class CoordinateFactory {
	public static Coordinate createCoordinate(int[] coords) {
		if(coords.length<2 || coords.length>3) {
		throw new IllegalArgumentException("Cantidad de compenentes no valida");	
		}
		if(coords.length==2) {
			return new Coordinate2D(coords[0],coords[1]);
		}else{
			return new Coordinate3D(coords[0],coords[1],coords[2]);
		}
	}
}
