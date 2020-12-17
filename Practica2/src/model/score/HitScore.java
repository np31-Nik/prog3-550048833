package model.score;

import model.CellStatus;
import model.io.IPlayer;
/**
 * Clase HitScore
 * @author Nikita Polyanskiy P550048833
 *
 */
public class HitScore extends Score<CellStatus>{
/**
 * Constructor
 * @param player el jugador
 */
	public HitScore(IPlayer player) {
		super(player);
	}

	/**
	 * Funcion score
	 * @param sc el estado de celda
	 */
	public void score(CellStatus sc) {
		if(sc==CellStatus.DESTROYED || sc==CellStatus.HIT) {
			super.score++;
		}
	}

}
