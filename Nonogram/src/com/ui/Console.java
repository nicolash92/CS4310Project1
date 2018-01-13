package com.ui;

import java.util.Scanner;

public class Console {

	public static void main(String[] args) {
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
	}

}
