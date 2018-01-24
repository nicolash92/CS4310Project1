package com.View;
import java.util.Scanner;


public interface viewInterface {
		
	//Inserting X and Y values
	public void move(Scanner input);
	
	//Creates and random board for which game is selected
	public void randomBoard(Scanner input);
	
	//Console for user
	public boolean mainMenu();
	
	public boolean printBoard();
	
	public void solution();
	
}
