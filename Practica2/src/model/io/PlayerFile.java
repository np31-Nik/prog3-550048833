package model.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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
 * Clase player file
 * @author Nikita Polyanskiy P550048833
 *
 */
public class PlayerFile implements IPlayer{
	/**
	 * BufferedReader br
	 */
	private BufferedReader br;
	/**
	 * String name
	 */
	private String name;
	/**
	 * moreshots
	 */
	private boolean moreshots=true;
	
	private CellStatus lastShotStatus;
	/**
	 * Constructor playerfile
	 * @param name nombre
	 * @param reader br
	 */
	public PlayerFile(String name, BufferedReader reader) {
		this.name=name;
		if(reader!=null) {
		br=reader;
		}else{
		throw new NullPointerException();	
		}
	}
	/**
	 * String getname
	 * @return name
	 */
	public String getName() {
		return name+" (PlayerFile)";
	}
	
	
	/**
	 * Metodo putcrafts
	 * @param b el board
	 * @throws InvalidCoordinateException invalid
	 * @throws OccupiedCoordinateException occupied
	 * @throws NextToAnotherCraftException next
	 * @throws BattleshipIOException io
	 */
	public void putCrafts(Board b) throws InvalidCoordinateException, OccupiedCoordinateException, NextToAnotherCraftException, BattleshipIOException {
		Set<String> types=new HashSet<String>();
		types.add("Cruiser");
		types.add("Battleship");
		types.add("Carrier");
		types.add("Destroyer");
		types.add("Bomber");
		types.add("Fighter");
		types.add("Transport");

		Set<String> ori=new HashSet<String>();
		ori.add("NORTH");
		ori.add("SOUTH");
		ori.add("WEST");
		ori.add("EAST");
		
		Orientation o = null;
		
		boolean leer=true;
		
		String line;
		Craft craft;
		
		int x,y,z;
		try {
			if(b!=null) {
				line=br.readLine();
			while((line!=null) && leer) {
				String[] tokens=line.split("\\s+");

				if(tokens[0].equals("put")) {
					if(tokens.length!=5 && tokens.length!=6) {
						throw new BattleshipIOException("Numero de parametros incorrecto");
					}else {
					if(types.contains(tokens[1])) {
						
						if(ori.contains(tokens[2])) {
							
							switch(tokens[2]) {
							case "NORTH":
								o=Orientation.NORTH;
								break;
							case "SOUTH":
								o=Orientation.SOUTH;
								break;
							case "WEST":
								o=Orientation.WEST;
								break;
							case "EAST":
								o=Orientation.EAST;
								break;
							}
							
							if(tokens.length==5) {
								
								x=Integer.parseInt(tokens[3]);
								y=Integer.parseInt(tokens[4]);
								int[] coords= {x,y};
								Coordinate c = CoordinateFactory.createCoordinate(coords);
								
								craft=CraftFactory.createCraft(tokens[1],o);
								b.addCraft(craft, c);
								
							}else if(tokens.length==6) {
								
								x=Integer.parseInt(tokens[3]);
								y=Integer.parseInt(tokens[4]);
								z=Integer.parseInt(tokens[5]);
								int[] coords= {x,y,z};
								Coordinate c = CoordinateFactory.createCoordinate(coords);
								
								craft=CraftFactory.createCraft(tokens[1],o);
								b.addCraft(craft, c);
							}
								
							}else {
								throw new BattleshipIOException("Orientacion no valida");
							}
						}
					}
				}else if(tokens[0].equals("endput") || tokens[0].equals("exit")) {
					leer=false;
					break;
				}else if(tokens[0].equals(null)){
					
				}else{
					throw new BattleshipIOException("comando incorrecto");
				}
				
				
				
				line=br.readLine();

			}
			}else {
				throw new NullPointerException();
			}
		} catch (IOException e) {
			throw new BattleshipIOException(e.getMessage());
		} catch (NumberFormatException e) {
			throw new BattleshipIOException(e.getMessage());
		}
	}
	
	/**
	 * Metodo nextShoot
	 * @param b el board
	 * @return coordenada
	 * @throws BattleshipIOException io
	 * @throws InvalidCoordinateException invalid
	 * @throws CoordinateAlreadyHitException hit
	 */
	public Coordinate nextShoot(Board b) throws BattleshipIOException, InvalidCoordinateException, CoordinateAlreadyHitException {
		String line;
		String[] tokens;
		boolean leer=true;

		try {
			while(((line=br.readLine())!=null) && leer && moreshots) {
				tokens= new String[0];
				tokens=line.split("\\s+");
				if(tokens[0].equals("shoot")) {

					if(tokens.length!=4 && tokens.length!=3) {
						throw new BattleshipIOException("Numero de parametros incorrecto");
					}else if(tokens.length==3) {

						int x=Integer.parseInt(tokens[1]);
						int y=Integer.parseInt(tokens[2]);
						
						int[] coords= {x,y};
						
						Coordinate c=CoordinateFactory.createCoordinate(coords);
						lastShotStatus=b.hit(c);
						return c;

					}else if(tokens.length==4) {
						int x=Integer.parseInt(tokens[1]);
						int y=Integer.parseInt(tokens[2]);
						int z=Integer.parseInt(tokens[3]);
						int[] coords= {x,y,z};
						
						Coordinate c=CoordinateFactory.createCoordinate(coords);
						lastShotStatus=b.hit(c);
						
						return c;
						
					}
				
				
				}else if(tokens[0].equals("exit")) {
					leer=false;	
					moreshots=false;
					lastShotStatus=null;
					break;
				}else {
					throw new BattleshipIOException("Comando incorrecto");	
				}
			}
		}catch (IOException e) {
			throw new BattleshipIOException(e.getMessage());
			
		}catch (NumberFormatException e) {
			throw new BattleshipIOException(e.getMessage());
		}
		return null;
	}
	
	public CellStatus getLastShotStatus() {
		return lastShotStatus;
	}
}
