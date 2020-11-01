package model.aircraft;

import java.util.HashSet;
import java.util.Set;

import model.Coordinate;
import model.CoordinateFactory;
/**
 * Clase Coordinate 3D
 * @author Nikita Polyanskiy P550048833
 *
 */
public class Coordinate3D extends model.Coordinate {
	/**
	 * Constructor Coordinate3D
	 * @param x la x
	 * @param y la y
	 * @param z la z
	 */
	public Coordinate3D(int x, int y,int z) {
		super(x,y,z);
	}
	/**
	 * Constructor Coordinate3D
	 * @param c la coordenada
	 */
	public Coordinate3D(Coordinate3D c) {
		super(c);
	}
	/**
	 * Metodo adjacentCoordinates
	 * @return el conjunto
	 */
	public Set<Coordinate> adjacentCoordinates() {
		Set<Coordinate> conjunto_coordinate = new HashSet<Coordinate>();
		for(int az=-1;az<=1;az++) {
			for(int ax=-1;ax<=1;ax++) {
				for(int ay=-1;ay<=1;ay++) {
					if(!(ay==0 && ax==0 && az==0)) {
						int[] coords = {ax,ay,az};
						conjunto_coordinate.add(this.subtract(CoordinateFactory.createCoordinate(coords)));
					}
				}
			}
		}
		
		return conjunto_coordinate;
		
	}
	/**
	 * Metodo copia
	 * @return la coordenada nueva
	 */
	public Coordinate3D copy() {
		Coordinate3D c=new Coordinate3D(this);
		return c;
	}
	/**
	 * Metodo tostring
	 * @return las dimensiones
	 */
	public String toString() {
		String concatenation="";
		   concatenation += "(";
		   for (int i = 0;i < super.getDim();i++)
		   {
			  concatenation += super.getComponents()[i];
			  if (i < super.getDim() - 1) 
			  {
				 concatenation += ", ";
			  }
		   }
		   concatenation += ")";
		   return concatenation;
	}
	
}
