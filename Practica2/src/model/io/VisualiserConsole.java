package model.io;

import model.Game;

public class VisualiserConsole implements IVisualiser {
	private Game game;
	
	public VisualiserConsole(Game g) {
		game=g;
	}
	public void show() {
		System.out.println(game.toString());
	}

	public void close() {
		
	}

}
