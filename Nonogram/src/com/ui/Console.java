package com.ui;

import java.util.Scanner;
import com.View.viewConsole;
public class Console {

	public static void main(String[] args) {
	/*
		Scanner input = new Scanner(System.in);
		Menu menu = new Menu();
		boolean finished;
		
		while(true) {
			finished = false;
			try {
				if(menu.MainMenu(input)) break;
			} catch (Exception e) {
				System.out.println("Unsupported input. try again.");
				input.nextLine();
				continue;
			}
			
			while(!finished) {
				finished = menu.printBoard();
				if(!finished)
					try {
						menu.move(input);
					} catch (Exception e) {
						if(input.nextLine().trim().toLowerCase().equals("help"))
							menu.printSolution();
						else
							System.out.println("Unsupported input. try again.");
						continue;
					}
			}
			
			if(finished) {
				System.out.println("____________________________________");
				System.out.println("Congratulations! you solved the Nonogram.");
				System.out.println("____________________________________");
			}
			
		}
	*/
		Scanner input = new Scanner(System.in);
		viewConsole view = new viewConsole();
		boolean done = false;
		
		while(!done) {
			int choice = view.viewChoice(input);
			
			switch(choice){
			case -1:
				//Quit
				done = true;
				break;
				
			case 0:
				view.viewGames(input);
			}
		}
		
		input.close();
		
	}
	

}
