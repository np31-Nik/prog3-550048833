package model;
/**
 * 
 * @author Nikita Polyanskiy 550048833
 *
 */

/**
 * Clase Ship.
 *
 */
public class Ship {
	
	private static int BOUNDING_SQUARE_SIZE;
	
	private static int HIT_VALUE;
	
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
		
	}
	
	public Set<Coordinate> getAbsolutePositions(Coordinate c){
		
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

