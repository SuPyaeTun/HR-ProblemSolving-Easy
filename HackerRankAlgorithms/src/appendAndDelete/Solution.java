package appendAndDelete;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * You have a string of lowercase English alphabetic letters. 
 * You can perform two types of operations on the string:
 * 1. Append a lowercase English alphabetic letter to the end of the string.
 * 2. Delete the last character in the string. 
 * 	  Performing this operation on an empty string results in an empty string.
 * Given an integer, k, and two strings, s and t, determine whether or not you can convert s to t 
 * by performing exactly k of the above operations on s. 
 * If it's possible, print Yes. Otherwise, print No.
 * @author sutun
 *
 */

public class Solution {

    /**
     * Given an integer, k, and two strings, s and t, determine whether or not you can convert s to t
     * by performing exactly k of the above operations on s. If it's possible, print Yes. Otherwise, print No.
     * @param s : the initial string
     * @param t : the desired string
     * @param k : an integer that represents the number of operations
     * @return a string, either Yes or No
     */
    static String appendAndDelete(String s, String t, int k) {
    	String answer = "No";
    	int iniStrCount = s.length();
        int desiStrCount = t.length();   
    	int equalCount = 0; 
    	for (int i = 0; i < Math.min(iniStrCount, desiStrCount); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                equalCount++;
            } else {
                break;
            }
    	}
    	
    	if (iniStrCount + desiStrCount <= k) {
    		answer = "Yes";
    	}
    	
    	int delCount = iniStrCount - equalCount;
        int appCount = desiStrCount - equalCount;
    	int diff = delCount + appCount;
    	
    	if ( (k - diff) >= 0 && (k - diff) % 2 == 0) {
    		answer = "Yes";
    	}
    	return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
