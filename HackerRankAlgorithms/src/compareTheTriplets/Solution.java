package compareTheTriplets;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * Alice and Bob each created one problem for HackerRank. 
 * A reviewer rates the two challenges, awarding points on a scale from  to  for three categories:
 *  problem clarity, originality, and difficulty.

We define the rating for Alice's challenge to be the triplet , 
and the rating for Bob's challenge to be the triplet .

Your task is to find their comparison points by comparing. 

If a[i] > b[i], then Alice is awarded  point.
If a[i] < b[i], then Bob is awarded  point.
If not , then neither person receives a point.
Comparison points is the total points a person earned.

Given  and , determine their respective comparison points.

 * @author sutun
 *
 */
public class Solution {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    	List<Integer> output = new ArrayList<>();
    	int alice = 0;
    	int bob = 0;

    	
    	for (int i = 0; i < a.size(); i++) {
    		int aOne = a.get(i);
    		int bOne = b.get(i);
    		
    		if ((1 <= aOne) && (aOne <= 100)) {
    			if ((1 <= bOne) && (bOne <= 100)) {
    				if (aOne > bOne) {alice++;}
    				if (aOne < bOne) {bob++;}
    			}
    		}
    	}
    	output.add(alice);
    	output.add(bob);
    	
    	return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a.add(aItem);
        }

        String[] bItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int bItem = Integer.parseInt(bItems[i]);
            b.add(bItem);
        }

        List<Integer> result = compareTriplets(a, b);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
