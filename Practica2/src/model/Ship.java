package model;
/**
 * 
 * @author Nikita Polyanskiy 550048833
 *
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Clase Ship.
 *
 */
public class Ship {
	
	private static int BOUNDING_SQUARE_SIZE=5;
	
	private static int HIT_VALUE=-1;
	
	private static int CRAFT_VALUE=1;
	
	private char symbol;
	
	private String name;
	
	private int shape[][] = new int[][] {
        { 0, 0, 0, 0, 0,               // NORTH    ·····
          0, 0, 1, 0, 0,               //          ··#··
          0, 0, 1, 0, 0,               //          ··#··
          0, 0, 1, 0, 0,               //          ..#..
          0, 0, 0, 0, 0},              //          ·····

        { 0, 0, 0, 0, 0,               // EAST     ·····
          0, 0, 0, 0, 0,               //          ·····
          0, 1, 1, 1, 0,               //          ·###·
          0, 0, 0, 0, 0,               //          ·····
          0, 0, 0, 0, 0},              //          ·····

        { 0, 0, 0, 0, 0,               // SOUTH    ·····
          0, 0, 1, 0, 0,               //          ··#··
          0, 0, 1, 0, 0,               //          ··#··
          0, 0, 1, 0, 0,               //          ..#..
          0, 0, 0, 0, 0},              //          ·····

        { 0, 0, 0, 0, 0,               // WEST     ·····
          0, 0, 0, 0, 0,               //          ·····
          0, 1, 1, 1, 0,               //          ·###·
          0, 0, 0, 0, 0,               //          ·····
          0, 0, 0, 0, 0}};             //          ·····
	
	private Orientation orientation;
	
	private Coordinate position;
	
	public Ship(Orientation o, char s, String n) {
		orientation=o;
		symbol=s;
		name=n;
	}
	
	public Coordinate getPosition() {
		if(position!=null) {
		Coordinate c= this.position.copy();
		return c;
		}
		
		return null;
	}
	
	public void setPosition(Coordinate position) {
	
	}
	
	public String getName() {
		
	}
	
	public Orientation getOrientation() {
		
	}
	
	public char getSymbol() {
		
	}
	
	public int[][] getShape(){
		
	}
	
	public int getShapeIndex(Coordinate c) {
		int r;
		int a=c.get(0);
		int b=c.get(1);
		
		r=b*BOUNDING_SQUARE_SIZE+a;
		
		return r;
	}
	
	public Set<Coordinate> getAbsolutePositions(Coordinate c){
		
	}
	
	public Set<Coordinate> getAbsolutePositions(){
		Set<Coordinate> conjunto_coordinate = new HashSet<Coordinate>();
		int ori=0;
		int x,y;
		
		switch(orientation) {
		case NORTH:
			ori=0;
			break;
		case EAST:
			ori=1;
			break;
		case SOUTH:
			ori=2;
			break;
		case WEST:
			ori=3;
			break;
		default:
			break;
		}
		
		for(int i=0;i<25;i++) {
			if(shape[ori][i]==CRAFT_VALUE) {
				x=i/BOUNDING_SQUARE_SIZE;
				if(i>BOUNDING_SQUARE_SIZE) {
					y=i-BOUNDING_SQUARE_SIZE;
				}else {
					y=i;
				}
				conjunto_coordinate.add(new Coordinate(x,y));
			}
		}
		return conjunto_coordinate;
	}
	
	public boolean hit(Coordinate c) {
		
	}
	
	public boolean isShotDown() {
		
	}
	
	public boolean isHit(Coordinate c) {
		
	}

	public static int getBOUNDING_SQUARE_SIZE() {
		return BOUNDING_SQUARE_SIZE;
	}

	public static void setBOUNDING_SQUARE_SIZE(int bOUNDING_SQUARE_SIZE) {
		BOUNDING_SQUARE_SIZE = bOUNDING_SQUARE_SIZE;
	}

	public static int getHIT_VALUE() {
		return HIT_VALUE;
	}

	public static void setHIT_VALUE(int hIT_VALUE) {
		HIT_VALUE = hIT_VALUE;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setShape(int[][] shape) {
		this.shape = shape;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	
	
	
}

