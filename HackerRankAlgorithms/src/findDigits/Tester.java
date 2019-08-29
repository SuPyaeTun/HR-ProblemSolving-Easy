package findDigits;

public class Tester {

	public static void main(String[] args) {
		int[] testArray = new int[] {11, 123456789, 114108089,110110015, 121, 33, 44, 55, 66, 77, 88, 106108048};

		for (int i = 0; i < testArray.length; i++) {
			System.out.print("The input is : " + testArray[i] + ". ");
			System.out.println("The number of divisors is " + findDigits(testArray[i]));
			System.out.println();
		}
	}
	
	static int findDigits(int n) {
    	int numOfDivisors = 0;
    	int d = n; 
    	
    	while (d > 0) {
    		
    		int digit = d % 10;
    		if (digit > 0 && n % digit == 0 ) {
        			++numOfDivisors;
        		}
    		d /= 10;
    		}
 
    	return numOfDivisors;
    }

}
