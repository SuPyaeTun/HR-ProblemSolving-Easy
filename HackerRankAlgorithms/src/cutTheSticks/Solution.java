package cutTheSticks;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * You are given a number of sticks of varying lengths. 
 * You will iteratively cut the sticks into smaller sticks, discarding the shortest pieces 
 * until there are none left. At each iteration you will determine 
 * the length of the shortest stick remaining, cut that length from each of the longer sticks 
 * and then discard all the pieces of that shortest length. 
 * When all the remaining sticks are the same length, they cannot be shortened so discard them.
 * Given the lengths of n sticks, print the number of sticks that are left before each iteration until there are none left.
 * Example: n = 3 sticks of lengths arr = [1, 2, 3]
 * 			So, we cut that length from the longer two and discard the pieces of length 1
 * 			Now, our lengths are arr = [1, 2]
 * 			Again, the shortest stick is of length 1, so we cut that amount from the longer stick and discard those pieces.
 * 			There is only one stick left, arr = [1]. So, we discard that stick.
 * Answer: [3, 2, 1]
 * @author sutun
 *
 */
public class Solution {

    /**
     * 
     * @param arr - an array of integers representing the length of each stick
     * @return an array of integers representing the number of sticks before each cut operation is performed
     */
    static int[] cutTheSticks(int[] arr) {
    	Arrays.sort(arr);
    	int controlNum = countDistinct(arr);
    	int[] sticksCount = new int[controlNum];
    	for (int i = 0; i < controlNum; i++) {
    		sticksCount[i] = arr.length;
    		int smallest = arr[0];
    		arr = remove(arr, smallest);
    	}
    	return sticksCount;
    }
    
    static int[] remove(int[] numbers, int target) {
    	int count = 0;
    	for (int num : numbers) {
    		if (num == target) {
    			count++;
    		}
    	}
    	
    	if (count == 0) return numbers;
    	
    	int[] result = new int[numbers.length - count];
    	int index = 0;
    	for (int value : numbers) {
    		if (value != target) {
    			result[index] = value;
    			index++;
    		}
    	}
    	numbers = null;
    	return result;
    }
    
    static int countDistinct(int[] arr) {
		int res = 0; 
		int n = arr.length;
		for (int i = 0; i < n;i++) {
			while (i < n-1 && arr[i] == arr[i+1]) {
				i++;
			}
			res++;
		}
		return res;
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

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
