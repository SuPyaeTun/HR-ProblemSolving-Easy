package climbingTheLeaderboard;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Alice is playing an arcade game and wants to climb to the top of the leaderboard and wants to track her ranking. 
 * The game uses Dense Ranking, so its leaderboard works like this:
 * 		The player with the highest score is ranked number 1 on the leaderboard.
 * 		Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.
 * @author sutun
 *
 */

public class Solution {
	
	/**
	 * To track the ranking of the sole user 
	 * @param scores - an array of integers that represent leaderboard scores
	 * @param alice - an array of integers that represent Alice's scores
	 * @return an integer array where each element res[j] represents Alice's rank after the jth game
	 */
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
    	ArrayList<Integer> personalizedRanking = new ArrayList<Integer>(alice.length);
    	
    	int rank = 1; 
    	for (int a = 0; a < alice.length; a++) {
    		int aliceScore = alice[a];
    		for (int b = 0; b < scores.length; b++) {
    			if (aliceScore > scores[b]) {
    				personalizedRanking.add(rank);
    			} else {
    				if (scores[b] > scores[b+1]) {
        				++rank;
        			}
    			}
    			if (aliceScore < scores[scores.length-1] ) {
    				++rank;
    			}
    			personalizedRanking.add(rank);
    		}
    	}	
    	
    	int[] aliceRank = new int[personalizedRanking.size()];
    	for (int i = 0; i < aliceRank.length; i++) {
    		aliceRank[i] = personalizedRanking.get(i);
    	}
    	return aliceRank;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

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
