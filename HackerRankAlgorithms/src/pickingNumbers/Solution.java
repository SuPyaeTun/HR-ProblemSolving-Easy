package pickingNumbers;

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

class Result {

    /**
     * Find and print the maximum number of integers you can select from the array
     * such that the absolute difference between any two of the chosen integers is
     * less than or equal to 1. 
     * @param a - an integer array 
     * @return an integer representing the length of the longest array that can be created
     */

	public static int pickingNumbers(List<Integer> a) {
        int maxCount = 0;
        for (int i = 0; i < a.size(); i++) {
            int preNum = a.get(i) - 1;
            int postNum = a.get(i) + 1;
            
            int preCount = 0;
            int postCount = 0;
            
            for (int j = 0; j < a.size(); j++) {
                if (a.get(j) == preNum || a.get(j) == a.get(i)) {
                    ++preCount;
                }
                if (a.get(j) == postNum || a.get(j) == a.get(i)) {
                    ++postCount;
                }
            }
            if (preCount > postCount) {
                if (preCount > maxCount) {
                    maxCount = preCount;
                }
            } else {
                if (postCount > maxCount) {
                    maxCount = postCount;
                }
            }
        }
        
        return maxCount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
