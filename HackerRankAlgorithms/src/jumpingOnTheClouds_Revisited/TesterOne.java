package jumpingOnTheClouds_Revisited;

public class TesterOne {

	public static void main(String[] args) {
		int[] c = {1, 1, 1, 0, 1, 1, 0, 0, 0, 0};
		int k = 3;
		
		int energyLevel = 100;				// default energy level at the start of the game
		
		// There is an input constraint: n%k = 0
		// This algorithm will only work if the input fulfills this constraint
		
			for (int index = 0; index < c.length; index++) {
	    		if (c[index] == 1) {
	    			energyLevel -= 2;
	    		}
	    		energyLevel -= 1;
	    		index += k - 1;
	    	}
		
    	
    	System.out.println(energyLevel);
	}

}
