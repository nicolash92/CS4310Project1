package com.Exception;
import java.util.Scanner;

public class invalidException{
	private int input;
	private int min;
	private int max;
	private int range;
	
	public invalidException(int range) {
		this.range = range;
	}
	public invalidException(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	public int choice(int input, Scanner sc) {
		boolean correct = false;
		
		while(!correct){
			System.out.print("Invalid try again: ");
			input = sc.nextInt();
			
			if(input >= min && input <= max)
				correct = true;
		}
		
		return input;
	}
	
	public int range(int input, Scanner sc) {
		boolean correct = false;
	
		while(!correct) {
			System.out.print("Invalid try again: ");
			input = sc.nextInt();
			
			if(input >= 0 && input <= range)
				correct = true;
		}
		
		return input;
	}
	
}
