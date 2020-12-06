package model.io;

import java.util.Random;

import model.Board;
import model.Coordinate;
import model.CoordinateFactory;
import model.Craft;
import model.CraftFactory;
import model.Orientation;
import model.aircraft.Board3D;
import model.exceptions.BattleshipException;
import model.exceptions.CoordinateAlreadyHitException;
import model.exceptions.InvalidCoordinateException;
import model.exceptions.NextToAnotherCraftException;
import model.exceptions.OccupiedCoordinateException;
import model.exceptions.io.BattleshipIOException;
import model.ship.Board2D;
/**
 * Clase PlayerRandom
 * @author Nikita Polyanskiy P550048833
 *
 */
public class PlayerRandom implements IPlayer{
	/**
	 * Random
	 */
	private Random random;
	/**
	 * Nombre
	 */
	private String name;
	/**
	 * Constructor
	 * @param name nombre
	 * @param seed semilla
	 */
	public PlayerRandom(String name, long seed) {
		this.name=name;
		random=new Random(seed);
	}
	/**
	 * metodo random int
	 * @param min minimo
	 * @param max maximo
	 * @return el random
	 */
	private int genRandomInt(int min, int max) {
	    return random.nextInt(max-min)+min;
	}
	/**
	 * Metodo genrandomcoordinate
	 * @param b el board
	 * @param offset el offset
	 * @return la coordenada
	 */
	private Coordinate genRandomCoordinate(Board b, int offset) {
		Coordinate c=null;
		if(b instanceof Board2D) {
			int x=genRandomInt(0-offset, b.getSize());
			int y=genRandomInt(0-offset, b.getSize());
			int[] coords= {x,y};
			c=CoordinateFactory.createCoordinate(coords);
		}else if(b instanceof Board3D) {
			int x=genRandomInt(0-offset, b.getSize());
			int y=genRandomInt(0-offset, b.getSize());
			int z=genRandomInt(0-offset, b.getSize());
			int[] coords= {x,y,z};
			c=CoordinateFactory.createCoordinate(coords);
		}
		return c;
	}
	/**
	 * getName
	 * @return el nombre
	 */
	public String getName() {
		return name+" (PlayerRandom)";
	}
/**
 * int ori
 * @param r el numero aleatorio
 * @return la orientacion
 */
	private Orientation intOri(int r) {
		Orientation ori = null;
		switch(r) {
		case 0:
			ori=Orientation.NORTH;
			break;
		case 1:
			ori=Orientation.EAST;
			break;
			
		case 2:
			ori=Orientation.SOUTH;
			break;
		case 3:
			ori=Orientation.WEST;
			break;
		}
		return ori;
		
	}
	/**
	 * Metodo putcrafts
	 * @param b el board
	 * @throws InvalidCoordinateException invalid
	 * @throws OccupiedCoordinateException occupied
	 * @throws NextToAnotherCraftException next
	 * @throws BattleshipIOException io
	 */
	public void putCrafts(Board b) throws InvalidCoordinateException, OccupiedCoordinateException,
			NextToAnotherCraftException, BattleshipIOException {
		
		Craft Battleship=CraftFactory.createCraft("Battleship", intOri(genRandomInt(0,4)));
		Craft Carrier=CraftFactory.createCraft("Carrier",  intOri(genRandomInt(0,4)));
		Craft Cruiser=CraftFactory.createCraft("Cruiser",  intOri(genRandomInt(0,4)));
		Craft Destroyer=CraftFactory.createCraft("Destroyer",  intOri(genRandomInt(0,4)));
		
		Craft Bomber = null;
		Craft Fighter = null;
		Craft Transport = null;
		
		if(b instanceof Board3D) {
			Bomber=CraftFactory.createCraft("Bomber", intOri(genRandomInt(0,4)));
			Fighter=CraftFactory.createCraft("Fighter", intOri(genRandomInt(0,4)));
			Transport=CraftFactory.createCraft("Transport", intOri(genRandomInt(0,4)));
		}
		
		b.addCraft(Battleship, genRandomCoordinate(b,Craft.getBOUNDING_SQUARE_SIZE()));
		b.addCraft(Carrier, genRandomCoordinate(b,Craft.getBOUNDING_SQUARE_SIZE()));
		b.addCraft(Cruiser, genRandomCoordinate(b,Craft.getBOUNDING_SQUARE_SIZE()));
		b.addCraft(Destroyer, genRandomCoordinate(b,Craft.getBOUNDING_SQUARE_SIZE()));
		
		if(b instanceof Board3D) {
			b.addCraft(Bomber, genRandomCoordinate(b,Craft.getBOUNDING_SQUARE_SIZE()));
			b.addCraft(Fighter, genRandomCoordinate(b,Craft.getBOUNDING_SQUARE_SIZE()));
			b.addCraft(Transport, genRandomCoordinate(b,Craft.getBOUNDING_SQUARE_SIZE()));
		}
	}
/**
 * Metodo nextshoot
 * @param b el board
 * @return la coordenada
 * @throws BattleshipIOException io
 * @throws InvalidCoordinateException invalid
 * @throws CoordinateAlreadyHitException alreaydhit
 */
	public Coordinate nextShoot(Board b) throws BattleshipIOException, InvalidCoordinateException, CoordinateAlreadyHitException {
		Coordinate c=genRandomCoordinate(b,0);
		b.hit(c);
		return c;
	}

}
