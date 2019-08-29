package designerPDFViewer;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * When you select a contiguous block of text in a PDF viewer, the selection is highlighted with a blue rectangle. 
 * In this PDF viewer, each word is highlighted independently. In this challenge, you will be given a list of letter heights 
 * in the alphabet and a string. 
 * Using the letter heights given, determine the area of the rectangle highlight in mm^2, assuming all letters are 1mm wide.
 * Example: highlighted word = "torn" | heights of the letters are t=2, o=1, r=1 and n=1
 *             The tallest letter is 2 and there are 4 letters
 *             Therefore, highlighted area = 2 * 4 = 8mm^2 --> 8 
 *             
 * @author sutun
 *
 */
public class Solution {

    /**
     * Calculate the highlighted area, using the values of lowercase a to z from integer array
     * @param h - an array of integers representing the heights of each letter from a-z
     * @param word - a string
     * @return an integer representing the size of the highlighted area
     */
    static int designerPdfViewer(int[] h, String word) {
        int maxHeight = 0;
        List<String> alphabet = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        HashMap<String, Integer> alphaMap = new HashMap<String, Integer>();
        
        for (int i = 0; i < alphabet.size(); i++) {
            alphaMap.put(alphabet.get(i), h[i]);
        }
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (alphaMap.containsKey(Character.toString(ch))) {
                if (maxHeight < alphaMap.get(Character.toString(ch))) {
                    maxHeight = alphaMap.get(Character.toString(ch));
                }
            }
        }
        
        int highlightedArea = maxHeight * word.length();
        return highlightedArea;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

