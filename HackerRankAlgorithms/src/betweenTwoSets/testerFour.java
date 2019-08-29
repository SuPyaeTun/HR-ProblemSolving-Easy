package betweenTwoSets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testerFour {
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>(Arrays.asList(3, 4));

        List<Integer> b = new ArrayList<>(Arrays.asList(24, 48));
        
    	// ****************************************************************
        // looking for factors of x && elements of a array
        ArrayList<Integer> factorOfX = new ArrayList<Integer>();
        
        // looking for x 
        for (int i = a.get(0); i <= b.get(0); i++) {
        	for (int j = 0; j < a.size(); j++) {
        		if (i % a.get(j) == 0) {
        			factorOfX.add(i);
        		}
        	}
        }
        System.out.println(factorOfX);
        
        // for every elements in factorOfX arraylist 
        for (int i = 0; i < factorOfX.size(); i++) {
        	for (int j = 0; j < a.size(); j++) {
        		if (factorOfX.get(i) % a.get(j) != 0) {
        			factorOfX.remove(i);
        		}
        	}
        }
        
        System.out.println(factorOfX);
	}
}
