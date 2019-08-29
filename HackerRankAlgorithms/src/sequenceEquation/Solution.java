package sequenceEquation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Given a sequence of n integers, p(1), p(2), ... , p(n) where each element is distinct and 
 * satisfies 1 <= p(x) <= n. For each x where 1<= x <= n, find any integer y such that 
 * p (p(y)) is identical to x and print the value of y on a new line. 
 * For example, assume the sequence p = [5, 2, 1, 3, 4]. Each value of x between 1 and 5,
 * the length of the sequence is analyzed and then the values of y are [4, 2, 5, 1, 3].
 * @author sutun
 *
 */
public class Solution {

    /**
     * Given a sequence of n integers, p(1), p(2), ... , p(n) where each element is distinct and 
     * satisfies 1 <= p(x) <= n. For each x where 1<= x <= n, find any integer y such that 
     * p (p(y)) is identical to x and print the value of y on a new line. 
     * For example, assume the sequence p = [5, 2, 1, 3, 4]. Each value of x between 1 and 5,
     * the length of the sequence is analyzed and then the values of y are [4, 2, 5, 1, 3].
     * @param p - an array of integers
     * @return an array of integers that represent the values of y
     */
	static int[] permutationEquation(int[] p) {
        int[] result = new int[p.length];
        int limit = p.length;
        int y = 0;
        
        for (int x = 1; x <= limit; x++) {
            int outerY = calculateIndex(p, x);
            y = calculateIndex(p, outerY);
            result[x-1] = y;
        }
        return result;
    }

    static int calculateIndex (int[] p,int x) {
        int index = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] == x) {
                index = i+1;
            }
        }
        return index;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int[] result = permutationEquation(p);

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
