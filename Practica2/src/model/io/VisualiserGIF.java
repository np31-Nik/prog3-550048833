package model.io;

import java.awt.Color;

import model.Game;
import model.exceptions.io.BattleshipIOException;
import model.io.gif.AnimatedGIF;
import model.io.gif.FrameGIF;
/**
 * Clase VisualiserGIF
 * @author Nikita Polyanskiy P550048833
 *
 */
public class VisualiserGIF implements IVisualiser{
/**
 * game
 */
	private Game game;
	/**
	 * Constructor
	 * @param g el game
	 */
	public VisualiserGIF(Game g) {
		if(g==null) {
			throw new NullPointerException("Arg nulo");
		}
		game=g;
	}
	/**
	 * Metodo show
	 */
	public void show() {
		String b1=game.getBoard1().show(false);
		String b2=game.getBoard2().show(false);
		char[] columns;
		String[] rows;	
		
		rows=b1.split("\\s+");
		FrameGIF frame1= new FrameGIF(rows[0].length(),rows.length*2+1);
		FrameGIF frame2= new FrameGIF(rows[0].length(),rows.length*2);
		try {
			for(int j=0;j<rows.length;j++) {
				columns=rows[j].toCharArray();
				for(int i=0;i<columns.length;i++) {
					if(columns[j]==game.getBoard1().NOTSEEN_SYMBOL) {
						frame1.printSquare(i,j,Color.LIGHT_GRAY);
					}else if(columns[j]==game.getBoard1().WATER_SYMBOL) {
						frame1.printSquare(i,j,Color.BLUE);
					}else if(columns[j]==game.getBoard1().HIT_SYMBOL) {
						frame1.printSquare(i, j, Color.RED);
					}else if(columns[j]==game.getBoard1().Board_SEPARATOR) {
						frame1.printSquare(i, j, Color.ORANGE);
					}
				}
			}
			for(int i=0;i<rows[0].length();i++) {
				frame1.printSquare(i,rows.length*2+1,Color.DARK_GRAY);
			}
			
			rows= new String[0];
			columns=new char[0];
			rows=b2.split("\\s+");
			
			for(int j=0;j<rows.length;j++) {
				columns=rows[j].toCharArray();
				for(int i=0;i<columns.length;i++) {
					if(columns[j]==game.getBoard1().NOTSEEN_SYMBOL) {
						frame1.printSquare(i,j,Color.LIGHT_GRAY);
					}else if(columns[j]==game.getBoard1().WATER_SYMBOL) {
						frame1.printSquare(i,j,Color.BLUE);
					}else if(columns[j]==game.getBoard1().HIT_SYMBOL) {
						frame1.printSquare(i, j, Color.RED);
					}else if(columns[j]==game.getBoard1().Board_SEPARATOR) {
						frame1.printSquare(i, j, Color.ORANGE);
					}
				}
			}
			
			AnimatedGIF agif=null;
			agif.addFrame(frame1);
			agif.addFrame(frame2);
			
		}catch(BattleshipIOException e) {
			throw new RuntimeException(e);
		}
	}
		
/**
 * Metodo close
 */
	public void close() {
		
	}

}
