package com.ui;

public class Console {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu console = new Menu();
		
		boolean finished = false;
		
		do {
			finished = console.move();
		}while (!finished); 
		
	}

}
