package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.ship.Ship;

public class ShipTest {
	final static int BOUNDING_SQUARE_SIZE = 5;
	static ArrayList<Coordinate> north, east, south, west;
    static String sNorth, sEast, sSouth, sWest;
	Craft bergantin, goleta, fragata, galeon;
    final int shape[][] = new int[][] {
	      { 0, 0, 0, 0, 0,
	    	0, 0, 1, 0, 0,	
	    	0, 0, 1, 0, 0,	
	    	0, 0, 1, 0, 0,
	    	0, 0, 0, 0, 0},
	      { 0, 0, 0, 0, 0,
		    0, 0, 0, 0, 0,	
		    0, 1, 1, 1, 0,	
		    0, 0, 0, 0, 0,
		    0, 0, 0, 0, 0},
	      { 0, 0, 0, 0, 0,
		    0, 0, 1, 0, 0,	
		    0, 0, 1, 0, 0,	
		    0, 0, 1, 0, 0,
		    0, 0, 0, 0, 0},
		  { 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0,	
		    0, 1, 1, 1, 0,	
		    0, 0, 0, 0, 0,
		    0, 0, 0, 0, 0}}; 
		
		    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
			north = new ArrayList<Coordinate>();
			east = new ArrayList<Coordinate>();
			south = new ArrayList<Coordinate>();
			west = new ArrayList<Coordinate>();
			for (int i=1; i < 4; i++) {
				north.add(new Coordinate(2,i));
				east.add(new Coordinate(i,2));
				south.add(new Coordinate(2,i));
				west.add(new Coordinate(i,2));
			}
			 sEast = "Bergantín (EAST)\n -----\n|     |\n|     |\n| BBB |\n|     |\n|     |\n -----";
			 sNorth ="Goleta (NORTH)\n -----\n|     |\n|  G  |\n|  G  |\n|  G  |\n|     |\n -----";
			 sSouth ="Galeón (SOUTH)\n -----\n|     |\n|  A  |\n|  A  |\n|  A  |\n|     |\n -----";
			 sWest = "Fragata (WEST)\n -----\n|     |\n|     |\n| FFF |\n|     |\n|     |\n -----";
	}	    
		    
		    
		    
		    
	@Before
	public void setUp() throws Exception {
		bergantin = new Ship(Orientation.EAST,'B',"Bergantín");
		goleta = new Ship(Orientation.NORTH,'G',"Goleta");
		fragata = new Ship(Orientation.WEST,'F',"Fragata");
		galeon = new Ship(Orientation.SOUTH,'A',"Galeón");
	}


	/* Se comprueba la composición entre Ship y Coordinate. Para ello se
	 * crea un objeto Coordinate, posicionamos un Ship a esa Coordinate.
	 * Comprobamos que esa Coordinate y la posición del Ship son iguales.
	 * Modificamos la Coordinate y comprobamos que ésta y la posición del
	 * Ship ya no son iguales 
	 */
	@Test
	public void testSetPosition() {
		Coordinate pos = new Coordinate(7,4);
	     
		//Comprobamos la composición entre Ship y Coordinate
		bergantin.setPosition(pos);
		assertEquals (pos, bergantin.getPosition());
		pos.set(0, -2);
		pos.set(1, -24);
		assertNotEquals(pos, bergantin.getPosition());
		
		
		//Modificamos posición y comprobamos de nuevo
		pos = new Coordinate(-17,-2);
		bergantin.setPosition(pos);	
		assertEquals(pos, bergantin.getPosition());
		pos.set(0, 12);
		pos.set(1, 34);
		assertNotEquals(pos, bergantin.getPosition());
	}

	/* Se comprueba que la posición inicial de un Ship es null.
	 * Comprobamos que getPosition hace copia defensiva: Para ello
	 * se posiciona el Ship en una Coordinate concreta. Se comprueba 
	 * que la posición del Ship y la Coordinate son iguales, pero no
	 * tienen la misma referencia.
	 */
	@Test
	public void testGetPosition() {
		Coordinate pos = bergantin.getPosition();
		//Inicialmente la position del ship debe ser null 
		assertNull(pos);
		
		//Comprobamos que getPosition hace copia defensiva
		Coordinate pos1 = new Coordinate(7,4);
		bergantin.setPosition(pos1);
		Coordinate pos2 = bergantin.getPosition();
		assertNotSame (pos1, pos2);
		assertEquals(pos1, pos2);
	}

	@Test
	public void testGetName() {
		assertEquals ("Bergantín",bergantin.getName());
		assertEquals ("Fragata",fragata.getName());
	}

	@Test
	public void testGetOrientation() {
		assertEquals (Orientation.NORTH, goleta.getOrientation());
		assertEquals (Orientation.EAST, bergantin.getOrientation());
		assertEquals (Orientation.SOUTH, galeon.getOrientation());
		assertEquals (Orientation.WEST, fragata.getOrientation());
	}

	@Test
	public void testGetSymbol() {
		assertEquals ('B',bergantin.getSymbol());
		assertEquals ('G',goleta.getSymbol());
		assertEquals ('A',galeon.getSymbol());
		assertEquals ('F',fragata.getSymbol());
	}

	/* Se comprueba que la matriz shape del alumno es correcta */
	@Test
	public void testGetShape() {
		int [][] shapeAux = goleta.getShape();
		for (int i=0; i< shape.length; i++) 
			for (int j=0; j<shape[i].length; j++)
				assertEquals(shape[i][j],shapeAux[i][j]);
	}

	/* Se comprueba, para todas las coordenadas relativas, que getShapeIndex(Coordinate):
	 * 1- Devuelve un valor entre 0 y 24 (ambos inclusives)
	 * 2- El correspondiente valor de x dentro de shape[][] para las distintas orientaciones, es correcto.
	 */
	@Test
	public void testGetShapeIndex() {
		Coordinate c;
		int x;
		for (int i=0; i<BOUNDING_SQUARE_SIZE; i++)
			for (int j=0; j<BOUNDING_SQUARE_SIZE; j++) {
				c = new Coordinate(i,j);
				x = goleta.getShapeIndex(c);
				assertTrue ("0<="+x+"<=24", (0<=x) && (x<=24));
				if ( (x==7)||(x==12)||(x==17) ) {
					assertTrue("Sape[NORTH]["+x+"]==1",goleta.getShape()[Orientation.NORTH.ordinal()][x]==1);
					assertTrue("Sape[SOUTH]["+x+"]==1",goleta.getShape()[Orientation.SOUTH.ordinal()][x]==1);
				}
				else {
					assertTrue("Sape[NORTH]["+x+"]==1",goleta.getShape()[Orientation.NORTH.ordinal()][x]==0);
					assertTrue("Sape[SOUTH]["+x+"]==1",goleta.getShape()[Orientation.SOUTH.ordinal()][x]==0);
				}
				if ( (x>10)&&(x<14) ) {
					assertTrue("Sape[EAST]["+x+"]==1",goleta.getShape()[Orientation.EAST.ordinal()][x]==1);
					assertTrue("Sape[WEST]["+x+"]==1",goleta.getShape()[Orientation.WEST.ordinal()][x]==1);
				}
				else {
					assertTrue("Sape[EAST]["+x+"]==1",goleta.getShape()[Orientation.EAST.ordinal()][x]==0);
					assertTrue("Sape[WEST]["+x+"]==1",goleta.getShape()[Orientation.WEST.ordinal()][x]==0);
				}
				
			}
	}

	/* Se comprueba que las posiciones absolutas para la orientación NORTH a partir de
	 * una Coordinate son correctas.
	 */
	@Test
	public void testGetAbsolutePositionsNorth() {
		
		Coordinate c1 = new Coordinate(13,27);
		Set<Coordinate> pos = goleta.getAbsolutePositions(c1);
		for (Coordinate c: north)
			assertTrue("Valores Absolutos posiciones c1+"+c, pos.contains(c.add(c1)));
	}
	
	/* Se comprueba que las posiciones absolutas para la orientación EARTH a partir de
	 * una Coordinate son correctas.
	 */
	@Test
	public void testGetAbsolutePositionsEast() {
		Coordinate c1 = new Coordinate(0,0);
		Set<Coordinate> pos = bergantin.getAbsolutePositions(c1);
		for (Coordinate c: east) {
			assertTrue("Valores Absolutos posiciones East+c1", pos.contains(c.add(c1)));
		}
	}
	
	/* Se comprueba que las posiciones absolutas para la orientación SOUTH a partir de
	 * una Coordinate son correctas.
	 */
	@Test
	public void testGetAbsolutePositionsSouth() {
		Coordinate c1 = new Coordinate(300,700);
		Set<Coordinate> pos = galeon.getAbsolutePositions(c1);
		for (Coordinate c: south)
			assertTrue("Valores Absolutos posiciones South+c1", pos.contains(c.add(c1)));
	}

	/* Se comprueba que las posiciones absolutas para la orientación WEST a partir de
	 * una Coordinate son correctas.
	 */
	@Test
	public void testGetAbsolutePositionsWest() {
		Coordinate c1 = new Coordinate(-11,-11);
		Set<Coordinate> pos = fragata.getAbsolutePositions(c1);
		for (Coordinate c: east) {
				assertTrue("Valores Absolutos posiciones East+c1", pos.contains(c.add(c1)));
		}
	}

	/* Se posiciona varios Ship en una Coordinate.
	 * Se comprueba que sus posiciones absolutas son correctas.
	 */
	@Test
	public void testGetAbsolutePositionsShips() {
		
		Coordinate c1 = new Coordinate(119,-123);
		getAbsolutePositionsShip(c1,goleta,north);
		getAbsolutePositionsShip(c1,galeon,south);
		getAbsolutePositionsShip(c1,fragata,west);
		getAbsolutePositionsShip(c1,bergantin,east);
	}
	
	/* Se dispara a un Ship que todavía no ha sido posicionado. Se comprueba que
	 * hit devuelve false
	 */
	@Test
	public void testHitShipPositionNull() {
		Coordinate c1 = new Coordinate(2,1);
		assertFalse(goleta.hit(c1));  
	}
	
	/* Se posiciona un Ship en una Coordinate y se realizan disparos al agua.
	 * Se comprueba que hit devuelve siempre false
	 */
	@Test
	public void testHitWater() {
		Coordinate c1 = new Coordinate(2,1);
		goleta.setPosition(c1);
		assertFalse(goleta.hit(c1));
		for (int i=3; i<7; i++) {
			for (int j=1; j<6; j++)
			  if ( (i==4) && ((j<2)||(j>4)) ) 
				  assertFalse(goleta.hit(new Coordinate(i,j)));
		}
	}
	
	/* Se posiciona un Ship en una Coordinate, y se realizan primeros disparos a 
	 * las posiciones del Ship y se comprueba que hit devuelve true. Se vuelve a 
	 * disparar a las mismas posiciones y se comprueba que hit ahora devuelve false.
	 */
	@Test
	public void testHitShip() {
		Coordinate c1 = new Coordinate(2,1);
		goleta.setPosition(c1);
		for (int j=2; j<5; j++) {
		   assertTrue(goleta.hit(new Coordinate(4,j)));
		   assertFalse(goleta.hit(new Coordinate(4,j)));
		}
	}

	/* Se comprueba que:
	 * 1- isShotDown() a un Ship sin posicionar devuelve false.
	 * 2- isShotDown() devuelve false tras posicionar un Ship en una Coordinate.
	 * */
	@Test
	public void testIsShotDown1() {
		Coordinate c1 = new Coordinate(2,1);
		assertFalse(bergantin.isShotDown());
		bergantin.setPosition(c1);
		assertFalse(bergantin.isShotDown());  
	}
	
	/* Se comprueba que:
	 * 1- isShotDown() devuelve false tras realizar disparos a todas las posiciones del
	 *    Ship excepto una. 
	 * 2- isShotDown() devuelve true tras disparar a la única posición no dañada.
	 * 
	 */
	@Test
	public void testIsShotDown2() {
		Coordinate c1 = new Coordinate(2,1);
		bergantin.setPosition(c1);
		for (int j=3; j<6; j++) {
		   bergantin.hit(new Coordinate(j,3));
		   if (j!=5) assertFalse(bergantin.isShotDown());
		   else assertTrue(bergantin.isShotDown());
		}
		
	}

	/* Se comprueba que:
	 * 1- isHit en un Ship no posicionado devuelve false.
	 * 2- isHit sobre una Coordinate en una posición fuera
	 *    de un Ship ya posicionado, devuelve false.
	 */
	@Test
	public void testIsHit1() {
		Coordinate c = new Coordinate(2,1);
		//Ship no posicionado
		assertFalse(bergantin.isHit(c));
		bergantin.setPosition(c);
		//Ship posicionado. Coordinate c en agua
		assertFalse(bergantin.isHit(c));
	}
	
	/* Se comprueba que:	
	 * 1- isHit sobre las Coordinates de un Ship devuelve false.
	 * 2- isHit sobre las Coordinates de un Ship devuelve true después 
	 *    de disparar sobre ellas (hit) 
	 *     
	 */
	@Test
	public void testIsHit() {
		Coordinate c = new Coordinate(2,1);
		bergantin.setPosition(c);
		//Preguntamos en ship antes de disparar y despues de disparar
		for (int j=3; j<6; j++) {
		   c = new Coordinate(j,3);
		   assertFalse(bergantin.isHit(c));
		   bergantin.hit(c);
		   assertTrue(bergantin.isHit(c));
		}
	}

	/* Se comprueba que las salidas de los distintos Ships en distintas orientaciones
	 * son correctas
	 */
	@Test
	public void testToString() {
		assertEquals(sNorth,goleta.toString());
		assertEquals(sSouth,galeon.toString());
		assertEquals(sEast,bergantin.toString());
		assertEquals(sWest,fragata.toString());
	}
	
	
	//FUNCIONES DE APOYO
	
	void getAbsolutePositionsShip (Coordinate cpos, Craft ship, List<Coordinate> orient ) {
	   ship.setPosition(cpos);
	   Set<Coordinate> pos = ship.getAbsolutePositions();
	   for (Coordinate c: orient)
		  assertTrue("Valores Absolutos posiciones c1+"+c, pos.contains(c.add(cpos)));
	}
}