package designerPDFViewer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class tester {

	public static void main(String[] args) {
		
		int[] h = new int[26];
		for (int i = 0; i < h.length; i++) {
			h[i] = (int) (1 + (Math.random() * 5));
		}

		System.out.println(Arrays.toString(h));
		
		String test1 = "abc";
		String test2 = "xyzabc";
		
		String word = test1;
		
		int maxHeight = 0;
    	List<String> alphabet = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
    	HashMap<String, Integer> alphaMap = new HashMap<String, Integer>();
    	
    	for (int i = 0; i < alphabet.size(); i++) {
    		alphaMap.put(alphabet.get(i), h[i]);
    	}
    	
    	alphaMap.entrySet().forEach(entry->{System.out.println(entry.getKey() + " " + entry.getValue()); });
    	
    	
    	for (int i = 0; i < word.length(); i++) {
    		char ch = word.charAt(i);
    		if (alphaMap.containsKey(Character.toString(ch))) {
    			int height = alphaMap.get(Character.toString(ch));
    			System.out.println(height);
    			if (maxHeight < height) {
    				maxHeight = height;
    			}
    		}
    	}
    	System.out.println(maxHeight);
    	int highlightedArea = maxHeight * word.length();
    	System.out.println(highlightedArea);

	}

}
