package com.View;
import java.util.Scanner;
import com.Exception.invalidException;


public class viewConsole {
	private invalidException handler; 
	
	public int viewChoice(Scanner input){
		int choice = 0;
		int min = -1;
		int max = 0;
		handler = new invalidException(min, max);
		
		System.out.println("Choose what to do next? ");
		System.out.print("[-1]: Quite, [0]: Display games: ");	
		choice = input.nextInt();
			
		if(!(choice >= min && choice <= max)) 
			choice = handler.choice(choice, input);
		
		return choice;
	}
	
	
	public void viewGames(Scanner input) {
		int choice = -1;
		int min = -1;
		int max = 1;
		handler = new invalidException(min, max);
		
		
		System.out.println("Games");
		System.out.print("[-1]: Quit, [0]: Nonogram, [1]: Sudoku: ");
		choice = input.nextInt();
		
		if(!(choice >= min && choice <= max)) 
			choice = handler.choice(choice, input);
		
		switch(choice){
		case 0:
			viewNonogram nonogram = new viewNonogram(input);
			nonogram.mainMenu();
			break;
			
		case 1:
			viewSudoku sudoku = new viewSudoku(input);
			break;
		}
		
	}
	
	public boolean rangeFinder(int num, int min, int max) {
		if(num >= min && num <= max)
			return true;
		return false;
	}
}
