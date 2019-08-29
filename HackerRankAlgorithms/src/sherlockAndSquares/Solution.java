package sherlockAndSquares;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Watson likes to challenge Sherlock's math ability. 
 * He will provide a starting and ending value describing a range of integers. 
 * Sherlock must determine the number of square integers within that range, inclusive of the endpoints.
 * Note: A square integer is an integer which is the square of an integer, e.g.1, 4, 9, 16, 25.
 * Example: The range is 24 and 49, inclusive. There are 3 square integers in the range: 25, 36, 49.
 * @author sutun
 *
 */
public class Solution {

    /**
     * To get the number of square integers within the provided boundary
     * @param a - an integer, the lower range boundary
     * @param b - an integer, the upper range boundary
     * @return an integer representing the number of square integers in the inclusive range from a to b
     */
    static int squares(int a, int b) {
    	return (int) ( Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
