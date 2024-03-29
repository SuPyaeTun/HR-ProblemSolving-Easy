package staircase;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * Consider a staircase of size :

   #
  ##
 ###
####
Observe that its base and height are both equal to n, 
and the image is drawn using # symbols and spaces. 
The last line is not preceded by any spaces.

Write a program that prints a staircase of size n. 
 * @author sutun
 *
 */
public class Solution {

    // Complete the staircase function below.
    static void staircase(int n) {
    	
    	if ((0 < n) && (n <= 100)) {
    			int counter = n;
    			for (int i = 0; i < n; i++) {
    				for (int j = counter - 1; j > 0; j--) {
    					System.out.print(" ");
    				}
    				for (int k = counter-1; k < n; k++) {
    					System.out.print("#");
    				}
    				
    				System.out.println("");
    				--counter;
    			}
    	} else {
    		System.out.println("The size of staircase has to be between 1 and 100, inclusively.");
    	}

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}

