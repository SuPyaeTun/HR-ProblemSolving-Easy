package betweenTwoSets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class testerThree {
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>(Arrays.asList(3, 4));

        List<Integer> b = new ArrayList<>(Arrays.asList(24, 48));
        
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
    	
    	System.out.println("The command elements are: ");
    	System.out.print(totalInt);
    	System.out.println();
    	
    	for (int i = 0; i < totalInt.size(); ++i) {
    		
    		for (int j = 0; j < a.size(); j++) {
    			
    			int dividend = totalInt.get(i);
        		System.out.print("(x) " + dividend);
        		System.out.print(" % ");
    			
    			int divisor = a.get(j);
    			System.out.print("(a) " + divisor);
    			System.out.print(" = ");
    			System.out.print(dividend % divisor);
    			
    			int remainder = dividend % divisor;
    			System.out.println(" .The remainder is " + remainder);
    			if (remainder > 0) {
    				totalInt.remove(i);
    				--i;
    			}
    		}
    	}
        
    	System.out.println(totalInt);
	}

}
