package climbingTheLeaderboard;

import java.util.ArrayList;
import java.util.Arrays;

public class tester {

	public static void main(String[] args) {
		int[] scores = new int[] {100, 90, 90, 80, 75, 60};
		int[] alice = new int[] {50, 65, 77, 90, 102};
		
		ArrayList<Integer> personalizedRanking = new ArrayList<Integer>(alice.length);
    	
    	int rank = 1; 
    	for (int a = 0; a < alice.length; a++) {
    		int aliceScore = alice[a];
    		for (int b = 0; b < scores.length - 1; b++) {
    			if (aliceScore > scores[b]) {
    					rank = 1;
    			} else {
    				if (scores[b] > scores[b+1]) {
    					if (scores[b] > aliceScore) {
    						++rank;
    					}
    					if (scores[b+1] < aliceScore) {
    						break;
    					}
        				
        			}
    			}
    			if (aliceScore < scores[scores.length-1] ) {
    				++rank;
    			}
    		}
    		personalizedRanking.add(rank);
    	}
    	for (int i = 0; i < personalizedRanking.size(); i++) {
    		System.out.println(personalizedRanking.get(i));
    	}
    	

	}

}
