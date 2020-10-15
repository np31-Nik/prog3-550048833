package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Board {
	public static char HIT_SYMBOL='•';
	public static char WATER_SYMBOL=' ';
	public static char NOTSEEN_SYMBOL='?';
	private static int MAX_BOARD_SIZE=20;
	private static int MIN_BOARD_SIZE=5;
	private int size;
	private int numCrafts;
	private int destroyedCrafts;
	Map<Coordinate,Ship> board = new HashMap<Coordinate,Ship>();
	Set<Coordinate> seen=new HashSet<Coordinate>();
	
public Board(int size) {
	if(size<MIN_BOARD_SIZE || size>MAX_BOARD_SIZE) {
		System.err.println("Error: board.size tiene que ser <20 y >5");
		this.size=MIN_BOARD_SIZE;
	}
	numCrafts=0;
	destroyedCrafts=0;
	
}

public int getSize() {
	return size;
}

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

public boolean addShip(Ship ship, Coordinate position) {
	boolean add=true;
	boolean out=false;
	boolean occupied=false;
	boolean neighbor=false;
	
	for(Coordinate c : ship.getAbsolutePositions(position)) {
		if(!checkCoordinate(c)) {
			out=true;
		}
	}
	if(out || occupied || neighbor) {
		add=false;
	}
	if(add) {
		
	}
	return add;
}
public Ship getShip(Coordinate c) {
	Ship ship = board.get(c);
	return ship;
}

public boolean isSeen(Coordinate c) {
	if(seen.contains(c)) {
		return true;
	}
	return false;
}

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
public Set<Coordinate> getNeighborhood(Ship ship){
	return getNeighborhood(ship,ship.getPosition());
}

public String show(boolean unveil) {
	String tablero="";
	Ship barco;
	
	if(unveil==true) {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				barco = board.get(new Coordinate(i,j));
					if(barco!=null) {
						tablero+=barco.getSymbol();		
					}else {
						tablero+=WATER_SYMBOL;
					}
			}
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
		}
	}
	return tablero;
}

public String toString() {
		return "Board "+size+"; crafts: "+numCrafts+"; destroyed: "+destroyedCrafts;
}
}