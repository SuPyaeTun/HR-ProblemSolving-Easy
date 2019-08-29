package formingAMagicSquare;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    /**
     * magic square = sudoku
     * @param s - a 3x3 array of integers
     * @return an integer representing the minimal total cost of converting
     * the input square to a magic square
     */
    static int formingMagicSquare(int[][] s) {
    	int minTotalCost = 0;
    	int[] rowOne = new int[3];
    	rowOne.a
    	

    	return minTotalCost;
    }
    
    static boolean magicCheck(int[] ar) {
    	boolean result = false;
    	int sum = 0;
    	for (int i = 0; i < ar.length; i++) {
    		for (int j = i; j < j+3; j++) {
    			sum+= ar[j];
    		}
    		i += 2;
    	}
    	if (sum == 15) result = true;
    	return result;
    }
    
    static int countCheck(int[] ar) {
    	int cost = 0, sum = 0;
    	
    	for (int i = 0; i < ar.length; i++) {
    		sum += ar[i];
    	}
    	if (sum == 15) {
    		cost = 0;
    	} else {
    		
    		int max = ar[ar.length-1];
    		int minSum = sum - max;
    		int sub = 15 - minSum;
    		cost = Math.abs(max - sub);
    		ar[ar.length-1] = sub;		
    	}
    	
    	return cost;
    }

    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
