package model.ship;

import model.Board;
import model.Coordinate;
import model.CoordinateFactory;
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
@Override
public boolean checkCoordinate(Coordinate c) {
	if(c instanceof Coordinate2D) {
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
	}else {
		throw new IllegalArgumentException("Coordenada no es 2D");
	}
	
}
/**
 * Metodo show
 * @param unveil true=vista del dueño, false=vista del oponente
 * @return un string del tablero
 */
@Override
public String show(boolean unveil) {
	String tablero="";
	Craft barco;
	
	if(unveil) {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				barco = super.getBoard().get(CoordinateFactory.createCoordinate(new int[]{j,i}));
					if(barco!=null) {
						if(barco.isHit(CoordinateFactory.createCoordinate(new int[]{j,i}))) {
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
				barco = super.getBoard().get(CoordinateFactory.createCoordinate(new int[]{j,i}));
				if(!seen.contains(CoordinateFactory.createCoordinate(new int[]{j,i}))) {
					tablero+=NOTSEEN_SYMBOL;
				}else {
					if(barco!= null && barco.isHit(CoordinateFactory.createCoordinate(new int[]{j,i}))) {
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