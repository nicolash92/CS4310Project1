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
	
	//create a board from file or String
/*	public Board(String boardName) {
		
	}
*/

	public String getLineHints(int line) {
		for(int i=0;i<this.board[line].length;i++) {
			
		}
		return "";
	}
	
	//returns true if solved and false otherwise
	public boolean isSolved() {
		for(int i=0;i<board.length; i++) {
			for(int j=0;j<board[i].length; j++) {
				if(!(board[i][j].isCorrect())) {
					return false;
				}
			}
		}
		return true;
	}

	//returns true if square is solved and false otherwise
	public boolean isBlockSolved(int y, int x) {
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
