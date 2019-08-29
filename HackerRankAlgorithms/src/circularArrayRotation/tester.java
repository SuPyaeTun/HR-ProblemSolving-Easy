package circularArrayRotation;

// Test case with k > m
public class tester {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] arrayOne = new int[100];
		
		for (int i = 0; i < arrayOne.length; i++) {
			arrayOne[i] = i+1;
		}
		
		
		int rotation = 25;
		int[] queries = {0, 99};
		
		for (int i = 0; i < arrayOne.length; i++) {
			System.out.print(arrayOne[i] + " ");
		}
		
		System.out.println();
		
		for (int i = 0; i < rotation; i++) {
			int last = arrayOne[arrayOne.length-1];
			for (int j = arrayOne.length-1; j > 0; j--) {
				arrayOne[j] = arrayOne[j-1];
			}
			arrayOne[0] = last;
			for (int w = 0; w < arrayOne.length; w++) {
				System.out.print(arrayOne[w] + " ");
			}
			System.out.println();
		}
		
		int[] qArray = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			qArray[i] = arrayOne[queries[i]];
		}
		

		for (int i = 0; i < qArray.length; i++) {
			System.out.print(qArray[i] + " ");
		}
		
		System.out.println();
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " milliseconds");
	}
}
