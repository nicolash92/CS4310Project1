package com.util;

import java.util.ArrayList;

public class DisplayGridHints {

	
	public static void DisplayGridHints(int boardarray[][]) {
	
			int[][]rows = new int[boardarray.length][];
			int[][]cols = new int[boardarray[0].length][];
			
			//count segment lengths along rows
			for(int x = 0; x < boardarray.length; x++) {
				
				ArrayList<Integer> counter = new ArrayList<Integer>();
				int curr = 0;
				boolean counting = false;
				
				for(int y = 0; y < boardarray[0].length; y++) {
					if(boardarray[x][y] == 1) {
						curr++;
						counting = true;
					}
					else {
						if(counting) {
							counter.add(curr);
							curr = 0;
							counting = false;
						}
					}
				}
				if(counting) {
					counter.add(curr);
				}
				
				Integer[] countI = counter.toArray(new Integer[0]);
				rows[x] = new int[countI.length];
				
				for(int y = 0; y < countI.length; y++)
					rows[x][y] = countI[y];
			}
			//count segment lengths along collumn
			for(int x = 0; x < boardarray[0].length; x++)
			{
				ArrayList<Integer> counter = new ArrayList<Integer>();
				int curr = 0;
				boolean counting = false;
				
				for(int y = 0; y < boardarray.length; y++) {
					if(boardarray[y][x] == 1) {
						curr++;
						counting = true;
					}
					else {
						if(counting) {
							counter.add(curr);
							curr = 0;
							counting = false;
						}
					}
				}
				if(counting) {
					counter.add(curr);
				}
				Integer[] countI = counter.toArray(new Integer[0]);
				cols[x] = new int[countI.length];
				for(int y = 0; y < countI.length; y++) {
					cols[x][y] = countI[y];
				}
			}
			
			//print segment board
			int maxNumCol = 0;
			
			
			for(int x = 0; x < cols.length; x++) {
				if(cols[x].length > maxNumCol) {
					maxNumCol = cols[x].length;
				}
			}
			String[] rowToPrint = new String[maxNumCol];
			for(int x = 0; x < rowToPrint.length; x++) {
				rowToPrint[x] = "";
			}
			for(int x = 0; x < maxNumCol; x++) {
				for(int y = 0; y < cols.length; y++) {
					if(x < cols[y].length) {
						rowToPrint[x] += cols[y][x] + " ";
					}
					else {
						rowToPrint[x] += "  ";
					}
				}
			}
			
			System.out.println("Collumns: ");
			for(int x = rowToPrint.length -1; x >= 0; x--) {
				System.out.print("\t");
				System.out.println(rowToPrint[x]);
			}
			System.out.println();
			int maxNumInRow = 0;
			for(int x = 0; x < rows.length; x++) {
				if(rows[x].length > maxNumInRow) {
					maxNumInRow = rows[x].length;
				}
			}
			System.out.println("Rows: " );
			for(int x = 0; x < rows.length; x++) {
				for(int y = maxNumInRow -1; y >= 0; y--) {
					if(y < rows[x].length) {
						System.out.print(rows[x][y] + " ");
					}
					else {
						System.out.print("");
					}
					
					
				}
				System.out.println("");
			}
	}
}
