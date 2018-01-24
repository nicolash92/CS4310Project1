package com.View;
import com.board.Board;
import com.Exception.invalidException;
import java.util.Scanner;

public class viewNonogram implements viewInterface  {
	private Board board;
	private int row, column;
	private invalidException handler;
	
	
	public viewNonogram(Scanner input) {
		int min = -1;
		int max = 0;
		handler = new invalidException(min, max);
		
		System.out.println("Welcome to Nonogram");
		System.out.print("[-1]: Exit, [0]: Random nonogram board: ");
		int choice = input.nextInt();
		
		if(!(choice >= min && choice <= max)) 
			choice = handler.choice(choice, input);
		
		switch(choice){
		case -1:
			break;
		case 0: 
			randomBoard(input);
			break;
		}
	}
	
	@Override
	public void move(Scanner input) {
		// TODO Auto-generated method stub
		handler = new invalidException(this.row);
		
		System.out.print("Row: ");
		int row = input.nextInt();
		
		if(!(row > this.row && row <= this.row))
			row = handler.range(row, input);
		
		handler = new invalidException(this.column);
		System.out.print("Column: ");
		
		
		int column = input.nextInt();
		
		if(!(column > this.column && column <= this.column))
			column = handler.range(column, input);
		
		board.changeBlock(row - 1, column - 1);
	}

	@Override
	public boolean mainMenu() {
		// TODO Auto-generated method stub
		boolean finish = false;
		
		while(!finish) {
			finish = printBoard();
			move(new Scanner(System.in));
			
			if(finish) 
				System.out.println("Congratulations! You solved nonogram!");
		}
		
		return false;
	}

	@Override
	public void randomBoard(Scanner input) {
		// TODO Auto-generated method stub
		int min = 0;
		int max = 15;
		handler = new invalidException(min, max);
		
		System.out.print("Number of rows (max15): ");
		row = input.nextInt();
		
		if(!(row > min && row <= max))
			row = handler.choice(row, input);
		
		System.out.print("Number of columns (max15):");
		column = input.nextInt();
		
		if(!(column > min && column <= max))
			column = handler.choice(column, input);

		 board = new Board(row, column); 
	}

	@Override
	public boolean printBoard() {
		// TODO Auto-generated method stub
		System.out.println(board.toString());
		System.out.println();
		
		return board.isBoardSolved();
	}

	@Override
	public void solution() {
		// TODO Auto-generated method stub
		
	}

}
