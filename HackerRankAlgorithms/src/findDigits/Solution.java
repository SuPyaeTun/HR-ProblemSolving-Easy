package findDigits;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    /**
     * An integer d is a divisor of an integer n if the remainder of n/d = 0. 
     * Given an integer, for each digit that makes up the integer determine whether it is a divisor. 
     * Count the number of divisors occurring within the integer.
     * Each digit is considered to be unique, so each occurrence of the same digit should be counted. 
     * For example, if n = 111, 1 is a divisor of 111 each time it occurs so the answer is 3.  
     * 				if n is 12, the answer is 2. 
     * 				if n is 1012, the answer is 3.                                                                     
     * @param n - an integer to analyze
     * @return an integer representing the number of digits of d that are divisors of d
     */
    static int findDigits(int n) {
    	int numOfDivisors = 0;
    	int d = n; 
    	
    	while (d > 0) {
    		
    		int digit = d % 10;
    		if (digit > 0 && n % digit == 0 ) {
        			++numOfDivisors;
        		}
    		d /= 10;
    		}
 
    	return numOfDivisors;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
