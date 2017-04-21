/**
 * 
 */

/**
 * @author rashmi.paliwal
 *
 */
public class MatrixMultiplication {
	
	public static void main(String[] args) {
		int[][] arr1 = {{2, 2, 2},
						{2, 2, 2},
						{2, 2, 2}};
		
		int[][] arr2 = {{3, 3, 3},
				{4, 3, 3},
				{3, 3, 3}};
		
		int[][] arr3 = new int[3][3];
		
		boolean canMultiply = multiply(arr1, arr2, arr3);
		
		if (canMultiply) {
			System.out.println("Can not multiple the matrix.");
		}
		
		for (int i = 0; i < arr3.length; i++) {
			System.out.println();
			for (int j = 0; j < arr3[0].length; j++) {
				System.out.print(" " + arr3[i][j]);
			}
		}
	}
	
	public static boolean multiply(int[][] arr1, int[][] arr2, int[][] arr3) {
		boolean canMultiply = true;
		if (arr1[0].length != arr2.length) {
			return false;
		}
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				for (int k = 0; k < arr2[0].length; k++) {
					arr3[i][k] = arr3[i][k] + (arr1[i][j] * arr2[j][k]); 
				}
			}
		}
		
		return true;
	}
}
