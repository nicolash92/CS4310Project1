package com.board;

public class NonoBlock {

	//char emptyBlock ='\u25A0';
	//char filledBlock ='\u2B1B';
	char emptyBlock ='-';
	char filledBlock ='*';
	
	//solution for block
	private boolean filled;
	//state of block
	private boolean playerFilled;
	
	public NonoBlock(boolean filled) {
		this.filled=filled;
	}
	
	public void setSolution(boolean filled) {
		this.filled = filled;
	}
	
	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public boolean isPlayerFilled() {
		return playerFilled;
	}
	
	public void flipBlock() {
		playerFilled =! playerFilled;
	}
	
	public boolean isCorrect() {
		return this.isFilled()==this.isPlayerFilled();
	}

	public String toString() {
		return ""+(playerFilled?this.filledBlock:this.emptyBlock);
	}
	
	public String solution() {
		return ""+(filled?this.filledBlock:this.emptyBlock);
	}
}
