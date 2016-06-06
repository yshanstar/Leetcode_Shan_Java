package hack.leetcode.dev;

/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
	 [
		 [ 1, 2, 3 ],
		 [ 8, 9, 4 ],
		 [ 7, 6, 5 ]
	 ]
 */
public class SpiralMatrixII2 {
	public static int[][] generateMatrix(int n) {
		if (n < 0)
			return null;
		if (n == 0) {
			return new int[0][];
		}
		int start = 0;
		int end = n - 1;
		int num = 1;
		int[][] matrix = new int[n][n];

		while (start < end) {
			for (int i = start; i < end; i++) {
				matrix[start][i] = num;
				num++;
			}
			for (int i = start; i < end; i++) {
				matrix[i][end] = num;
				num++;
			}
			for (int i = end; i > start; i--) {
				matrix[end][i] = num;
				num++;
			}
			for (int i = end; i > start; i--) {
				matrix[i][start] = num;
				num++;
			}
			start++;
			end--;
		}
		
		if (start == end) {
			matrix[start][end] = num;
		}

		return matrix;
	}
	
	public static void main(String[] args){
		System.out.println(generateMatrix(4));
	}
}
