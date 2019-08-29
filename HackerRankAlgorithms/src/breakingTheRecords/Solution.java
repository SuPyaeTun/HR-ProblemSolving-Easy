package breakingTheRecords;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the breakingRecords function below.
	/**
	 * return an int array containing the number of times she broke her records
	 * index 0 is for breaking most points records
	 * index 1 is for breaking least points records
	 * @param scores = an int array for points scored in a season
	 * @return return an int array containing the number of times she broke her records
	 */
    static int[] breakingRecords(int[] scores) {
    	int[] recorder = new int[2];
    	
    	int mostPtRecord = scores[0];
    	int mPRCounter = 0;
    	
    	int leastPtRecord = scores[0];
    	int lPRCounter = 0;
    	
    	for (int index = 0; index < scores.length; index++) {
    		if (scores[index] > mostPtRecord) {
    			mostPtRecord = scores[index];
    			++mPRCounter;
    		} else if (scores[index] < leastPtRecord) {
    			leastPtRecord = scores[index];
    			++lPRCounter;
    		}
    	}
    	
    	recorder[0] = mPRCounter;
    	recorder[1] = lPRCounter;

    	return recorder;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

       
        int[] scores = new int[n];
        
        
        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

