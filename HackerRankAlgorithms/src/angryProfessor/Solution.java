package angryProfessor;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * A Discrete Mathematics professor has a class of students. 
 * Frustrated with their lack of discipline, he decides to cancel class 
 * if fewer than some number of students are present when class starts. 
 * Arrival times go from on time (arrivalTime <= 0) to arrived late (arrivalTime > 0).
 * Given the arrival time of each student and a threshhold number of attendees, 
 * determine if the class is canceled.
 * @author sutun
 *
 */
public class Solution {

    /**
     * To return YES if the class is cancelled, or NO otherwise
     * @param k - the threshold number of students
     * @param a - an array of integers representing arrival times
     * @return a String to indicate the class cancellation status
     */
    static String angryProfessor(int k, int[] a) {
    	String cancelled = "YES";
    	int onTime = 0; 
    	
    	for (int i = 0; i < a.length; i++) {
    		if (a[i] <= 0) {
    			++onTime;
    		}
    	}
    	
    	if (onTime >= k) {
    		cancelled = "NO";
    	}   	
    	return cancelled;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aItems[i]);
                a[i] = aItem;
            }

            String result = angryProfessor(k, a);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
