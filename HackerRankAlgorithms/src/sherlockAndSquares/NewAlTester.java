package sherlockAndSquares;

import java.util.ArrayList;

public class NewAlTester {

	public static void main(String[] args) {
		int lowerB = 3;
		int upperB = 999;
		long startTime = System.currentTimeMillis();
		System.out.println(squares(lowerB, upperB));
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime + " ms");

	}

	static int squares(int a, int b) {
		
		return (int) ( Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
		
    }
}
