package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * 
 * @author Nikita Polyanskiy P550048833
 *
 */

/**
 * Clase Board.
 *
 */
public class Board {
	/**
	 * Simbolo golpeado
	 */
	public static char HIT_SYMBOL='•';
	/**
	 * Simbolo de agua
	 */
	public static char WATER_SYMBOL=' ';
	/**
	 * Simbolo no visto
	 */
	public static char NOTSEEN_SYMBOL='?';
	/**
	 * Tamaño maximo del tablero
	 */
	private static int MAX_BOARD_SIZE=20;
	/**
	 * Tamaño minimo del tablero
	 */
	private static int MIN_BOARD_SIZE=5;
	/**
	 * Tamaño del tablero
	 */
	private int size;
	/**
	 * Numero de barcos en el tablero
	 */
	private int numCrafts;
	/**
	 * Numero de barcos destruidos
	 */
	private int destroyedCrafts;
	/**
	 * Conjunto tipo mapa del tablero
	 */
	Map<Coordinate,Ship> board = new HashMap<Coordinate,Ship>();
	/**
	 * Conjunto set de las coordenadas vistas
	 */
	Set<Coordinate> seen=new HashSet<Coordinate>();
	
	/**
	 * Constructor.
	 * @param size tamaño del tablero.
	 */
public Board(int size) {
	if(size<MIN_BOARD_SIZE || size>MAX_BOARD_SIZE) {
		System.err.println("Error: board.size tiene que ser <20 y >5");
		this.size=MIN_BOARD_SIZE;
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
 * Metodo checkCoordinate
 * @param c la coordenada
 * @return true si esta dentro del tablero, false si esta fuera.
 */
public boolean checkCoordinate(Coordinate c) {
	boolean check=true;
	int a=c.get(0);
	int b=c.get(1);
	
	if(a<0 || a>size-1) {
		check=false;
	}
	if(b<0 || b>size-1) {
		check=false;
	}
	
	return check;
	
}
/**
 * Metodo addShip.
 * @param ship el barco
 * @param position la coordenada
 * @return verdadero si se ha agregado.
 */
public boolean addShip(Ship ship, Coordinate position) {
	boolean add=true;
	boolean out=false;
	boolean occupied=false;
	boolean neighbor=false;
	Set<Coordinate> coords=board.keySet();
	Ship barco2;
	
	for(Coordinate c : ship.getAbsolutePositions(position)) {
		if(!checkCoordinate(c) && !out) {
			out=true;
			System.err.println("Error, posicion fuera del tablero.");
		}
		
		for(Coordinate b_c : coords) {
			barco2=board.get(b_c);
			for(Coordinate b2_c : barco2.getAbsolutePositions()){
				if(b2_c == c && !occupied) {
					occupied=true;
					System.err.println("Error, la posicion esta ocupada.");
				}
			}
		}
		for(Coordinate n_c : getNeighborhood(ship,position)) {
			for(Coordinate b_c : coords) {
				barco2=board.get(b_c);
				for(Coordinate b2_c : barco2.getAbsolutePositions()){
					if(b2_c.add(position) == n_c && !neighbor) {
						neighbor=true;
						System.err.println("Error, hay un barco en la vecindad.");
					}
				}
			}
		}
	}

	if(out || occupied || neighbor) {
		add=false;
	}
	if(add) {
		for(Coordinate b : ship.getAbsolutePositions()) {
			board.put(b.add(position),ship);
			ship.setPosition(position);
		}
		numCrafts++;
	}
	return add;
}
/**
 * Metodo getShip
 * @param c la coordenada
 * @return el barco en dicha coordenada
 */
public Ship getShip(Coordinate c) {
	Ship ship = board.get(c);
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
 */
public CellStatus hit(Coordinate c) {
	if(!checkCoordinate(c)) {
		System.err.println("Error: Coordenada fuera de board.");
		return CellStatus.WATER;
	}
	if(getShip(c)==null) {
		seen.add(c);
		return CellStatus.WATER;
	}else {
		Ship ship=board.get(c);
		ship.hit(c);
		seen.add(c);
		if(ship.isShotDown()) {
			destroyedCrafts++;
			return CellStatus.DESTROYED;
		}else {
			return CellStatus.HIT;
		}
	}
}

/**
 * Metodo para verificar si todos los barcos estan destruidos
 * @return verdadero si lo estan
 */
public boolean areAllCraftsDestroyed() {
	boolean alive = false;
	Set<Coordinate> c=board.keySet();
	for (Coordinate coord : c) {
		if(!board.get(coord).isShotDown()) {
			alive=true;
		}
	}
	return alive;
}
/**
 * Metodo getNeighborhood
 * @param ship el barco
 * @param position la coordenada
 * @return un set de coordenadas de la vecindad
 */
public Set<Coordinate> getNeighborhood(Ship ship, Coordinate position){
	Set<Coordinate> S_abs=ship.getAbsolutePositions();
	Set<Coordinate> adj = new HashSet<Coordinate>();
	Set<Coordinate> neighbor = new HashSet<Coordinate>();
	
	for(Coordinate coor : S_abs) {
		adj=coor.adjacentCoordinates();
		for(Coordinate A_coor : adj) {
			A_coor.add(position);
			if(checkCoordinate(A_coor)) {
				neighbor.add(A_coor);
			}
		}
	}
	for(Coordinate coor : S_abs) {
		coor.add(position);
		if(neighbor.contains(coor)) {
			neighbor.remove(coor);
		}
	}
	return neighbor;
}

/**
 * Metodo getNeighborhood (ship)
 * @param ship el barco
 * @return un set de coordenadas de la vecindad
 */
public Set<Coordinate> getNeighborhood(Ship ship){
	return getNeighborhood(ship,ship.getPosition());
}

/**
 * Metodo show
 * @param unveil true=vista del dueño, false=vista del oponente
 * @return un string del tablero
 */
public String show(boolean unveil) {
	String tablero="";
	Ship barco;
	
	if(unveil) {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				barco = board.get(new Coordinate(i,j));
					if(barco!=null) {
						tablero+=barco.getSymbol();		
					}else {
						tablero+=WATER_SYMBOL;
					}
			}
			tablero+="\n";
		}
	}else{
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				barco = board.get(new Coordinate(i,j));
				if(!seen.contains(new Coordinate(i,j))) {
					tablero+=NOTSEEN_SYMBOL;
				}else {
					if(barco.isHit(new Coordinate(i,j))) {
						if(barco.isShotDown()) {
							tablero+=barco.getSymbol();
						}else {
							tablero+=HIT_SYMBOL;
						}
					}else {
						tablero+=WATER_SYMBOL;
					}
				}
			}
			tablero+="\n";

		}
	}
	return tablero;
}

/**
 * Metodo toString
 * @return el estado del tablero
 */
public String toString() {
		return "Board "+size+"; crafts: "+numCrafts+"; destroyed: "+destroyedCrafts;
}
}