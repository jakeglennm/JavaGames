package simplegame;

import java.util.ArrayList;
import java.util.Random;

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
	 * used for 1 player game
	 * makes it more difficult to win
	 * find EASIER way to do this method(switch case, sorting, loops, something more efficient)
	 */
	public void HardComputerLogic() throws SpaceAlreadyTakenException
	{
		//win if computer has 2 in a row
		if((board[0][0] + board[0][1] + board[0][2]).equals("1OO")) PlayerTurn(1); 
		else if((board[0][0] + board[0][1] + board[0][2]).equals("O2O")) PlayerTurn(2);
		else if((board[0][0] + board[0][1] + board[0][2]).equals("OO3")) PlayerTurn(3); 
		else if((board[1][0] + board[1][1] + board[1][2]).equals("4OO")) PlayerTurn(4);
		else if((board[1][0] + board[1][1] + board[1][2]).equals("O5O")) PlayerTurn(5);
		else if((board[1][0] + board[1][1] + board[1][2]).equals("OO6")) PlayerTurn(6);
		else if((board[2][0] + board[2][1] + board[2][2]).equals("7OO")) PlayerTurn(7);
		else if((board[2][0] + board[2][1] + board[2][2]).equals("O8O")) PlayerTurn(8);
		else if((board[2][0] + board[2][1] + board[2][2]).equals("OO9")) PlayerTurn(9);
		else if((board[0][0] + board[1][0] + board[2][0]).equals("1OO")) PlayerTurn(1);
		else if((board[0][0] + board[1][0] + board[2][0]).equals("O4O")) PlayerTurn(4);
		else if((board[0][0] + board[1][0] + board[2][0]).equals("OO7")) PlayerTurn(7);
		else if((board[0][1] + board[1][1] + board[2][1]).equals("2OO")) PlayerTurn(2);
		else if((board[0][1] + board[1][1] + board[2][1]).equals("O5O")) PlayerTurn(5);
		else if((board[0][1] + board[1][1] + board[2][1]).equals("OO8")) PlayerTurn(8);
		else if((board[0][2] + board[1][2] + board[2][2]).equals("3OO")) PlayerTurn(3);
		else if((board[0][2] + board[1][2] + board[2][2]).equals("O6O")) PlayerTurn(6);
		else if((board[0][2] + board[1][2] + board[2][2]).equals("OO9")) PlayerTurn(9);
		else if((board[0][0] + board[1][1] + board[2][2]).equals("1OO")) PlayerTurn(1);
		else if((board[0][0] + board[1][1] + board[2][2]).equals("O5O")) PlayerTurn(5);
		else if((board[0][0] + board[1][1] + board[2][2]).equals("OO9")) PlayerTurn(9);
		else if((board[2][0] + board[1][1] + board[0][2]).equals("7OO")) PlayerTurn(7);
		else if((board[2][0] + board[1][1] + board[0][2]).equals("O5O")) PlayerTurn(5);
		else if((board[2][0] + board[1][1] + board[0][2]).equals("OO3")) PlayerTurn(3);
		
		//left to right logic
		else if((board[0][0] + board[0][1] + board[0][2]).equals("1XX")) PlayerTurn(1); 
		else if((board[0][0] + board[0][1] + board[0][2]).equals("X2X")) PlayerTurn(2);
		else if((board[0][0] + board[0][1] + board[0][2]).equals("XX3")) PlayerTurn(3); 
		else if((board[1][0] + board[1][1] + board[1][2]).equals("4XX")) PlayerTurn(4);
		else if((board[1][0] + board[1][1] + board[1][2]).equals("X5X")) PlayerTurn(5);
		else if((board[1][0] + board[1][1] + board[1][2]).equals("XX6")) PlayerTurn(6);
		else if((board[2][0] + board[2][1] + board[2][2]).equals("7XX")) PlayerTurn(7);
		else if((board[2][0] + board[2][1] + board[2][2]).equals("X8X")) PlayerTurn(8);
		else if((board[2][0] + board[2][1] + board[2][2]).equals("XX9")) PlayerTurn(9);
		
		//up to down logic
		else if((board[0][0] + board[1][0] + board[2][0]).equals("1XX")) PlayerTurn(1);
		else if((board[0][0] + board[1][0] + board[2][0]).equals("X4X")) PlayerTurn(4);
		else if((board[0][0] + board[1][0] + board[2][0]).equals("XX7")) PlayerTurn(7);
		else if((board[0][1] + board[1][1] + board[2][1]).equals("2XX")) PlayerTurn(2);
		else if((board[0][1] + board[1][1] + board[2][1]).equals("X5X")) PlayerTurn(5);
		else if((board[0][1] + board[1][1] + board[2][1]).equals("XX8")) PlayerTurn(8);
		else if((board[0][2] + board[1][2] + board[2][2]).equals("3XX")) PlayerTurn(3);
		else if((board[0][2] + board[1][2] + board[2][2]).equals("X6X")) PlayerTurn(6);
		else if((board[0][2] + board[1][2] + board[2][2]).equals("XX9")) PlayerTurn(9);
		
		//criss-cross logic
		else if((board[0][0] + board[1][1] + board[2][2]).equals("1XX")) PlayerTurn(1);
		else if((board[0][0] + board[1][1] + board[2][2]).equals("X5X")) PlayerTurn(5);
		else if((board[0][0] + board[1][1] + board[2][2]).equals("XX9")) PlayerTurn(9);
		else if((board[2][0] + board[1][1] + board[0][2]).equals("7XX")) PlayerTurn(7);
		else if((board[2][0] + board[1][1] + board[0][2]).equals("X5X")) PlayerTurn(5);
		else if((board[2][0] + board[1][1] + board[0][2]).equals("XX3")) PlayerTurn(3);
		
		//if first round and first move is middle position
		else if((board[1][0] + board[1][1] + board[1][2]).equals("4X6")&&(board[0][0] + board[0][1] + board[0][2]).equals("123")) PlayerTurn(1);
		
		//if first round, always choose middle
		else if((board[1][1]).equals("5")) PlayerTurn(5);
		
		//if start in corner, and then go opposite side(look at notes I made)
		else if((board[0][0] + board[0][2] + board[1][0]).equals("1XX")) PlayerTurn(1);
		else if((board[2][2] + board[0][2] + board[2][1]).equals("9XX")) PlayerTurn(9);
		else if((board[0][0] + board[2][1] + board[2][0]).equals("XX7")) PlayerTurn(7);
		else if((board[0][0] + board[1][2] + board[0][2]).equals("XX3")) PlayerTurn(3);
		else if((board[0][0] + board[0][1] + board[2][0]).equals("1XX")) PlayerTurn(1);
		else if((board[2][2] + board[1][2] + board[2][0]).equals("9XX")) PlayerTurn(9);
		else if((board[0][2] + board[0][1] + board[2][2]).equals("3XX")) PlayerTurn(3);
		else if((board[2][0] + board[1][0] + board[2][2]).equals("7XX")) PlayerTurn(7);
		else if((board[0][0] + board[2][2] + board[1][2]).equals("XX6")) PlayerTurn(6);
		else if((board[2][0] + board[0][2] + board[1][2]).equals("XX6")) PlayerTurn(6);
		
		//if pinching a corner
		else if((board[1][0] + board[0][1]).equals("XX")&&board[0][0].equals("1")) PlayerTurn(1);
		else if((board[1][0] + board[2][1]).equals("XX")&&board[2][0].equals("7")) PlayerTurn(7);
		else if((board[0][1] + board[1][2]).equals("XX")&&board[0][2].equals("3")) PlayerTurn(3);
		else if((board[2][1] + board[1][2]).equals("XX")&&board[2][2].equals("9")) PlayerTurn(9);
		
		//call EasyComputerLogic if no immediate danger of losing(2 in a row or column)
		else
		{
			EasyComputerLogic();
		}
	}
	
	/*
	 * use an arraylist so that the size of the structure changes based on how many spots are filled
	 * this is helpful so I can choose only the numbers that haven't been selected
	 * this is done by changing the value in the array to 0 when the number has been picked so it won't be picked again
	 */
	public void EasyComputerLogic() throws SpaceAlreadyTakenException
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i<9; i++)
		{
			if(boardAvailable[i]>0) arr.add(boardAvailable[i]);
		}
		Random rand = new Random();
		int randNum = rand.nextInt(arr.size());
		PlayerTurn(arr.get(randNum));
	}
	
	/*
	 * calls CheckEnd() to update winner value
	 * checks if winner!=null to see if the game has ended
	 */
	public boolean CheckEnd(){
		boolean check = false;
		CheckWin();
		for(int i = 0; i<9; i++)
		{
			if(boardAvailable[i]>0) check = true;
		}
		if(check == false) 
		{
			return true;
		}
		if(winner!=null)
		{
			return true;
		}
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
