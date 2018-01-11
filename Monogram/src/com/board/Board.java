package com.board;

public class Board {
	private MonoBlock[][] board;

	//generate a random monogram of a certain width and hight
	public Board(int width, int hight) {
		board = new MonoBlock[width][hight];
		
		for(int i=0;i<board.length; i++) {
			for(int j=0;j<board[i].length; j++) {
				board[i][j]= new MonoBlock(false);
			}
		}
	}
	
	public boolean isSolved() {
		for(int i=0;i<board.length; i++) {
			for(int j=0;j<board[i].length; j++) {
				if(board[i][j].isCorrect()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean changeBlock(int x, int y) {
		if((x<0)||(y<0)||(board.length>x)||(board.length>y))
			return false;
		
		board[x][y].flipBlock();
		return true;
	}
	

}
