package migratoryBirds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tester {
	public static void main(String[] args) {
		
		List<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4));
		System.out.println(migratoryBirds(arr));
		
	}
	
	static int migratoryBirds(List<Integer> arr) {
    	
    	int oneCounter, twoCounter, threeCounter, fourCounter, fiveCounter;
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
    	
    	System.out.println(oneCounter);
    	System.out.println(twoCounter);
    	System.out.println(threeCounter);
    	System.out.println(fourCounter);
    	System.out.println(fiveCounter);
    	
    	int max = oneCounter;
    	int mfSightedBirds = 1;
    	
    	if (mfSightedBirds < twoCounter) {
    		max = twoCounter;
    		mfSightedBirds = 2;
    		System.out.println("Type 1 is less than Type 2");
    	} 
    	if (mfSightedBirds < threeCounter) {
    		max = threeCounter;
    		mfSightedBirds = 3;
    		System.out.println("Type 2 is less than Type 3");
    	} 
    	if (mfSightedBirds < fourCounter) {
    		max = fourCounter;
    		mfSightedBirds = 4;
    		System.out.println("Type 3 is less than Type 4");
    	} 
    	if (mfSightedBirds < fiveCounter) {
    		max = fiveCounter;
    		mfSightedBirds = 5;
    		System.out.println("Type 4 is less than Type 5");
    	}
    	
    	return mfSightedBirds;
    }
}
