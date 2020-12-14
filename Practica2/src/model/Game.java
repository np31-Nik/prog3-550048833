package model;

import model.exceptions.BattleshipException;
import model.exceptions.CoordinateAlreadyHitException;
import model.exceptions.InvalidCoordinateException;
import model.exceptions.NextToAnotherCraftException;
import model.exceptions.OccupiedCoordinateException;
import model.exceptions.io.BattleshipIOException;
import model.io.IPlayer;
import model.io.IVisualiser;
/**
 * Clase Game
 * @author Nikita Polyanskiy P550048833
 *
 */
public class Game {
/**
 * gameStarted v o f
 */
	private boolean gameStarted;
	/**
	 * Siguiente a disparar
	 */
	private int nextToShoot;
	/**
	 * contador
	 */
	private int shootCounter;
	/**
	 * j1
	 */
	private IPlayer player1;
	/**
	 * j2
	 */
	private IPlayer player2;
	/**
	 * b1
	 */
	private Board board1;
	/**
	 * b2
	 */
	private Board board2;
	/**
	 * Constructor
	 * @param b1 board1
	 * @param b2 board 2
	 * @param p1 player 1
	 * @param p2 player 2
	 */
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
	/**
	 * getplayer1
	 * @return p1
	 */
	public IPlayer getPlayer1() {
		return player1;
		
	}
	/**
	 * getplayer2
	 * @return p2
	 */
	public IPlayer getPlayer2() {
		return player2;
	}
	/**
	 * get last shoot
	 * @return ultimo en disparar
	 */
	public IPlayer getPlayerLastShoot() {
		if(shootCounter==0) {
		return null;	
		}
		if(nextToShoot==1) {
			return player2;
		}else if(nextToShoot==2) {
			return player1;
		}else {
			return null;
		}
		
	}
	/**
	 * getb1
	 * @return board 1
	 */
	public Board getBoard1() {
		return board1;
	}
	/**
	 * getb2
	 * @return board 2
	 */
	public Board getBoard2() {
		return board2;
	}
	/**
	 * start
	 */
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
	/**
	 * game ended
	 * @return v o f
	 */
	public boolean gameEnded() {
		if(gameStarted) {
			if(board1.areAllCraftsDestroyed() || board2.areAllCraftsDestroyed()) {
				return true;
			}
		}
		
		return false;
		
	}
	/**
	 * play next
	 * @return v o f
	 */
	public boolean playNext() {
		Coordinate shoot;
		try {
			if(nextToShoot==1) {
				shoot=player1.nextShoot(board2);
				if(shoot!=null) {
				nextToShoot=2;
				shootCounter++;
				return true;
				}else {
					return false;
				}		
			}else if(nextToShoot==2) {
				
				shoot=player2.nextShoot(board1);
				if(shoot!=null) {
				nextToShoot=1;
				shootCounter++;
				return true;
				}
			}
		} catch (BattleshipIOException | InvalidCoordinateException e) {
			throw new RuntimeException(e);
		} catch (CoordinateAlreadyHitException e) {
			System.out.print("Action by ");
			if(nextToShoot==1) {
				System.out.print(player1.getName());
				System.out.println(" "+e.getMessage());
				nextToShoot=2;
				shootCounter++;
				return true;
			}else {
				System.out.print(player2.getName());
				System.out.println(" "+e.getMessage());
				nextToShoot=1;
				shootCounter++;
				return true;
				
			}
		}
		return false;
	}
	/**
	 * playgame
	 * @param visualiser visual
	 */
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
	/**
	 * metodo tostring
	 * @return el string
	 */
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
		string+=board1.show(false)+"\n";
		string+="==================================\n";
		string+=player2.getName()+"\n";
		string+="==================================\n";
		string+=board2.show(false)+"\n";
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
	
	/**
	 * metodo getscore
	 * @return el score
	 */
	public String getScoreInfo() {
		return null;
		
	}
	
	/**
	 * Metodo gethitscorep1
	 * @return el score del p1
	 */
	//public HitScore getHitScorePlayer1() {
		
	//}
	
	/**
	 * hitscore player 2
	 * @return hitscore player 2
	 */
	//public HitScore getHitScorePlayer2() {
		
	//}
	
	/**
	 * Metodo craftscore p1
	 * @return craftscore p1
	 */
	//public CraftScore getCraftScorePlayer1() {
		
	//}
	
	/**
	 * Metodo craftscore p2
	 * @return craftscore p2
	 */
	//public CraftScore getCraftScorePlayer2() {
		
	//}
}
