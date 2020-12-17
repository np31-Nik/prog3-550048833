package model.score;

import model.CellStatus;
import model.io.IPlayer;

public class HitScore extends Score<CellStatus>{

	public HitScore(IPlayer player) {
		super(player);
	}

	public void score(CellStatus sc) {
		if(sc==CellStatus.DESTROYED || sc==CellStatus.HIT) {
			super.score++;
		}
	}

}
