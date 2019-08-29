package electronicsShop;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /**
     * choosing a keyboard and a USB drive from several models of each 
     * spend as much as possible for the 2 items, given the budget
     * 
     * @param keyboards - an array of integers representing keyboard prices
     * @param drives - an array of integers representing drive prices
     * @param b - the units of currency in Monica's budget
     * @return the amount of money user will spend for both items, but
     * print -1 if she doesn't have enough money to buy both items
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
    	int max = -1;
        
        for (int k = 0; k < keyboards.length; k++) {
            for (int d = 0; d < drives.length; d++) {
                int curBill = keyboards[k] + drives[d];
                if (curBill <= b) {
                    if (curBill > max) {
                        max = curBill;
                    }
        
                }
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] bnm = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = getMoneySpent(keyboards, drives, b);

        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
