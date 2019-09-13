package equalizeTheArray;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Karl has an array of integers. 
 * He wants to reduce the array until all remaining elements are equal.
 * Determine the minimum number of elements to delete to reach his goal.
 * For example: arr = [1, 2, 2, 3]
 * 				if we delete both twos and either 1 or 3, it would take 3 deletions.
 * 				if we delete 1 and 3, it would take 2 deletions. 
 * Therefore, the min number of deletions is 2. 
 * @author sutun
 *
 */

public class Solution {

    /**
     * To determine the minimum number of elements to delete to get an array with equal elements
     * @param arr - an array of integers
     * @return an integer that denotes the minimum number of deletions required
     */
    static int equalizeArray(int[] arr) {
    	int minDeletions = 0; 
    	
    	ArrayList<Integer> keyList = new ArrayList<Integer>();
    	for (int i = 0; i < arr.length; i++) {
    		keyList.add(arr[i]);
    	}
    	
    	HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
    	for (int i = 0; i < keyList.size(); i++) {
    		int key = keyList.get(i);
    		if (!freqMap.containsKey(key)) {
    			int freq = Collections.frequency(keyList, key);
    			freqMap.put(key, freq);
    		}
    	}
    	
    	int maxFreq = Collections.max(freqMap.values());
    	minDeletions = arr.length - maxFreq;

    	return minDeletions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
