package com.ui;

import java.util.Scanner;
import com.board.Board;

public class Menu {

		private Board board; 
		
		//Constructor for menu
		public boolean MainMenu(Scanner input)throws Exception {
			
			System.out.println("Welcome to Nonogram"); 
			//System.out.println("[1] Play Pre-built Nonogram"); 
			System.out.println("[2] Generate A Random Board"); 
			System.out.println("[3] Exit"); 
			System.out.println(); 
			System.out.print("Insert Selection: ");
			
			int select = input.nextInt();	
			
			switch(select) {
			/*	not yet implemented
			 * case 1:
				//userLoadGame();
				break;
			 */
			case 2:
				constructor(input);
				break;
				
			case 3:
				System.out.println("goodbye!");
				return true;
				
			default:
				System.out.println("The selection is invalid");
				System.out.println();
				MainMenu(input);
			}
			return false;
		}
		
		//Constructor method is used for user to create their own nonogram
		public void constructor(Scanner input)throws Exception {
			int width, height;
			
			System.out.println("Level Constructor");
			
			System.out.print("Enter the number of rows(Max 15): ");
			width = input.nextInt();
			
			System.out.print("Enter the number of columns(Max 15): ");
			height = input.nextInt();
			
			
			if(width<1)width=1;
			if(width>15)width=15;
			if(height<1)height=1;
			if(height>15)height=15;
			
			board = new Board(width, height);
		}
		
		/*
		 *
		//userLoadGame method let the user select and upload a already existing game
		public void userLoadGame() {
			//text file 
			
			System.out.println("Select Level");
		}
		*/
		
		//user is able to make moves on the board
		public void move(Scanner input)throws Exception{

			System.out.println("You can type'HELP' at any time if you are stuck ");
			System.out.print("enter row number: ");
			int x = input.nextInt();
			
			System.out.print("enter Column number: ");
			int y = input.nextInt();
			
			board.changeBlock(x-1, y-1);
		}

		public boolean printBoard() {
			System.out.println(board.toString());
			System.out.println();
			
			return board.isBoardSolved();
		}
		
		public void printSolution() {
			System.out.println("Solution: ");
			System.out.println(board.showSolution());
			System.out.println();
		}
			
	}


