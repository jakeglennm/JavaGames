package simplegame;

public class GameBoard {
	private String board[][]; //String that the user(s) sees
	public int boardAvailable[]; //filled from 1-9, used for logic to have player vs. computer
	private String p1;
	private String p2;
	private String winner; //will either be null, p1, or p2
	private boolean pTurn; //oscillates each round

	/*
	 * creates Gameboard
	 * fills boardAvailable array from 1-9
	 */
	public GameBoard() {
		board = new String[3][3];
		boardAvailable = new int[9];
		for(int i = 0; i<9; i++)
		{
			boardAvailable[i] = i+1;
		}
		p1 = "X";
		p2 = "O";
		pTurn = true; //p1 turn = true, p2 turn = false
	}
	
	/*
	 * populates the gameboard(2D board array) from 1-9
	 */
	public void PopulateBoard()
	{
		int k = 1;
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j<3; j++)
			{
				board[i][j] = k + "";
				k++;
			}
		}
	}
	
	/*
	 * based on number entered and player turn, will put an "X" or "O" into the appropriate spot
	 * if the spot already has an "X" or "O", will throw an exception
	 */
	public void PlayerTurn(int num) throws SpaceAlreadyTakenException {
		String s;
		if(num>0&&num<=9)
		{
			s = pTurn ? p1 : p2;
			if(num == 1)
			{
				if(board[0][0]!=p1&&board[0][0]!=p2) board[0][0] = s;
				else throw new SpaceAlreadyTakenException("Space already taken");
				boardAvailable[0] = 0;
			}
			else if(num == 2)
			{
				if(board[0][1]!=p1&&board[0][1]!=p2) board[0][1] = s;
				else throw new SpaceAlreadyTakenException("Space already taken");
				boardAvailable[1] = 0;
			}
			else if(num == 3)
			{
				if(board[0][2]!=p1||board[0][2]!=p2) board[0][2] = s;
				else throw new SpaceAlreadyTakenException("Space already taken");
				boardAvailable[2] = 0;
			}
			else if(num == 4)
			{
				if(board[1][0]!=p1||board[1][0]!=p2) board[1][0] = s;
				else throw new SpaceAlreadyTakenException("Space already taken");
				boardAvailable[3] = 0;
			}
			else if(num == 5)
			{
				if(board[1][1]!=p1||board[1][1]!=p2) board[1][1] = s;
				else throw new SpaceAlreadyTakenException("Space already taken");
				boardAvailable[4] = 0;
			}
			else if(num == 6)
			{
				if(board[1][2]!=p1||board[1][2]!=p2) board[1][2] = s;
				else throw new SpaceAlreadyTakenException("Space already taken");
				boardAvailable[5] = 0;
			}
			else if(num == 7)
			{
				if(board[2][0]!=p1||board[2][0]!=p2) board[2][0] = s;
				else throw new SpaceAlreadyTakenException("Space already taken");
				boardAvailable[6] = 0;
			}
			else if(num == 8)
			{
				if(board[2][1]!=p1||board[2][1]!=p2) board[2][1] = s;
				else throw new SpaceAlreadyTakenException("Space already taken");
				boardAvailable[7] = 0;
			}
			else
			{
				if(board[2][2]!=p1||board[2][2]!=p2) board[2][2] = s;
				else throw new SpaceAlreadyTakenException("Space already taken");
				boardAvailable[8] = 0;
			}
		}
		else
		{
			System.out.println("Invalid number entered");
		}
		pTurn = !pTurn; //flips player turn every round
	}
	
	/*
	 * checks if p1 or p2 has 3 in a row and updates the winner value correspondingly
	 */
	public void CheckWin() { 
		String x = "XXX";
		String o = "OOO";
			if((board[0][0] + board[0][1] + board[0][2]).equals(x)) winner = p1;
			
			else if((board[1][0] + board[1][1] + board[1][2]).equals(x)) winner = p1;
	
			else if((board[2][0] + board[2][1] + board[2][2]).equals(x)) winner = p1;
				
			else if((board[0][0] + board[1][0] + board[2][0]).equals(x)) winner = p1;
				
			else if((board[0][1] + board[1][1] + board[2][1]).equals(x)) winner = p1;	
	
			else if((board[0][2] + board[1][2] + board[2][2]).equals(x)) winner = p1;
							
			else if((board[0][0] + board[1][1] + board[2][2]).equals(x)) winner = p1;
			
			else if((board[2][0] + board[1][1] + board[0][2]).equals(x)) winner = p1;
			
			else if((board[0][0] + board[0][1] + board[0][2]).equals(o)) winner = p2;
			
			else if((board[1][0] + board[1][1] + board[1][2]).equals(o)) winner = p2;
	
			else if((board[2][0] + board[2][1] + board[2][2]).equals(o)) winner = p2;
				
			else if((board[0][0] + board[1][0] + board[2][0]).equals(o)) winner = p2;
				
			else if((board[0][1] + board[1][1] + board[2][1]).equals(o)) winner = p2;	
	
			else if((board[0][2] + board[1][2] + board[2][2]).equals(o)) winner = p2;
							
			else if((board[0][0] + board[1][1] + board[2][2]).equals(o)) winner = p2;
			
			else if((board[2][0] + board[1][1] + board[0][2]).equals(o)) winner = p2;
			}
	
	/*
	 * calls CheckEnd() to update winner value
	 * checks if winner!=null to see if the game has ended
	 */
	public boolean CheckEnd(){
		CheckWin();
		if(winner!=null) return true;
		return false;
	}
	
	/*
	 * returns the gameboard in a tic-tac-toe game format with the values of the 2D array
	 */
	public String getBoard() {
		return "/---|---|---\\\n" + "| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |\n" + "|-----------|\n" + "| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |\n" + "|-----------|\n"+"| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |\n" + "/---|---|---\\"; 
	}
	
	/*
	 * returns the winner
	 */
	public String getWinner() {
		return winner;
	}
	
	/*
	 * returns the value at the position entered
	 */
	public String getPosition(int x, int y) {
		return board[x][y];
	}
	
	/*
	 * returns 1 or 2(player 1 or player 2)
	 */
	public String getPlayerTurn()
	{
		int t = pTurn ? 1 : 2;
		return t + "";
	}
}
