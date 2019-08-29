package birthdayChocolate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testOne {
	public static void main(String[] args) {
		
		List<Integer> s = new ArrayList<Integer>(5);
		s.add(1);
		s.add(2);
		s.add(1);
		s.add(3);
		s.add(2);
		int d = 3;
		int m = 2;
		
		int result = birthday(s, d, m);
		System.out.print(result);
		
	}

	static int birthday(List<Integer> s, int d, int m) {
    	int numOfDivision = 0; 
    	
    	for (int index = 0; index <= s.size()-m; index++) {
    		int sum = 0;
    		for (int counter = index; counter < m+index; counter++) {
    			System.out.print("Index: " + counter);
    			sum += s.get(counter);
    			System.out.println(" and sum = " + sum);
    		}
    		if (sum == d) {
    			System.out.println("Sum : " + sum + ", d: " + d);
    			++numOfDivision;
    		}
    	}	
    	return numOfDivision;
    }
}
