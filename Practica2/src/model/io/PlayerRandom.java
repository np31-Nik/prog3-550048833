package model.io;

import java.util.Random;

import model.Board;
import model.CellStatus;
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
	 * Estado del ultimo disparo
	 */
	private CellStatus lastShotStatus;
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
	 * @throws BattleshipIOException io
	 */
	public void putCrafts(Board b) throws BattleshipIOException {
		int r_coord=0;
		boolean put;
		
		Craft Bomber = null;
		Craft Fighter = null;
		Craft Transport = null;
		
		Craft Battleship=CraftFactory.createCraft("ship.Battleship", intOri(genRandomInt(0,4)));

		do {
			try {
				r_coord++;
				b.addCraft(Battleship, genRandomCoordinate(b,Craft.getBOUNDING_SQUARE_SIZE()));
				put=true;
			}catch(InvalidCoordinateException | OccupiedCoordinateException | NextToAnotherCraftException e) {
				put=false;
			}
		}while(!put && r_coord<100);
		r_coord=0;
		Craft Carrier=CraftFactory.createCraft("ship.Carrier",  intOri(genRandomInt(0,4)));

		
		do {
			try {
				r_coord++;
				b.addCraft(Carrier, genRandomCoordinate(b,Craft.getBOUNDING_SQUARE_SIZE()));
				put=true;
			}catch(InvalidCoordinateException | OccupiedCoordinateException | NextToAnotherCraftException e) {
				put=false;
			}
		}while(!put && r_coord<100);
		r_coord=0;
		Craft Cruiser=CraftFactory.createCraft("ship.Cruiser",  intOri(genRandomInt(0,4)));

	
		do {
			try {
				r_coord++;
				b.addCraft(Cruiser, genRandomCoordinate(b,Craft.getBOUNDING_SQUARE_SIZE()));
				put=true;
			}catch(InvalidCoordinateException | OccupiedCoordinateException | NextToAnotherCraftException e) {
				put=false;
			}
		}while(!put && r_coord<100);
		r_coord=0;
		Craft Destroyer=CraftFactory.createCraft("ship.Destroyer",  intOri(genRandomInt(0,4)));


			do {
				try {
					r_coord++;
					b.addCraft(Destroyer, genRandomCoordinate(b,Craft.getBOUNDING_SQUARE_SIZE()));
					put=true;
				}catch(InvalidCoordinateException | OccupiedCoordinateException | NextToAnotherCraftException e) {
					put=false;
				}
			}while(!put && r_coord<100);
			r_coord=0;
		
		if(b instanceof Board3D) {
				Bomber=CraftFactory.createCraft("aircraft.Bomber", intOri(genRandomInt(0,4)));
				
			do {
				try {
					r_coord++;
					b.addCraft(Bomber, genRandomCoordinate(b,Craft.getBOUNDING_SQUARE_SIZE()));
					put=true;
				}catch(InvalidCoordinateException | OccupiedCoordinateException | NextToAnotherCraftException e) {
					put=false;
				}
			}while(!put && r_coord<100);
			r_coord=0;
			Fighter=CraftFactory.createCraft("aircraft.Fighter", intOri(genRandomInt(0,4)));

				do {
					try {
						r_coord++;
						b.addCraft(Fighter, genRandomCoordinate(b,Craft.getBOUNDING_SQUARE_SIZE()));
						put=true;
					}catch(InvalidCoordinateException | OccupiedCoordinateException | NextToAnotherCraftException e) {
						put=false;
					}
				}while(!put && r_coord<100);
				r_coord=0;
				Transport=CraftFactory.createCraft("aircraft.Transport", intOri(genRandomInt(0,4)));

					do {
						try {
							r_coord++;
							b.addCraft(Transport, genRandomCoordinate(b,Craft.getBOUNDING_SQUARE_SIZE()));
							put=true;
						}catch(InvalidCoordinateException | OccupiedCoordinateException | NextToAnotherCraftException e) {
							put=false;
						}
					}while(!put && r_coord<100);
					r_coord=0;
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
		lastShotStatus=b.hit(c);
		return c;
	}
	/**
	 * funcion getlastshot
	 * @return el ultimo disparo
	 */
	public CellStatus getLastShotStatus() {
		return lastShotStatus;
	}

}
