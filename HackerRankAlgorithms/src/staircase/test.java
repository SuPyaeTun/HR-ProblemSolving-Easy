package staircase;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 9;
		int counter = n;
		for (int i = 0; i < n; i++) {
			for (int j = counter - 1; j > 0; j--) {
				System.out.print(" ");
			}
			for (int k = counter-1; k < n; k++) {
				System.out.print("#");
			}
			
			System.out.println("");
			--counter;
		}
	}

}
