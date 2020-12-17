package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import model.exceptions.CoordinateAlreadyHitException;
import model.exceptions.InvalidCoordinateException;
import model.exceptions.NextToAnotherCraftException;
import model.exceptions.OccupiedCoordinateException;
import model.ship.Ship;
/**
 * Clase board
 * @author Nikita Polyanskiy P550048833
 *
 */
public abstract class Board {

	/**
	 * Simbolo golpeado
	 */
	public static char HIT_SYMBOL = '•';
	/**
	 * Simbolo de agua
	 */
	public static char WATER_SYMBOL = ' ';
	/**
	 * Simbolo no visto
	 */
	public static char NOTSEEN_SYMBOL = '?';
	/**
	 * Tamaño maximo del tablero
	 */
	public static int MAX_BOARD_SIZE = 20;
	/**
	 * Tamaño minimo del tablero
	 */
	public static int MIN_BOARD_SIZE = 5;
	/**
	 * Caracter separador de los tableros
	 */
	public char Board_SEPARATOR ='|';
	/**
	 * Tamaño del tablero
	 */
	protected int size;
	/**
	 * Numero de barcos en el tablero
	 */
	protected int numCrafts;
	/**
	 * Numero de barcos destruidos
	 */
	protected int destroyedCrafts;
	/**
	 * Mapa tablero
	 */
	private Map<Coordinate,Craft> board = new HashMap<Coordinate,Craft>();
	/**
	 * Conjunto set de las coordenadas vistas
	 */
	protected Set<Coordinate> seen = new HashSet<Coordinate>();
/**
 * Metodo checkcoordinate
 * @param c la coordenada
 * @return verdadero si esta dentro de los limites
 */
	abstract public boolean checkCoordinate(Coordinate c);
	/**
	 * Metodo show
	 * @param unveil si se ve el tablero
	 * @return el tablero
	 */
	public abstract String show(boolean unveil);
/**
 * Constructor con size
 * @param size el tamaño
 */
	public Board(int size) {
		if(size<MIN_BOARD_SIZE || size>MAX_BOARD_SIZE) {
			throw new IllegalArgumentException("Tamaño del tablero fuera de limites");
		}else {
			this.size=size;
		}
		numCrafts=0;
		destroyedCrafts=0;
	}

	/**
	 * Metodo getSize
	 * @return el tamaño del tablero.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Metodo addShip.
	 * @param craft el barco
	 * @param position la coordenada
	 * @return verdadero si se ha agregado.
	 * @throws InvalidCoordinateException 
	 * @throws OccupiedCoordinateException 
	 * @throws NextToAnotherCraftException 
	 */
	public boolean addCraft(Craft craft, Coordinate position) throws InvalidCoordinateException, OccupiedCoordinateException, NextToAnotherCraftException {
		boolean add=true;
		//System.out.println(craft.getName());
		for(Coordinate c_barco : craft.getAbsolutePositions(position)) {
			if(!checkCoordinate(c_barco)) {
				throw new InvalidCoordinateException(c_barco);
			}
			
			
		}
		for(Coordinate c_barco : craft.getAbsolutePositions(position)) {
			if(board.keySet().contains(c_barco)) {
				throw new OccupiedCoordinateException(c_barco);
			}
		}
		
		for(Coordinate c_neighbor : getNeighborhood(craft,position)) {
			if(board.keySet().contains(c_neighbor)){
				throw new NextToAnotherCraftException(c_neighbor);
			}
		}
		if(add){
			for(Coordinate c : craft.getAbsolutePositions(position)) {
				board.put(c, craft);
			}
			numCrafts++;
			craft.setPosition(position);
		}
		return add;
	}

	/**
	 * Metodo getShip
	 * @param c la coordenada
	 * @return el barco en dicha coordenada
	 */
	public Craft getCraft(Coordinate c) {
		Craft ship = board.get(c);
		return ship;
	}

	/**
	 * Metodo isSeen
	 * @param c la coordenada
	 * @return verdadero si seen contiene la coordenada
	 */
	public boolean isSeen(Coordinate c) {
		if(seen.contains(c)) {
			return true;
		}
		return false;
	}

	/**
	 * Metodo hit
	 * @param c la coordenada
	 * @return el CellStatus de la coordenada
	 * @throws InvalidCoordinateException 
	 * @throws CoordinateAlreadyHitException 
	 */
	public CellStatus hit(Coordinate c) throws InvalidCoordinateException, CoordinateAlreadyHitException {
		if(!checkCoordinate(c)) {
			throw new InvalidCoordinateException(c);
		}
		/*if(c==null) {
			throw new InvalidCoordinateException(c);
		}*/
		if(getCraft(c)==null) {
			seen.add(c.copy());
			return CellStatus.WATER;
		}else{
			Craft ship=board.get(c);
			//System.out.println("-------------------------");
			Set<Coordinate> neigh = getNeighborhood(ship);
			//System.out.println("-------------------------");
	
			ship.hit(c);
			seen.add(c.copy());
			if(ship.isShotDown()) {
				destroyedCrafts++;
	
				for(Coordinate S : neigh) {
					seen.add(S.copy());
				}

				return CellStatus.DESTROYED;
			}else{
				return CellStatus.HIT;
			}
		}
	}

	/**
	 * Metodo para verificar si todos los barcos estan destruidos
	 * @return verdadero si lo estan
	 */
	public boolean areAllCraftsDestroyed() {
		boolean destroyed=true;
		if(numCrafts!=0) {
			if(numCrafts>destroyedCrafts) {
				destroyed=false;
			}
		}
		/*
		Set<Coordinate> c=board.keySet();
		if(numCrafts!=0) {
		for (Coordinate coord : c) {
			if(!board.get(coord).isShotDown()) {
				destroyed=false;
			}
		}
		}
		*/
		return destroyed;
	}

	/**
	 * Metodo getNeighborhood
	 * @param ship el barco
	 * @param position la coordenada
	 * @return un set de coordenadas de la vecindad
	 */
	public Set<Coordinate> getNeighborhood(Craft ship, Coordinate position) {
		Set<Coordinate> neighbor = new HashSet<Coordinate>();
		if(position!=null && ship!= null) {
			
			for(Coordinate coor : ship.getAbsolutePositions(position)) {
				for(Coordinate A_coor : coor.adjacentCoordinates()) {
					if(checkCoordinate(A_coor)) {
						neighbor.add(A_coor);
						//System.out.println(A_coor.toString());
		
					}
				}
			}
			for(Coordinate coor : ship.getAbsolutePositions(position)) {
				if(neighbor.contains(coor)) {
					neighbor.remove(coor);
				}
			}
		}else {
			throw new NullPointerException("Valores nulos");	
		}
		
		return neighbor;
	}

	/**
	 * Metodo getNeighborhood (ship)
	 * @param ship el barco
	 * @return un set de coordenadas de la vecindad
	 */
	public Set<Coordinate> getNeighborhood(Craft ship) {
		return getNeighborhood(ship,ship.getPosition());
	}

	/**
	 * Metodo toString
	 * @return el estado del tablero
	 */
	public String toString() {
			return "Board "+size+"; crafts: "+numCrafts+"; destroyed: "+destroyedCrafts;
	}
/**
 * Metodo que devuelve el mapa del tablero
 * @return el mapa del tablero
 */
	public Map<Coordinate, Craft> getBoard() {
		return board;
	}
/**
 * Metodo set del tablero
 * @param board el tablero nuevo
 */
	public void setBoard(Map<Coordinate, Craft> board) {
		this.board = board;
	}

}