package saveThePrisoner;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * A jail has a number of prisoners and a number of treats to pass out to them. 
 * Their jailer decides the fairest way to divide the treats is to seat the prisoners 
 * around a circular table in sequentially numbered chairs. 
 * A chair number will be drawn from a hat. Beginning with the prisoner in that chair, 
 * one candy will be handed to each prisoner sequentially around the table until all have been distributed.
 * The jailer is playing a little joke, though. 
 * The last piece of candy looks like all the others, but it tastes awful. 
 * Determine the chair number occupied by the prisoner who will receive that candy.
 * @author sutun
 *
 */
public class Solution {

    /**
     * To determine the chair number occupied by the prison who will receive the awful candy
     * @param n - an integer, the number of prisoners
     * @param m - an integer, the number of sweets
     * @param s - an integer, the chair number to begin passing out sweets from
     * @return an integer, the chair number of the prisoner who receives the awful treat on a new line
     */
    static int saveThePrisoner(int n, int m, int s) {
    	int unluckyNum = 0;
        int chairNum = ((m - 1) + s);
        if (chairNum > n) {
            unluckyNum = chairNum % n;
            if (unluckyNum == 0) {
                    unluckyNum = n;
                }
        } else {
            unluckyNum = chairNum;
        }
        return unluckyNum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nms = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nms[0]);

            int m = Integer.parseInt(nms[1]);

            int s = Integer.parseInt(nms[2]);

            int result = saveThePrisoner(n, m, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
