package climbingTheLeaderboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Tester2 {

	public static void main(String[] args) {
		int[] scores = new int[] {100, 100, 50, 40, 40, 20, 10};
		int[] alice = new int[] {5, 25, 50, 120};
	
		ArrayList<Integer> distScore = new ArrayList<Integer>();
		distScore.add(scores[0]);
		
		for (int i = 0; i < scores.length; i++) {
			if (!distScore.contains(scores[i])) {
				distScore.add(scores[i]);
			}
		}
		
		System.out.println(distScore.toString());
		
		ArrayList<Integer> indiRank = new ArrayList<Integer>(alice.length);
		
		for (int i = 0; i < alice.length; i++) {
			for (int j = distScore.size()-1; j > 0; j--) {
				if (alice[i] == distScore.get(j)) {
					indiRank.add(j+1);
					break;
				} else if (alice[i] > distScore.get(0)) {
					indiRank.add(1);
					break;
				} else if (alice[i] < distScore.get(distScore.size()-1)) {
					indiRank.add(distScore.size()+1);
					break;
				} else if (alice[i] > distScore.get(j) && alice[i] < distScore.get(j-1)) {
					indiRank.add(j+1);
					break;
				}
			}
		}
		
		System.out.println(indiRank.toString());
		
		int[] personalRank = new int[indiRank.size()];
		for (int a = 0; a < indiRank.size(); a++) {
			personalRank[a] = indiRank.get(a);
		}
	}
}
