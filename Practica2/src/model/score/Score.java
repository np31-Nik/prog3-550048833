package model.score;

import model.io.IPlayer;

public abstract class Score<T> implements Comparable<Score<T>>{   

	protected int score;
	private IPlayer player;
	
	public Score(IPlayer player) {
		if(player==null) {
			throw new NullPointerException();
		}
		this.player=player;
		score=0;
	}
	
	public String toString() {
		String s = player.toString()+": "+score;
		return s;
	}
	
	public int compareTo(Score<T> other) {
		if(other.score>this.score) {
			return -1;
		}else if(other.score<this.score) {
			return 1;
		}else {
			return player.getName().compareTo(other.player.getName());
		}
	}
	
	public abstract void score (T sc);
}
