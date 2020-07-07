package simplegame;

public class SpaceAlreadyTakenException extends Exception {

	/*
	 * exception thrown when the space in the tic tac toe board has already been taken
	 */
	public SpaceAlreadyTakenException(String message)
	{
		super(message);
	}
}
