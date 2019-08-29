package betweenTwoSets;
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

public class tester {
    public static void main(String[] args) throws IOException {

        List<Integer> a = new ArrayList<>(Arrays.asList(2, 4));

        List<Integer> b = new ArrayList<>(Arrays.asList(16, 32, 96));
        
        // to store the factors
    	ArrayList<Integer> totalInt = new ArrayList<Integer>();
    	
    	// look for factor of all elements from b array
    	for (int i = 0; i < b.size(); i++) {
    		int num = b.get(i);
    		for (int j = 1; j <= b.get(0); j++) {
    			if (num % j == 0) {
    				totalInt.add(j);
    			}
    		}
    	}
    	
    	System.out.println(totalInt);
    	
    	// getting rid of the duplicates
    	LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(totalInt);
    	ArrayList<Integer> cleanedList = new ArrayList<>(hashSet);

    	// sorting the ArrayList
    	Collections.sort(cleanedList);
    	System.out.println(cleanedList);
    	
    	for (int i = 0; i < a.size(); i++) {
    		int num2 = a.get(i);
    		for (int j = 0; j < cleanedList.size(); j++) {
    			if ( cleanedList.get(j) % num2 != 0) {
    				cleanedList.remove(j);
    			} 
    		}
    	}
    	
    	System.out.println(cleanedList);
    	
    	int intsBetweenSets = cleanedList.size();
    	
    	System.out.println(intsBetweenSets);
    


    }
}
