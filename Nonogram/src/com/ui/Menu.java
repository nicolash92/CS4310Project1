package com.ui;

import java.util.Scanner;
import com.board.Board;

public class Menu {

		private Board board; 
		
		//Constructor for menu
		public Menu() {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Welcome to Nonogram"); 
			System.out.println("[1] New Game"); 
			System.out.println("[2] Constructor"); 
			
			System.out.print("Insert Selection: ");
			selection(sc.nextInt());	
			
			sc.close();
		}
		
		
		//Selection on menu
		public void selection(int select) {
			System.out.println();
			
			switch(select) {
			case 1:
				userLoadGame();
				break;
				
			case 2:
				constructor();
				break;
				
			default:
				System.out.println("The selection is invalid");	
			}
		}
		
		//Constructor method is used for user to create their own nonogram
		public void constructor() {
			int width, height;
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Level Constructor");
			
			System.out.print("Width: ");
			width = sc.nextInt();
			
			System.out.print("Height: ");
			height = sc.nextInt();
			
			board = new Board(width, height);
			
			System.out.println(board.toString());	//Printing out the board
			sc.close();
		}
		
		//userLoadGame method let the user select and upload a already existing game
		public void userLoadGame() {
			//text file 
			
			System.out.println("Select Level");
		}
		
		
		//user is able to make moves on the board
		public boolean move(){
			Scanner input = new Scanner(System.in);
			
			System.out.print("X Coordinates: ");
			int x = input.nextInt();
			
			System.out.print("Y Coordinates: ");
			int y = input.nextInt();
			
			board.changeBlock(y, x);
			System.out.println(board.toString());
			
			input.close();
			
			return board.isBoardSolved();
		}
			
	}


