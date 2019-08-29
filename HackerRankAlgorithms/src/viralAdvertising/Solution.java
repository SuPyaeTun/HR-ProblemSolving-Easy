package viralAdvertising;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * HackerLand Enterprise is adopting a new viral advertising strategy. 
 * When they launch a new product, they advertise it to exactly 5 people on social media.
 * On the first day, half of those 5 people (i.e., floor(5/2) = 2) like the advertisement and 
 * each shares it with 3 of their friends. 
 * At the beginning of the second day, floor(5/2) x 3 = 2 x 3 = 6 people receive the advertisement.
 * Each day, floor(recipients/2) of the recipients like the advertisement and 
 * will share it with 3 friends on the following day. Assuming nobody receives the advertisement twice, 
 * determine how many people have liked the ad by the end of a given day, beginning with launch day as day .
 * e.g. 24 likes by the end of the fifth day
 * @author sutun
 *
 */
public class Solution {

    /**
     * Determine how many people have liked the ad by the end of a given day, beginning with launch day as day 1
     * @param n - denoting a number of days
     * @return an int which display the number of likes the ad has
     */
    static int viralAdvertising(int n) {
    	int likes = 0;
    	int shared = 5; 
    	for (int i = 1; i <= n; i++) {
    		int liked = shared/2;
    		likes += liked;
    		shared = liked * 3;
    	}
    	
    	return likes;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
