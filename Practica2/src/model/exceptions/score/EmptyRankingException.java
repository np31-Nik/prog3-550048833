package model.exceptions.score;

import model.Coordinate;
import model.exceptions.BattleshipException;
/**
 * Excepcion empty ranking exception
 * @author Nikita Polyanskiy P550048833
 *
 */
public class EmptyRankingException extends BattleshipException {
	/**
	 * Constructor
	 */
	public EmptyRankingException () {
		super();
	}
	/**
	 * Metodo getmessage
	 * @return el mensaje
	 */
	public String getMessage() {
		return "ScoreSet vacio";

	}
	
}
