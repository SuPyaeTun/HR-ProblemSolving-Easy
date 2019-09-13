package equalizeTheArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class TesterOne {

	public static void main(String[] args) {
		int[] arr = {2, 1, 3};
		// int[] arr = {1, 2, 2, 3};
		ArrayList<Integer> keyList = new ArrayList<Integer>();
		for (int index = 0; index < arr.length; index++) {
				keyList.add(arr[index]);
		}
		
		System.out.println(Arrays.toString(keyList.toArray()));
		
		HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>(); 
		
		for (int index = 0; index < keyList.size(); index++) {
			int key = keyList.get(index);
			if (!frequencyMap.containsKey(key)) {
				int freq = Collections.frequency(keyList, key);
				frequencyMap.put(key, freq);
			}			
		}
		
		System.out.println(frequencyMap);

		int maxFrequency = Collections.max(frequencyMap.values());
		System.out.println(maxFrequency);
		
		int minDeletions = arr.length - maxFrequency;
		System.out.println(minDeletions);
	}

}
