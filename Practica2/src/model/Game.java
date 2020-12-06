package model;

import model.exceptions.BattleshipException;
import model.exceptions.CoordinateAlreadyHitException;
import model.exceptions.InvalidCoordinateException;
import model.exceptions.NextToAnotherCraftException;
import model.exceptions.OccupiedCoordinateException;
import model.exceptions.io.BattleshipIOException;
import model.io.IPlayer;
import model.io.IVisualiser;

public class Game {

	private boolean gameStarted;
	private int nextToShoot;
	private int shootCounter;
	private IPlayer player1;
	private IPlayer player2;
	private Board board1;
	private Board board2;
	
	public Game(Board b1, Board b2, IPlayer p1, IPlayer p2) {
		if(p1==null || p2==null || b1==null || b2==null) {
			throw new NullPointerException("Parametros nulos");
		}
		
		player1=p1;
		player2=p2;
		board1=b1;
		board2=b2;
		gameStarted=false;
		
	}
	
	public IPlayer getPlayer1() {
		return player1;
		
	}
	
	public IPlayer getPlayer2() {
		return player2;
	}
	
	public IPlayer getPlayerLastShoot() {
		if(nextToShoot==1) {
			return player2;
		}else if(nextToShoot==2) {
			return player1;
		}else {
			return null;
		}
		
	}
	
	public Board getBoard1() {
		return board1;
	}
	
	public Board getBoard2() {
		return board2;
	}
	
	public void start() {
		
		try {
			player1.putCrafts(board1);
			player2.putCrafts(board2);
			gameStarted=true;
			shootCounter=0;
			nextToShoot=1;

		} catch (InvalidCoordinateException | OccupiedCoordinateException | NextToAnotherCraftException
				| BattleshipIOException e) {
			throw new RuntimeException(e);
		}
		
		
		
	}
	
	public boolean gameEnded() {
		if(gameStarted) {
			if(board1.areAllCraftsDestroyed() || board2.areAllCraftsDestroyed()) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public boolean playNext() {
		
			
		try {
			if(nextToShoot==1) {
				player1.nextShoot(board2);
				nextToShoot=2;
				shootCounter++;
				return true;
			
			}else if(nextToShoot==2) {
				player2.nextShoot(board1);
				nextToShoot=1;
				shootCounter++;
				return true;
			}
		} catch (BattleshipIOException | InvalidCoordinateException e) {
			throw new RuntimeException(e);
		} catch (CoordinateAlreadyHitException e) {
			System.out.print("Action by ");
			if(nextToShoot==1) {
				System.out.print(player1.getName());
				System.out.println(" "+e.getMessage());
			}else {
				System.out.print(player2.getName());
				System.out.println(" "+e.getMessage());
			}
		}
		return false;
	}
	
	public void playGame(IVisualiser visualiser) {
		boolean next=true;
		start();
		visualiser.show();
		do {
			next=playNext();
			if(next)
				visualiser.show();
		}while(!gameEnded() && next);
		visualiser.close();
	}
	
	public String toString() {
		String string="";
		if(!gameStarted) {
			string+="=== GAME NOT STARTED ===\n";
		}else if(gameStarted && gameEnded()) {
			string+="=== GAME ENDED ===\n";
		}else if(gameStarted && !gameEnded()) {
			string+="=== ONGOING GAME ===\n";
		}
		
		string+="==================================\n";
		string+=player1.getName()+"\n";
		string+="==================================\n";
		string+=board1.show(true)+"\n";
		string+="==================================\n";
		string+=player2.getName()+"\n";
		string+="==================================\n";
		string+=board2.show(true)+"\n";
		string+="==================================\n";
		string+="Number of shots: "+shootCounter;
		
		if(gameStarted && gameEnded()) {
			string+="\n";
			if(board1.areAllCraftsDestroyed()) {
				string+=player2.getName()+" wins";
			}else if(board2.areAllCraftsDestroyed()) {
				string+=player1.getName()+" wins";
			}
		}
		
		return string;
		
	}
}
