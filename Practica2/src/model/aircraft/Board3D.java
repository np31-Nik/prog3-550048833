package model.aircraft;

import model.Board;
import model.Coordinate;
import model.CoordinateFactory;
import model.Craft;

/**
 * Clase Board.
 *
 */
public class Board3D extends Board {
	/**
	 * Constructor.
	 * @param size tamaño del tablero.
	 */
public Board3D(int size) {
	super(size);
}
/**
 * Metodo checkCoordinate
 * @param c la coordenada
 * @return true si esta dentro del tablero, false si esta fuera.
 */
@Override
public boolean checkCoordinate(Coordinate c) {
	if(c instanceof Coordinate3D) {
	boolean check=true;
	int x=c.get(0);
	int y=c.get(1);
	int z=c.get(2);
	
	if(x<0 || x >=size) {
		check=false;
	}
	if(y<0 || y>=size) {
		check=false;
	}
	if(z<0 || z>=size) {
		check=false;
	}
	
	return check;
	}else {
		throw new IllegalArgumentException("Coordenada no es 3D");
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
				for(int z=0;z<size;z++) {

				for(int j=0;j<size;j++) {
					barco = super.getBoard().get(CoordinateFactory.createCoordinate(new int[]{j,i,z}));
						if(barco!=null) {
							if(barco.isHit(CoordinateFactory.createCoordinate(new int[]{j,i,z}))) {
								tablero+=HIT_SYMBOL;
							}else
							tablero+=barco.getSymbol();		
						}else {
							tablero+=WATER_SYMBOL;
						}
						if(j==size-1)
							tablero+="|";
				}
			}
				tablero+="\n";

		}
	}else{
		
	
			for(int i=0;i<size;i++) {
				for(int z=0;z<size;z++) {
				for(int j=0;j<size;j++) {
					barco = super.getBoard().get(CoordinateFactory.createCoordinate(new int[]{j,i,z}));
					if(!seen.contains(CoordinateFactory.createCoordinate(new int[]{j,i,z}))) {
						tablero+=NOTSEEN_SYMBOL;
					}else {
						if(barco!= null && barco.isHit(CoordinateFactory.createCoordinate(new int[]{j,i,z}))) {
							if(barco.isShotDown()) {
								tablero+=barco.getSymbol();
							}else {
								tablero+=HIT_SYMBOL;
							}
						}else {
							tablero+=WATER_SYMBOL;
						}
					}
					if(j==size-1)
						tablero+="|";
				}
				
	
			}
				tablero+="\n";
		}
	}
	return tablero;
}
}