package sockMerchant;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    /**
     * to determine how many pairs of socks with matching colors there are
     * @param n - the number of socks in the pile, 1 <= n <= 100
     * @param ar - the colors of each sock, 1 <= ar[i] <= 100 where 0<= i < n
     * @return an int indicating the number of correctly paired socks
     */
    static int sockMerchant(int n, int[] ar) {
    	int totalNum = 0;
    	ArrayList<Integer> colors = new ArrayList<Integer>();
    	
    	for (int i = 0; i < ar.length; i++) {
    		colors.add(ar[i]);
    	}
    	
    	for (int j = 0; j < colors.size(); j++) {
    		for (int k = j+1; k < colors.size(); k++) {
    			if (colors.get(j) == colors.get(k)) {
    				colors.remove(k);
    				++totalNum;
    				break;
    			}
    		}
    	}
    	
    	return totalNum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
