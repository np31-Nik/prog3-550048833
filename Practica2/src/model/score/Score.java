package model.score;

import model.io.IPlayer;
/**
 * Clase Score
 * @author Nikita Polyanskiy P550048833
 *
 * @param <T> tipo de score
 */
public abstract class Score<T> implements Comparable<Score<T>>{   
/**
 * Valor de puntaje
 */
	protected int score;
	/**
	 * Jugador
	 */
	private IPlayer player;
	/**
	 * Constructor
	 * @param player jugador
	 */
	public Score(IPlayer player) {
		if(player==null) {
			throw new NullPointerException();
		}
		this.player=player;
		score=0;
	}
	/**
	 * fncion toString
	 * @return s nombre del jugador + puntaje
	 */
	public String toString() {
		String s = player.getName()+": "+score;
		return s;
	}
	
	/**
	 * funcion compareTo
	 * @param other el otro puntaje
	 * @return -1 si menor, 1 si mayor
	 */
	public int compareTo(Score<T> other) {
		if(other.score>this.score) {
			return -1;
		}else if(other.score<this.score) {
			return 1;
		}else {
			return player.getName().compareTo(other.player.getName());
		}
	}
	/**
	 * Funcion abstracta score, depende para el tipo
	 * @param sc score
	 */
	public abstract void score (T sc);
}
