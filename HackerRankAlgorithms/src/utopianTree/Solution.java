package utopianTree;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * The Utopian Tree goes through 2 cycles of growth every year. 
 * Each spring, it doubles in height. Each summer, its height increases by 1 meter.
 * Laura plants a Utopian Tree sapling with a height of 1 meter at the onset of spring. 
 * How tall will her tree be after n growth cycles?
 * Example: if n = 5, height = 14
 * @author sutun
 *
 */
public class Solution {

    /**
     * To calculate the height of a tree based on the growth cycles
     * @param n - the number of growth cycles
     * @return an integer representing the height of the tree after growing through the nth cycles of growth
     */
    static int utopianTree(int n) {
    	// initial growth = 1 
    	int height = 1; 
    	for (int i = 1; i <= n; i++) {
    		if (i % 2 == 1) {
    			height *= 2;
    		} else {
    			height += 1;
    		}
    	}
    	
    	return height;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = utopianTree(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
