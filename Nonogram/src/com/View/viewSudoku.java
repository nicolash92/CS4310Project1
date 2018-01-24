package com.View;
import java.util.Scanner;
import com.board.Board;

public class viewSudoku implements viewInterface {
	private Board board;
	
	public viewSudoku(Scanner input) {
		System.out.println("Welcome to Sudoku");
		System.out.print("[-1}: Exit, [0] Start Game: ");
		int choice = input.nextInt();
		
		switch(choice){
		case -1:
			break;
		case 0: 
			randomBoard(input);
			break;
		}
	}

	@Override
	public boolean mainMenu() {
		// TODO Auto-generated method stub
		boolean finish = false;
		
		while(!finish) {
			finish = printBoard();
			move(new Scanner(System.in));
			
			if(finish)
				System.out.println("Congratulations! You solved sudoku!");
		}
		return false;
	}

	@Override
	public void randomBoard(Scanner input) {
		// TODO Auto-generated method stub
		int size = 9;
		board = new Board(size, size);
	}

	@Override
	public void move(Scanner input) {
		// TODO Auto-generated method stub
		System.out.print("Row: ");
		int row = input.nextInt();
		
		System.out.print("Column: ");
		int column = input.nextInt();
		
		board.changeBlock(row - 1, column - 1);
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
