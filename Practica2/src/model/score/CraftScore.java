package model.score;

import model.CellStatus;
import model.Craft;
import model.io.IPlayer;
/**
 * Funcion CraftScore
 * @author Nikita Polyanskiy P550048833
 *
 */
public class CraftScore extends Score<Craft> {
/**
 * Constructor
 * @param player el jugador
 */
	public CraftScore(IPlayer player) {
		super(player);
	}
/**
 * Funcion score
 * @param sc el barco
 */
	public void score(Craft sc) {
		super.score+=sc.getValue();
	}

}
