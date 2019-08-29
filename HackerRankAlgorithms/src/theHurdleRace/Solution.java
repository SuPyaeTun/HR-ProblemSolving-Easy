package theHurdleRace;

/**
 * Dan is playing a video game in which his character competes in a hurdle race. 
 * Hurdles are of varying heights, and Dan has a maximum height he can jump. 
 * There is a magic potion he can take that will increase his maximum height by
 *  1 unit for each dose. How many doses of the potion must he take to be able to jump 
 *  all of the hurdles.
 *  Given an array of hurdle heights "height", and an initial maximum height Dan can jump, k. 
 *  Determine the minimum number of doses Dan must take to be able to clear all the hurdles in the race.
 * @author sutun
 *
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    /**
     * To return the minimum units of potion Dan needs to drink to jump all of the hurdles
     * @param k - an integer denoting the height Dan can jump naturally
     * @param height - an array of integers denoting the heights of each hurdle
     * @return an integer denoting the number of potions needed for all the hurdles
     */
    static int hurdleRace(int k, int[] height) {
    	int potions = 0;
    	for (int i = 0; i < height.length; i++) {
    		if (height[i] > k) {
    			int indiP = height[i] - k;
    			potions += indiP;
    			k += indiP;
    		}
    	}

    	return potions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] height = new int[n];

        String[] heightItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int heightItem = Integer.parseInt(heightItems[i]);
            height[i] = heightItem;
        }

        int result = hurdleRace(k, height);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

