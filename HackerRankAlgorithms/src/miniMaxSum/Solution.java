package miniMaxSum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
Arrays.sort(arr, 0, arr.length);
        
        long miniSum = 0;
        long maxSum = 0;
        
        for (int j = 0; j < arr.length - 1; j++) {
            miniSum += arr[j];
        }
        
        for (int k = arr.length - 1; k > 0; k--) {
            maxSum += arr[k];
        }
        
        System.out.println(miniSum + " " + maxSum);

    }

    private static final Scanner scanner = new Scanner(System.in);

     public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
