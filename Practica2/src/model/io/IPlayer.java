package model.io;

import model.Board;
import model.CellStatus;
import model.Coordinate;
import model.exceptions.BattleshipException;
import model.exceptions.CoordinateAlreadyHitException;
import model.exceptions.InvalidCoordinateException;
import model.exceptions.NextToAnotherCraftException;
import model.exceptions.OccupiedCoordinateException;
import model.exceptions.io.BattleshipIOException;
/**
 * Interfaz IPlayer
 * @author Nikita Polyanskiy P550048833
 *
 */
public interface IPlayer {
	/**
	 * getname
	 * @return el nombre
	 */
	public String getName();
	/**
	 * Metodo putcrafts
	 * @param b el board
	 * @throws InvalidCoordinateException coord
	 * @throws OccupiedCoordinateException occup
	 * @throws NextToAnotherCraftException next
	 * @throws BattleshipIOException io
	 */
	public void putCrafts(Board b) throws InvalidCoordinateException, OccupiedCoordinateException, NextToAnotherCraftException, BattleshipIOException;
	/**
	 * Metodo next shoot
	 * @param b el board
	 * @return la coordenada
	 * @throws BattleshipIOException io
	 * @throws InvalidCoordinateException coord
	 * @throws CoordinateAlreadyHitException alreadyhit
	 */
	public Coordinate nextShoot(Board b) throws BattleshipIOException, InvalidCoordinateException, CoordinateAlreadyHitException;
	
	public CellStatus getLastShotStatus();
}
