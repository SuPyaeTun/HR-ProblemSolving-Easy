package libraryFine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Create a program that calculates the fine (if any).
 * 1. If the book is returned on or before the expected return date,
 *    no fine will be charged. (i.e. fine = 0)
 * 2. If the book is returned after the expected return day but 
 *    still within the same calendar month and year as the expected return date,
 *    fine = 15 Hackos x (the number of days late)
 * 3. If the book is returned after the expected return month but 
 *    still within the same calendar year as the expected return date, 
 *    the fine = 500 Hackos x (the number of months late).
 * 4. If the book is returned after the calendar year in which it was expected, 
 *    there is a fixed fine of 10000 Hackos.
 * Constraints
 *         1 <= D <= 31
 *         1 <= M <= 12
 *         1 <= Y <= 3000
 * @author sutun
 *
 */

public class Solution {

    /**
     * Given the expected and actual return dates for a library book, create a program that calculates the fine (if any).
     * @param d1 - Day of the returned date
     * @param m1 - Month of the returned date
     * @param y1 - Year of the returned date
     * @param d2 - Day of the due date
     * @param m2 - Month of the due date
     * @param y2 - Year of the due date
     * @return an integer representing the fine due
     */
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
int fine = 0;
        
        if (y1 > y2) {
            fine = 10000;
        } else if (y1 == y2) {
            
            if (m1 == m2) {
                fine = 15 * (d1 - d2);
            }
            if (m1 <= m2 && d1 <= d2) {
                fine = 0;
            }
            if (m1 > m2) {
                fine = 500 * (m1 - m2);
            }
        }
        
        return fine;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] d1M1Y1 = scanner.nextLine().split(" ");

        int d1 = Integer.parseInt(d1M1Y1[0]);

        int m1 = Integer.parseInt(d1M1Y1[1]);

        int y1 = Integer.parseInt(d1M1Y1[2]);

        String[] d2M2Y2 = scanner.nextLine().split(" ");

        int d2 = Integer.parseInt(d2M2Y2[0]);

        int m2 = Integer.parseInt(d2M2Y2[1]);

        int y2 = Integer.parseInt(d2M2Y2[2]);

        int result = libraryFine(d1, m1, y1, d2, m2, y2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}