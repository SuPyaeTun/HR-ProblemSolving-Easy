package beautifulDaysAtTheMovies;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Lily likes to play games with integers. She has created a new game where she determines the difference 
 * between a number and its reverse. For instance, given the number 21, its reverse is 12. Their difference is 9. 
 * The number 120 reversed is 21, and their difference is 99. She decides to apply her game to decision making. 
 * She will look at a numbered range of days and will only go to a movie on a beautiful day.
 * Given a range of numbered days, [i ... j] and a number k, determine the number of days in the range that are beautiful. 
 * Beautiful numbers are defined as numbers where |i - reverse(i)| is evenly divisible by k. 
 * If a day's value is a beautiful number, it is a beautiful day. 
 * Print the number of beautiful days in the range.
 * @author sutun
 *
 */
public class Solution {

    /**
     * To return the number of beautiful days where |i - reverse(i)| is evenly divisible by k in the range
     * @param i - the starting day number
     * @param j - the ending day number
     * @param k - the divisor
     * @return an integer representing the number of beautiful days in the range
     */
    static int beautifulDays(int i, int j, int k) {
    	int beautifulDays = 0; 
    	for (int a = i; a <= j; a++) {
    		int abs = Math.abs(a - reverseInt(a));
    		if (abs % k == 0) {
    			++beautifulDays;
    		}
    	}
    	return beautifulDays;
    }
    
    static int reverseInt (int x) {
    	int rev = 0; 
    	while (x != 0) {
    		rev = rev * 10 + x % 10;
    		x = x/10;
    	}
    	return rev;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
