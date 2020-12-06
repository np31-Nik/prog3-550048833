package model.io;

import model.Game;
/**
 * Clase visualiserconsole
 * @author Nikita Polyanskiy P550048833
 *
 */
public class VisualiserConsole implements IVisualiser {
	/**
	 * Game
	 */
	private Game game;
	/**
	 * Constructor
	 * @param g el game
	 */
	public VisualiserConsole(Game g) {
		game=g;
	}
	/**
	 * Metodo show
	 */
	public void show() {
		System.out.println(game.toString());
	}
/**
 * Metodo close
 */
	public void close() {
		
	}

}
