package birthdayChocolate;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the birthday function below.
	/**
	 * to share a contiguous segment of the chocolate bar 
	 * which has an int on each square selected such that 
	 * the length of the segment matches Ron's birth month and 
	 * the sum of the integers on the squares is equal to his birth day
	 * n : number of squares in the chocolate bar
	 * @param s : an int array for the numbers on each of the square of chocolate [ 1 <= s[i] <= 5, 0 <= i <= n ]
	 * @param d : an int, Ron's birth day [ 1 <= d <= 31]
	 * @param m : an int, Ron's birth month [ 1 <= m <= 12 ]
	 * @return int denoting the number of ways Lily can divide the chocolate bar
	 */
    static int birthday(List<Integer> s, int d, int m) {
    	int numOfDivision = 0; 
    	
    	for (int index = 0; index <= s.size()-m; index++) {
    		int sum = 0;
    		for (int counter = index; counter < m+index; counter++) {
    			sum += s.get(counter);
    		}
    		if (sum == d) {
    			++numOfDivision;
    		}
    	}	
    	return numOfDivision;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
