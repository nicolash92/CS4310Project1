package com.board;

import java.util.Random;

public class Board {
	private NonoBlock[][] board;

	//generate a random nonogram of a certain width and hight
	public Board(int hight, int width) {
		board = new NonoBlock[width][hight];
		Random r= new Random(System.currentTimeMillis());
		for(int i=0;i<board.length; i++) {
			for(int j=0;j<board[i].length; j++) {
				board[i][j]= new NonoBlock(r.nextBoolean());
			}
		}
	}
	
	
	//create a board from String
/*	public Board(String boardName) {
		
	}
*/
	
	// start with a pre-made board
	public Board(NonoBlock[][] board) {
		this.board = board;
	}

	// returns the hint for filled blocks in a column as a string
	public String getColumnHints(int column) {
		int counter = 0;
		String hint = "";
		for(int i=0;i<this.board.length;i++) {
			if(this.board[i][column].isFilled()) {
				counter++;
			}else {
				if(counter>0)
					hint+=counter+" ";
				counter=0;
			}	
		}
		if(counter>0)
			hint+=counter+" ";
		return hint.trim();
	}
	
	// returns the hint for filled blocks in a row as a string
	public String getRowHints(int row) {
		int counter = 0;
		String hint = "";
		for(int i=0;i<this.board[row].length;i++) {
			if(this.board[row][i].isFilled()) {
				counter++;
			}else {
				if(counter>0)
					hint+=counter+" ";
				counter=0;
			}	
		}
		if(counter>0)
			hint+=counter+" ";
		return hint.trim();
	}
	
	//returns true if solved and false otherwise
	public boolean isBoardSolved() {
		for(int i=0;i<board.length; i++) {
			for(int j=0;j<board[i].length; j++) {
				if(!(board[i][j].isCorrect())) return false; //if there is an incorrect block then the Nonogram isn't solved
			}
		}
		return true;
	}

	//returns true if square is solved and false otherwise
	public boolean isBlockSolved(int x, int y) {
		return board[x][y].isCorrect();
	}
	
	//flips the block between filled and not filled
	public boolean changeBlock(int y, int x) {
		if((x<0)||(y<0)||(board.length>x)||(board[x].length>y))
			return false;
		
		board[x][y].flipBlock();
		return true;
	}
	

}
