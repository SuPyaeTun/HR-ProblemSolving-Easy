package sequenceEquation;

public class TesterOne {

	public static void main(String[] args) {
		
		int[] p = new int[] {5, 2, 1, 3, 4};
		
		int[] result = permutationEquation(p);
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}
	
	static int[] permutationEquation(int[] p) {
    	int[] result = new int[p.length];
    	int limit = p.length;
    	int y = 0;
    	
    	for (int x = 1; x <= limit; x++) {
    		System.out.print("When x is " + x + " , ");
    		int outerY = calculateIndex(p, x);
    		System.out.print("The outer Y : " + outerY);
    		y = calculateIndex(p, outerY);
    		System.out.println(". And y is " + y + ".");
    		result[x-1] = y;
    	}
    	
    	return result;
    }
	
	static int calculateIndex (int[] p,int x) {
		int index = 0;
		for (int i = 0; i < p.length; i++) {
			if (p[i] == x) {
				index = i+1;
			}
		}
		return index;
	}

}
