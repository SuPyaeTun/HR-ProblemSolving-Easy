package bon_Appetit;

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
     * print Bon Appetit if the bill is fairly split
     * Otherwise, it should print the int amount of money that Brian owes Anna
     * @param bill - an array of integers representing the cost of each item ordered
     * @param k - an int representing the zero-based index of the item Anna doesn't eat
     * @param b - the amount of money that Anna contributed to the bill 
     */
    static void bonAppetit(List<Integer> bill, int k, int b) {
    	String fair = "Bon Appetit";
    	int owedMoney = 0;
    	
    	int anna_Sum = 0;
    	for (int index = 0; index < bill.size(); index++) {
    		anna_Sum += bill.get(index);
    	}
    	anna_Sum -= bill.get(k);
    	
    	owedMoney = b - anna_Sum/2;
    	
    	if (b == anna_Sum/2) {
    		System.out.println(fair);
    	} else {
    		System.out.println(owedMoney);
    	}
    	 

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
