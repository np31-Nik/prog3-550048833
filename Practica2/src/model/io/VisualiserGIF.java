package model.io;

import java.awt.Color;
import java.io.File;

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
	
	private AnimatedGIF agif = new AnimatedGIF();
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

		rows=b1.split("\\r?\\n");
		try {
			FrameGIF frame1= new FrameGIF(rows[0].length(),game.getBoard1().getSize()*2+1);

			for(int j=0;j<rows.length;j++) {
				columns=rows[j].toCharArray();
				for(int i=0;i<rows[j].length();i++) {
					if(rows[j].charAt(i)==game.getBoard1().NOTSEEN_SYMBOL) {
						frame1.printSquare(i,j,Color.LIGHT_GRAY);
					}else if(rows[j].charAt(i)==game.getBoard1().WATER_SYMBOL) {
						frame1.printSquare(i,j,Color.BLUE);
					}else if(rows[j].charAt(i)==game.getBoard1().HIT_SYMBOL) {
						frame1.printSquare(i, j, Color.RED);
					}else if(rows[j].charAt(i)==game.getBoard1().Board_SEPARATOR) {
						frame1.printSquare(i, j, Color.ORANGE);
					}else {
						frame1.printSquare(i, j, Color.RED);
					}
				}
			}
			for(int i=0;i<rows[0].length();i++) {
				frame1.printSquare(i,rows.length,Color.DARK_GRAY);
			}
			
			rows= new String[0];
			columns=new char[0];
			rows=b2.split("\\r?\\n");
			for(int j=0;j<rows.length;j++) {
				columns=rows[j].toCharArray();
				for(int i=0;i<rows[j].length();i++) {
					if(rows[j].charAt(i)==game.getBoard2().Board_SEPARATOR) {
						frame1.printSquare(i, rows.length+1+j, Color.ORANGE);
					}else if(rows[j].charAt(i)==game.getBoard2().NOTSEEN_SYMBOL) {
						frame1.printSquare(i,rows.length+1+j,Color.LIGHT_GRAY);
					}else if(rows[j].charAt(i)==game.getBoard2().WATER_SYMBOL) {
						frame1.printSquare(i,rows.length+1+j,Color.BLUE);
					}else if(rows[j].charAt(i)==game.getBoard2().HIT_SYMBOL) {
						frame1.printSquare(i, rows.length+1+j, Color.RED);
					}else {
						frame1.printSquare(i, rows.length+1+j, Color.RED);
					}
				}
			}
			
			
			agif.addFrame(frame1);
			
		}catch(BattleshipIOException e) {
			throw new RuntimeException(e);
		}
	}
		
/**
 * Metodo close
 */
	public void close() {
		
		try {
			agif.saveFile(new File("files/output.gif"));
		} catch (BattleshipIOException e) {
			throw new RuntimeException(e);
		}

	}

}
