package migratoryBirds;

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

    /**
     * return the lowest type number of the most frequently sighted bird
     * ---> if arr = [1, 1, 2, 2, 3] --> 1, 2 --> 1 since 1 < 2
     * It is guaranteed that each type is 1, 2, 3, 4, or 5
     * @param arr - an array of integers representing types of birds sighted
     * @return an int representing the type of birds sighted
     */
    static int migratoryBirds(List<Integer> arr) {
    	
    	long oneCounter, twoCounter, threeCounter, fourCounter, fiveCounter;
        oneCounter = twoCounter = threeCounter = fourCounter = fiveCounter = 0;
        
        for (int index = 0; index < arr.size(); index++) {
            if (arr.get(index) == 1) {
                ++oneCounter;
            
            } else if (arr.get(index) == 2) {
                ++twoCounter;
        
            } else if (arr.get(index) == 3) {
                ++threeCounter;
        
            } else if (arr.get(index) == 4) {
                ++fourCounter;
        
            } else {
                ++fiveCounter;
        
            }
        }
        
        long max = oneCounter;
        int mfSightedBirds = 1;
        
        if (max < twoCounter) {
            max = twoCounter;
            mfSightedBirds = 2;
        } 
        if (max < threeCounter) {
            max = threeCounter;
            mfSightedBirds = 3;
        } 
        if (max < fourCounter) {
            max = fourCounter;
            mfSightedBirds = 4;
        } 
        if (max < fiveCounter) {
            max = fiveCounter;
            mfSightedBirds = 5;
        }
        
        return mfSightedBirds;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
