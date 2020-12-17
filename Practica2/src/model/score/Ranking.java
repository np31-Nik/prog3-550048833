package model.score;

import java.util.NoSuchElementException;
import java.util.SortedSet;
import java.util.TreeSet;

import model.exceptions.score.EmptyRankingException;
/**
 * Clase Ranking
 * @author Nikita Polyanskiy P550048833
 *
 * @param <ScoreType> hitscore o craftscore
 */
public class Ranking <ScoreType extends Score<?>>{
	/**
	 * Set de los puntajes
	 */
	private SortedSet<ScoreType> scoreSet;
/**
 * Constructor
 */
	public Ranking() {
		scoreSet = new TreeSet<>();

	}
	/**
	 * Funcion addscore
	 * @param st el tipo de puntaje
	 */
	public void addScore(ScoreType st) {
		scoreSet.add(st);
	}
	/**
	 * Funcion getSortedRanking
	 * @return el set
	 */
	public SortedSet<ScoreType> getSortedRanking(){
		return scoreSet;
		
	}
	/**
	 * funcion getWinner
	 * @return el mayor puntaje
	 * @throws EmptyRankingException en caso de no haber puntaje
	 */
	public ScoreType getWinner() throws EmptyRankingException{
		try {
		return scoreSet.last();
		}catch(NoSuchElementException e) {
			throw new EmptyRankingException();
		}
	}
}
