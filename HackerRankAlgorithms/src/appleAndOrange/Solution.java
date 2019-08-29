package appleAndOrange;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countApplesAndOranges function below.
	/**
	 * 
	 * @param s = starting point of Sam's house location
	 * @param t = ending point of Sam's house location
	 * @param a = location of the Apple tree
	 * @param b = location of the Orange tree
	 * @param apples = distances at which each apple falls from the tree
	 * @param oranges = distances at which each orange falls from the tree
	 */
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
    	
    	for (int i = 0; i < apples.length; i++) {
    		apples[i] += a;
    	}

    	int appleCounter = 0;
    	for (int i = 0; i < apples.length; i++) {
    		if ((s <= apples[i]) && (apples[i] <= t)) {
    			appleCounter++;
    		}
    	}
    	
    	
    	for (int i = 0; i < oranges.length; i++) {
    		oranges[i] += b;
    	}
    	
    	int orangeCounter = 0;
    	
    	for (int i = 0; i < oranges.length; i++) {
    		if ((s <= oranges[i]) && (oranges[i] <= t)) {
    			orangeCounter++;
    		}
    	}
    	
    	System.out.println(appleCounter);
    	System.out.println(orangeCounter);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);

        int t = Integer.parseInt(st[1]);

        String[] ab = scanner.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);

        int b = Integer.parseInt(ab[1]);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        int[] apples = new int[m];

        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];

        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();
    }
}
