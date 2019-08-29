package betweenTwoSets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class testerFive {
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>(Arrays.asList(2));

	    List<Integer> b = new ArrayList<>(Arrays.asList(20, 30, 12));
	    
	    Collections.sort(a);
    	Collections.sort(b);
	    
	 // ****************************************************************
        // looking for factors of x && elements of a array
        ArrayList<Integer> factorOfX = new ArrayList<Integer>();
        for (int i = a.get(0); i <= b.get(0); i++) {
        	for (int j = 0; j < a.size(); j++) {
        		if (i % a.get(j) == 0) {
        			factorOfX.add(i);
        		}
        	}
        }
        System.out.println(factorOfX);
        
        //LinkedHashSet will remove duplicated elements and 
        // maintain the order of elements added to it
        LinkedHashSet<Integer> hashSetA = new LinkedHashSet<>(factorOfX);
    	ArrayList<Integer> cleanedFofX = new ArrayList<>(hashSetA);
    	Collections.sort(cleanedFofX);
    	System.out.println(cleanedFofX);
    	
    	// ****************************************************************
    	// looking for factor of all elements in b array
    	ArrayList<Integer> factorOfB = new ArrayList<Integer>();
    	for (int i = 0; i < b.size();i++) {
    		int num = b.get(i);
    		for (int j = 1; j <= num; j++) {
    			if (num % j == 0) {
    				factorOfB.add(j);
    			}
    		}
    	}
    	System.out.println(factorOfB);
    	
    	LinkedHashSet<Integer> hashSetB = new LinkedHashSet<>(factorOfB);
    	ArrayList<Integer> cleanedFofB = new ArrayList<>(hashSetB);
    	Collections.sort(cleanedFofB);
    	System.out.println(cleanedFofB);
    	
    	// ****************************************************************
    	// comparing the Two ArrayList to look for the command elements
    	ArrayList<Integer> totalInt = new ArrayList<Integer>();
    	
    	for (int i = 0; i < cleanedFofX.size(); i++) {
    		for (int j = 0; j < cleanedFofB.size(); j++) {
    			if (cleanedFofX.get(i) == cleanedFofB.get(j)) {
    				totalInt.add(cleanedFofB.get(j));
    			}
    		}
    	}
    	
    	System.out.println("The duplicated elements are: ");
    	System.out.print(totalInt);
    	System.out.println();
    	
    	for (int i = 0; i < totalInt.size(); ++i) {
    		
    		for (int j = 0; j < a.size(); j++) {
    			
    			if (totalInt.get(i) % a.get(j) > 0) {
    				totalInt.remove(i);
    				--i;
    			}
    		}
    	}
    	

    	for (int i = 0; i < totalInt.size(); ++i) {
    		
    		for (int j = 0; j < b.size(); j++) {
    			
    			if (b.get(j) % totalInt.get(i) > 0) {
    				totalInt.remove(i);
    				--i;
    			}
    		}
    	}
        
    	System.out.println(totalInt);
		/*
    	for (int i = 0; i < totalInt.size(); i++) {	
    		for (int j = 0; j < a.size(); j++) {
    			int dividend = totalInt.get(i);
        		System.out.print("(x) " + dividend + " % ");
    			
    			int divisor = a.get(j);
    			System.out.print("(a) " + divisor + " = ");
    			
    			int remainder = dividend % divisor;
    			System.out.println(remainder);
    			if (remainder > 0) {
    				System.out.println("Index of totalInt we are going to remove is " + i);
    				totalInt.remove(i);
    			}
    		}
    	}
        */
	}
}
