package cs4310;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParseFile {

	/*
	 * takes in txt. file, reads in file line by line
	 * creates and fills array of ints(1,0) based on dimensions in file
	 * returns 2d int array with puzzle
	 */
	public static int[][] parseFile(File in)throws IOException{
		ArrayList<int[]> lines = new ArrayList<int[]>();
		String linein;
		BufferedReader read = new BufferedReader(new FileReader(in));
		int x = 0, y = 0;
		do {
			linein = read.readLine();
			if(linein != null) {
				char[] chars = linein.toCharArray();
				int[] tempLine = new int[chars.length];
				y = chars.length;
				for(int i = 0; i < chars.length; i++) {
					if(chars[i] == '*')
						tempLine[i] = 1;
					else
						tempLine[i] = 0;
				}
				lines.add(tempLine);
				x++;
			}
			
		}while(linein != null);
		
		read.close();
		
		
		
		return lines.toArray(new int[x][y]);
	}
}
