import java.util.Scanner;
import java.lang.Exception;
import java.lang.String;

public class Menu {
	private int width;
	private int height;
	
	//Constructor for menu
	public Menu() {
		width = height = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Nonogram"); 
		System.out.println("[1] New Game"); 
		System.out.println("[2] Constructor"); 
		
		System.out.print("Insert Selection: ");
		selection(sc.nextInt());	
		
		sc.close();
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	//Selection on menu
	public void selection(int select) {
		System.out.println();
		
		switch(select) {
		case 1:
			userLoadGame();
			break;
			
		case 2:
			constructor();
			break;
			
		default:
			System.out.println("The selection is invalid");	
		}
	}
	
	//Constructor method is used for user to create their own nonogram
	public void constructor() {
		Scanner sc = new Scanner(System.in);
		int width = height = -1;
		
		System.out.println("Level Constructor (MAX = 10)");
		
		System.out.print("Width: ");
		setWidth(sc.nextInt());
		
		System.out.print("Height: ");
		setHeight(sc.nextInt());
		
		sc.close();
	}
	
	//userLoadGame method let the user select and upload a already existing game
	public void userLoadGame() {
		//text file 
		
		System.out.println("Select Level");
	}
	
	
}
