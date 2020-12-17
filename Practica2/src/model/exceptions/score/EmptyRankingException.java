package model.exceptions.score;

import model.Coordinate;
import model.exceptions.BattleshipException;

public class EmptyRankingException extends BattleshipException {
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
