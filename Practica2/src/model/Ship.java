package model;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author Nikita Polyanskiy P550048833
 *
 */

/**
 * Clase Ship
 *
 */
public class Ship {
	/**
	 * Tamaño de shape
	 */
	private static int BOUNDING_SQUARE_SIZE=5;
	/**
	 * Valor si golpeado
	 */
	private static int HIT_VALUE=-1;
	/**
	 * Valor si hay un barco
	 */
	private static int CRAFT_VALUE=1;
	/**
	 * Simbolo del barco
	 */
	private char symbol;
	/**
	 * Nombre del barco
	 */
	private String name;
	/**
	 * Matriz molde del barco
	 */
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
	/**
	 * Orientacion del barco
	 */
	private Orientation orientation;
	/**
	 * posicion del barco
	 */
	private Coordinate position;
	/**
	 * Constructor
	 * @param o orientacion
	 * @param s simbolo
	 * @param n nombre
	 */
	public Ship(Orientation o, char s, String n) {
		orientation=o;
		symbol=s;
		name=n;
	}
	/**
	 * Metodo getPosition
	 * @return la posicion del barco
	 */
	public Coordinate getPosition() {
		if(position!=null) {
		Coordinate c= this.position.copy();
		return c;
		}
		
		return null;
	}
	/**
	 * Metodo setPosition
	 * @param position la nueva posicion del barco
	 */
	public void setPosition(Coordinate position) {
		this.position=position;
	}
	/**
	 * Metodo getName
	 * @return el nombre del barco
	 */
	public String getName() {
		return name;
	}
	/**
	 * Metodo getOrientation
	 * @return la orientacion del barco
	 */
	public Orientation getOrientation() {
		return orientation;
	}
	/**
	 * Metodo getSymbol
	 * @return el simbolo del barco
	 */
	public char getSymbol() {
		return symbol;
	}
	/**
	 * Metodo getShape
	 * @return el shape del barco
	 */
	public int[][] getShape(){
		return shape;
	}
	/**
	 * Metodo getShapeIndex
	 * @param c la coordenada
	 * @return el indice en shape de la coordenada
	 */
	public int getShapeIndex(Coordinate c) {
		int r;
		int a=c.get(0);
		int b=c.get(1);
		
		r=b*BOUNDING_SQUARE_SIZE+a;
		
		return r;
	}
	/**
	 * Metodo getAbsolutePositions
	 * @param c la coordenada
	 * @return Un conjunto de las coordenadas absolutas del barco
	 */
	public Set<Coordinate> getAbsolutePositions(Coordinate c){
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
		
		for(int i=0;i<BOUNDING_SQUARE_SIZE*BOUNDING_SQUARE_SIZE;i++) {
			if(shape[ori][i]==CRAFT_VALUE) {
				y=i/BOUNDING_SQUARE_SIZE;
				x=i-BOUNDING_SQUARE_SIZE*y;
				
				x=x+c.get(0);
				y=y+c.get(1);
				conjunto_coordinate.add(new Coordinate(x,y));
			}
		}
		return conjunto_coordinate;
	}
	/**
	 * Metodo getAbsolutePositions
	 * @return las coordenadas absolutas del barco
	 */
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
	/**
	 * Metodo hit
	 * @param c la coordenada
	 * @return verdadero si el barco es golpeado
	 */
	public boolean hit(Coordinate c) {
		boolean HIT=false;
		int pos,ori=0;
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
		if(position!=null) {
			if(getAbsolutePositions(this.position).contains(c)) {
			
				HIT=true;
				pos=getShapeIndex(c.subtract(position));
				shape[ori][pos]=HIT_VALUE;
			}
		}
		return HIT;
	}
	/**
	 * Metodo isShotDown
	 * @return verdadero si el barco esta destruido
	 */
	public boolean isShotDown() {
		int ori=0;
		boolean shot=true;
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
		for(int i=0;i<25 && shot;i++) {
			if(shape[ori][i]==CRAFT_VALUE) {
				shot=false;
			}
		}
		
		return shot;
		
	}
	/**
	 * Metodo isHit
	 * @param c la coordenada
	 * @return verdadero si el barco esta golpeado
	 */
	public boolean isHit(Coordinate c) {
		boolean HIT=false;
		int pos=getShapeIndex(c.subtract(position));
		int ori=0;
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
		if(shape[ori][pos]==HIT_VALUE) {
				HIT=true;
			}
		return HIT;
	}
	/**
	 * Metodo getBOUNDING_SQUARE_SIZE
	 * @return BOUNDING_SQUARE_SIZE el tamaño de shape
	 */
	public static int getBOUNDING_SQUARE_SIZE() {
		return BOUNDING_SQUARE_SIZE;
	}
	/**
	 * Metodo setBOUNDING_SQUARE_SIZE
	 * @param bOUNDING_SQUARE_SIZE nuevo tamaño de shape
	 */
	public static void setBOUNDING_SQUARE_SIZE(int bOUNDING_SQUARE_SIZE) {
		BOUNDING_SQUARE_SIZE = bOUNDING_SQUARE_SIZE;
	}
	/**
	 * Metodo getHIT_VALUE
	 * @return HIT_VALUE el valor si golpeado
	 */
	public static int getHIT_VALUE() {
		return HIT_VALUE;
	}
	/**
	 * Metodo setHIT_VALUE
	 * @param hIT_VALUE nuevo valor si golpeado
	 */
	public static void setHIT_VALUE(int hIT_VALUE) {
		HIT_VALUE = hIT_VALUE;
	}
	/**
	 * Metodo setSymbol
	 * @param symbol nuevo simbolo del barco
	 */
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	/**
	 * Metodo setName
	 * @param name nuevo nombre del barco
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Metodo setShape
	 * @param shape nuevo shape del barco
	 */
	public void setShape(int[][] shape) {
		this.shape = shape;
	}
	/**
	 * Metodo setOrientation
	 * @param orientation nueva orientacion del barco
	 */
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	/**
	 * Metodo toString
	 * @return ship detalles del barco
	 */
	public String toString() {
		String ship=name+" ("+orientation+")"+"\n";
		int ori=0;
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
		
		ship+=" ";
		
		for(int k=0;k<BOUNDING_SQUARE_SIZE;k++) {
			ship+="-";
		}
		ship+="\n";
		
		for(int i=0;i<BOUNDING_SQUARE_SIZE;i++) {
			ship+="|";
					for(int j=0;j<BOUNDING_SQUARE_SIZE;j++) {
						if(shape[ori][j+i*5]==0) {
							ship+=Board.WATER_SYMBOL;
						}else if(shape[ori][j+i*5]==CRAFT_VALUE) {
							ship+=symbol;
						}else if(shape[ori][j+i*5]==HIT_VALUE) {
							ship+=Board.HIT_SYMBOL;
						}
					}
			ship+="|"+"\n";
		}
		ship+=" ";
		for(int k=0;k<BOUNDING_SQUARE_SIZE;k++) {
			ship+="-";
		}
	return ship;
	}
	
}