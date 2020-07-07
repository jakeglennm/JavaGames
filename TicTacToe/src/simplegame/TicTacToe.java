package simplegame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) throws SpaceAlreadyTakenException {
		/*
		 * Prompt user to enter 1 or 2 for multiplayer or against computer
		 */
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Welcome to Tic-Tac-Toe!\n");
		System.out.println("For 2-Player(enter 2)");
		System.out.println("For 1-Player(enter 1)\n");
		int gameType = scan1.nextInt();
		
		/*
		 * if user enters 2
		 */
		if(gameType == 2) 
		{
			int round = 1;
			GameBoard g1 = new GameBoard();
			g1.PopulateBoard(); // fill board with numbers 1-9
			while(true)
			{
				System.out.println("Round " + round);
				System.out.println(g1.getBoard()); //prints out the board each round
				Scanner scan = new Scanner(System.in);
				System.out.println("Player " + g1.getPlayerTurn() + ", Enter the number you want to place your mark");
				g1.PlayerTurn(scan.nextInt()); //enter the space you want to put an "X" or "O"
				if(g1.CheckEnd()) //checks if one of the players has 3 in a row
				{
					g1.CheckWin(); //update the winner to p1 or p2
					if(g1.getWinner()=="X")
					{
						System.out.println(g1.getBoard());
						System.out.println("Player 1 Wins!");
						break;
					}
					else if(g1.getWinner()=="O")
					{
						System.out.println(g1.getBoard());
						System.out.println("Player 2 Wins!");
						break;
					}
				}
				if(round==9)//if it reaches round 9 without a winner, it will be a draw
				{
					System.out.println(g1.getBoard());
					System.out.println("It's a draw.");
					break;
				}
				round++; //update after each round
			}
		}
		
		/*
		 * if user enters 1
		 */
		else if(gameType == 1)
		{
			int round = 1;
			GameBoard g1 = new GameBoard();
			g1.PopulateBoard(); // fill board with numbers 1-9
			while(true)
			{
				System.out.println("Round " + round);
				System.out.println(g1.getBoard());
				Scanner scan = new Scanner(System.in);
				
				/*
				 * only prompt to user when it's his/her turn, not on computer's turn
				 */
				if(g1.getPlayerTurn().equals("1")) System.out.println("Player " + g1.getPlayerTurn() + ", Enter the number you want to place your mark");
				if(g1.getPlayerTurn().equals("1")) g1.PlayerTurn(scan.nextInt());
				
				///////////////////////////////////////
				/*
				 * use an arraylist so that the size of the structure changes based on how many spots are filled
				 * this is helpful so I can choose only the numbers that haven't been selected
				 * this is done by changing the value in the array to 0 when the number has been picked so it won't be picked again
				 * PROBABLY AN EASIER WAY TO DO THIS LOL, BUT THIS WORKS
				 */
				else
				{
					ArrayList<Integer> arr = new ArrayList<Integer>();
					for(int i = 0; i<9; i++)
					{
						if(g1.boardAvailable[i]>0) arr.add(g1.boardAvailable[i]);
					}
					Random rand = new Random();
					int randNum = rand.nextInt(arr.size());
					g1.PlayerTurn(arr.get(randNum));
				}
				////////////////////////////////////////
				
				if(g1.CheckEnd()) //check if user or computer has 3 in a row
				{
					g1.CheckWin(); // update winner value to computer or user(p1)
					if(g1.getWinner()=="X")
					{
						System.out.println(g1.getBoard());
						System.out.println("Player 1 Wins!");
						break;
					}
					else if(g1.getWinner()=="O")
					{
						System.out.println(g1.getBoard());
						System.out.println("Computer Wins!");
						break;
					}
				}
				if(round==9) //if it reaches round 9 without a winner, it will be a draw
				{
					System.out.println(g1.getBoard());
					System.out.println("It's a draw.");
					break;
				}
				round++; //update after each round
		}
	}
		/*
		 * if user enters anything but 1 or 2
		 */
		else
		{
			System.out.println("Restart game and enter 1 or 2");
		}
}
}
