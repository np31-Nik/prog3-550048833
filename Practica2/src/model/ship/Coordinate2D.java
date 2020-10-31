package model.ship;

import java.util.HashSet;
import java.util.Set;

import model.Coordinate;
import model.CoordinateFactory;

public class Coordinate2D extends model.Coordinate {
	public Coordinate2D(int x, int y) {
		super(x,y);
	}
	
	public Coordinate2D(Coordinate2D c) {
		super(c);
	}
	
	public Set<Coordinate> adjacentCoordinates() {
		Set<Coordinate> conjunto_coordinate = new HashSet<Coordinate>();
		for(int ax=-1;ax<=1;ax++) {
			for(int ay=-1;ay<=1;ay++) {
				if(!(ay==0 && ax==0)) {
					int[] coords = {ax,ay};
					conjunto_coordinate.add(this.subtract(CoordinateFactory.createCoordinate(coords)));
				}
			}
		}
		
		return conjunto_coordinate;
	
		
	}
	
	public Coordinate2D copy() {
		Coordinate2D c=new Coordinate2D(this);
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
