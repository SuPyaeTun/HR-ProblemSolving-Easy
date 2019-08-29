package plusMinus;

// Given an array of integers, calculate the fractions of its elements 
// that are positive, negative, and are zeros. 
// Print the decimal value of each fraction on a new line.
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
    	int counter = arr.length;
    	int pCounter = 0;
    	int nCounter = 0;
    	int zCounter = 0;
    	
    	for (int i = 0; i < counter; i++) {
    		// look for zero first
    		if (arr[i] == 0) {
    			++zCounter;
    		} else if (arr[i] < 0) {
    			// if it is less than zero
    			++nCounter;
    		} else if (arr[i] > 0) {
    			// if it is larger than zero
    			++pCounter;
    		}
    	}
    	
    	double posNum = (double) pCounter / counter;
    	double negNum = (double) nCounter / counter;
    	double zeroNum = (double) zCounter / counter;
  
    	DecimalFormat df = new DecimalFormat("#.######");
    	df.setRoundingMode(RoundingMode.CEILING);
    	System.out.println(df.format(posNum));
    	System.out.println(df.format(negNum));
    	System.out.println(df.format(zeroNum));

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
