package model.exceptions.io;
import model.exceptions.BattleshipException;
/**
 * Excepcion coordinate
 * @author Nikita Polyanskiy P550048833
 */
public class BattleshipIOException extends BattleshipException{
/**
 * mensaje
 */
	private String message;
	/**
	 * Constructor
	 * @param m msj
	 */
	public BattleshipIOException(String m) {
		message=m;
	}
	/**
	 * getmsj
	 * @return el mensaje
	 */
	public String getMessage() {
		return message;		
	}
}
