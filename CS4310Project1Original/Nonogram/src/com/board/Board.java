package com.board;

import java.util.Random;

public class Board {
	private NonoBlock[][] board;

	//generate a random nonogram of a certain number of rows and columns
	public Board(int rows, int columns) {
		board = new NonoBlock[rows][columns];
		Random r= new Random(System.currentTimeMillis());
		for(int i=0;i<board.length; i++) {
			for(int j=0;j<board[i].length; j++) {
				board[i][j]= new NonoBlock(r.nextBoolean());
			}
		}
	}
	
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
	public boolean changeBlock(int x, int y) {
		if((x<0)||(y<0)||(board.length<=x)||(board[x].length<=y))
			return false;
		
		board[x][y].flipBlock();
		return true;
	}

	public String showSolution() {
		int rowHintsLength = getRowHintsLength();
		String str= getColumnsHints(rowHintsLength);
		for(int i=0;i<board.length; i++) {
			str += padToSize((getRowHints(i).trim().length()==0?"0":getRowHints(i)),rowHintsLength);
			for(int j=0;j<board[i].length; j++) {
				str+=(board[i][j]).solution();
			}
			str+="\n";
		}
		return str;
	}

	@Override
	public String toString() {
		int rowHintsLength = getRowHintsLength();
		String str= getColumnsHints(rowHintsLength);
		for(int i=0;i<board.length; i++) {
			str += padToSize((getRowHints(i).trim().length()==0?"0":getRowHints(i)),rowHintsLength);
			for(int j=0;j<board[i].length; j++) {
				str+=(board[i][j]).toString();
			}
			str+="\n";
		}
		return str;
	}
	
	private String padToSize(String rowHints, int rowHintsLength) {
		String temp = "";
		while((temp.length()+rowHints.length())<rowHintsLength)
			temp+=" ";
		return temp+rowHints;
	}


	private String getColumnsHints(int rowHintsLength) {
		String padding = padToSize("",rowHintsLength);
		String str="";
		String strLine="";
		for(int i=0;i<board[0].length; i++) {
			for(int j=0;j<board.length/2; j++) {
				String[] tempArr = getColumnHints(i).split(" ");
				if(j<tempArr.length)
					strLine += tempArr[j]+" ";
			}
			if(strLine.trim().length()==0)
				strLine="0";
			str+=(strLine+"\n");
			strLine="";
		}

		String[] colsStr = str.split("\n");
		str="";
		for(int j=0; j<board.length+1; j++) {
			strLine=padding;
			for(int i=0; i<colsStr.length; i++) {
				String[] temp=colsStr[i].split(" ");
				if(j<temp.length)
					strLine+= temp[j];
				else
					strLine+=" ";
			}
			strLine+="\n";
			if(strLine.trim().length()>0)
				str+=strLine;
		}
		return str;
	}


	private int getRowHintsLength() {
		int length =1;
		int temp;
		for(int i=0;i<board.length; i++) {
			temp= getRowHints(i).length();
			if(length<temp)
				length=temp;
		}
		return length;
	}

	

}
