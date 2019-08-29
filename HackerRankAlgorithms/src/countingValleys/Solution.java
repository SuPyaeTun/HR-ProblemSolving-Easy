package countingValleys;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	/**
	 * A mountain is a sequence of consecutive steps above sea level,
	 * starting with a step up from sea level, U, and
	 * ending with a step down to sea level, D
	 * 
	 * A valley is a sequence of consecutive steps below sea level, 
	 * starting with a step down from sea level, D and 
	 * ending with a step up to sea level
	 * @param n - total steps during the hike
	 * @param s - a string describing the path of hike
	 * @return an int, denoting the number of valleys user traversed
	 */
    static int countingValleys(int n, String s) {
    	int valleyCounter = 0;
    	int seaLevel = 0; 
    	
    	for (char c : s.toCharArray()) {
    		if (c == 'U') {
    			++seaLevel;
    		} else if (c == 'D') {
    			--seaLevel;
    		}
    		
    		if (seaLevel == 0 & c == 'U') {
    			++valleyCounter;
    		}
    	}  	
    	return valleyCounter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
