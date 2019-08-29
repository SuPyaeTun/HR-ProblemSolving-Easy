package jumpingOnTheClouds_Revisited;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Aerith is playing a cloud hopping game. In this game, 
 * there are sequentially numbered clouds that can be thunderheads or cumulus clouds. 
 * Her character must jump from cloud to cloud until it reaches the start again.
 * To play, Aerith is given an array of clouds,c and an energy level e = 100. 
 * She starts from c[0] and uses 1 unit of energy to make a jump of size k to cloud c [ (i + k) % n ].
 * If Aerith lands on a thundercloud,c[i] = 1 , her energy (e) decreases by 2 additional units. 
 * The game ends when Aerith lands back on cloud 0.
 * Given the values of n, k, and the configuration of the clouds as an array c, 
 * can you determine the final value of e after the game ends?
 * @author sutun
 *
 */
public class Solution {

    /**
     * Given the values of n, k, and the configuration of the clouds as an array c, 
     * can you determine the final value of e after the game ends?
     * For example: c = [0, 0, 1, 0] and k = 2
     * 				The indices of her path are 0 -> 2 -> 0
     * 				Her energy level reduces by 1 for each jump to 98. 
     * 				She landed on one thunderhead at an additional cost of 2 energy units.
     * 				Her final energy level is 96. 
     * @param c - an array of integers representing cloud types
     * 			  c[i] = 0 --> cumulus cloud, c[i] = 1 --> thunderhead
     * @param k - an integer representing the length of one jump
     * @return an integer representing the energy level remaining after the game
     * There is an input constraint: n%k = 0
     * This algorithm will only work if the input fulfills this constraint
     */
    static int jumpingOnClouds(int[] c, int k) {
    	int energyLevel = 100;				// default energy level at the start of the game
 
    	for (int index = 0; index < c.length; index++) {
    		if (c[index] == 1) {
    			energyLevel -= 2;
    		}
    		energyLevel -= 1;
    		index += k - 1;
    	}
    	return energyLevel;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
