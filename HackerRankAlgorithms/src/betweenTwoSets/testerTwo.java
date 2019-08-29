package betweenTwoSets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class testerTwo {
	public static void main(String[] args) throws IOException {

        List<Integer> a = new ArrayList<>(Arrays.asList(3, 4));

        List<Integer> b = new ArrayList<>(Arrays.asList(24, 48));
        
        // to store the factors
        ArrayList<Integer> totalInt = new ArrayList<Integer>();
        
        for (int j = 1; j <= b.get(0); j++) {
        	for (int i = 0; i < a.size(); i++) {
        		if (j % a.get(i) == 0) {
                    totalInt.add(j);
                }
        	}
        }
        /*
        for (int i = 0; i < a.size(); i++) {
            for (int j = 1; j <= b.get(0); j++) {
                if (j % a.get(i) == 0) {
                    totalInt.add(j);
                }
            }
        }
        */
        System.out.println("The first array is " + totalInt);
    	
    	// getting rid of the duplicates
    	LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(totalInt);
    	ArrayList<Integer> cleanedList = new ArrayList<>(hashSet);

    	// sorting the ArrayList
    	//Collections.sort(cleanedList);
    	System.out.println("After getting rid of duplicates: " + cleanedList);

        for (int i = 0; i < b.size(); i++) {
            int num = b.get(i);
            for (int j = 0; j < cleanedList.size(); j++) {
                if (num % cleanedList.get(j) != 0) {
                    cleanedList.remove(j);
                } 
            }
        }
        
    	System.out.println("After checking with elements from b array: " + cleanedList);
    	
    	
    	for (int i = 0; i < cleanedList.size(); i++) {
    		for (int j = 0; j < a.size(); j++) {
    			if (cleanedList.get(i) % a.get(j) != 0) {
                    cleanedList.remove(i);
                }
    		}
    	}
    	
    	
    	System.out.println(cleanedList);
    	
    	int intsBetweenSets = cleanedList.size();
    	
    	System.out.println(intsBetweenSets);
    


    }

}
