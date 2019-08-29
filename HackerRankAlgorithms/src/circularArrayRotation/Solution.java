package circularArrayRotation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * John Watson knows of an operation called a right circular rotation on an array of integers. 
 * One rotation operation moves the last array element to the first position and shifts all remaining elements right one. 
 * To test Sherlock's abilities, Watson provides Sherlock with an array of integers. 
 * Sherlock is to perform the rotation operation a number of times then determine the value of the element at a given position.
 * For each array, perform a number of right circular rotations and return the value of the element at a given index.
 * @author sutun
 *
 */
public class Solution {

    /**
     * To perform a number of right circular rotations and return the value of the element at a given index
     * @param a - an array of integers to rotate
     * @param k - an integer, the rotation count
     * @param queries - an array of integers, the indices to report
     * @return an array of integers representing the values at the specified indices
     */
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
    	
    	int l = queries.length;
        int[] qArray = new int[l];
        int al = a.length;
        
        for (int i = 0; i < l; i++) {
            int m = queries[i];
            int diff = m-k;
            if ( diff < 0 ) {
                qArray[i] = a[al + diff];
            } else if ( diff > 0) {
                qArray[i] = a[diff];
            } else {
                qArray[i] = a[0];
            }
        }

        return qArray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nkq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nkq[0]);

        int k = Integer.parseInt(nkq[1]);

        int q = Integer.parseInt(nkq[2]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] queries = new int[q];

        for (int i = 0; i < q; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        int[] result = circularArrayRotation(a, k, queries);

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
