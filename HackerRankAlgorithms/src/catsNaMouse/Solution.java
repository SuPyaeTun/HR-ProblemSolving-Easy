package catsNaMouse;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    /**
     * To determine which cat will reach the mouse first, assuming the mouse
     * doesn't move and the cats travel at equal speed. If the cats arrive at 
     * the same time, the mouse will be allowed to move and it will escape while
     * they fight. 
     * 
     * @param x - an integer, Cat A's position
     * @param y - an integer, Cat B's position
     * @param z - an integer, Cat C's position
     * @return a String - "Cat A" if cat A catches the mouse first
     * 					- "Cat B" if cat B catches the mouse first
     * 					- "Mouse C" if the mouse escapes
     */
    static String catAndMouse(int x, int y, int z) {
   
    	String result = "";
        int distAtoC = Math.abs(z-x);
        int distBtoC = Math.abs(z-y);
        
        if (distAtoC == distBtoC) {
            result = "Mouse C";
        } else if (distAtoC > distBtoC) {
            result = "Cat B";
        } else if (distAtoC < distBtoC) {
            result = "Cat A";
        }
        return result;
    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
