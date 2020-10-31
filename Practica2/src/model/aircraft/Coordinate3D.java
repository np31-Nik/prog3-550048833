package model.aircraft;

import java.util.HashSet;
import java.util.Set;

import model.Coordinate;
import model.CoordinateFactory;

public class Coordinate3D extends model.Coordinate {
	public Coordinate3D(int x, int y,int z) {
		super(x,y,z);
	}
	
	public Coordinate3D(Coordinate3D c) {
		super(c);
	}
	
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
	
	public Coordinate3D copy() {
		Coordinate3D c=new Coordinate3D(this);
		return c;
	}
	
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
