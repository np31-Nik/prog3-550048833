package model.ship;

import model.Board;
import model.Coordinate;
import model.Craft;

/**
 * Clase Board.
 *
 */
public class Board2D extends Board {
	/**
	 * Constructor.
	 * @param size tamaño del tablero.
	 */
public Board2D(int size) {
	super(size);
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
	
	if(a<0 || a>=size) {
		check=false;
	}
	if(b<0 || b>=size) {
		check=false;
	}
	
	return check;
	
}
/**
 * Metodo show
 * @param unveil true=vista del dueño, false=vista del oponente
 * @return un string del tablero
 */
public String show(boolean unveil) {
	String tablero="";
	Craft barco;
	
	if(unveil) {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				barco = board.get(new Coordinate(j,i));
					if(barco!=null) {
						if(barco.isHit(new Coordinate(j,i))) {
							tablero+=HIT_SYMBOL;
						}else
						tablero+=barco.getSymbol();		
					}else {
						tablero+=WATER_SYMBOL;
					}
			}
			if(i<size-1)
			tablero+="\n";
		}
	}else{
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				barco = board.get(new Coordinate(j,i));
				if(!seen.contains(new Coordinate(j,i))) {
					tablero+=NOTSEEN_SYMBOL;
				}else {
					if(barco!= null && barco.isHit(new Coordinate(j,i))) {
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
			if(i<size-1)
			tablero+="\n";

		}
	}
	return tablero;
}
}