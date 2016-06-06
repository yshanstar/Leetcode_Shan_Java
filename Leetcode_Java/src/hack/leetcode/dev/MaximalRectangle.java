package hack.leetcode.dev;

/*
 * 	Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
public class MaximalRectangle {
	public static int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0) {
			return 0;
		}
		int[][] matrixNum = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			matrixNum[i][0] = (matrix[i][0] == '1') ? 1 : 0;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				matrixNum[i][j] = (matrix[i][j] == '1') ? matrixNum[i][j - 1] + 1 : 0;
			}
		}

		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int k = i;
				int width = Integer.MAX_VALUE;

				while (k >= 0) {
					if (matrixNum[k][j] == 0) {
						break;
					}
					width = Math.min(width, matrixNum[k][j]);
					max = Math.max(max, width * (i - k + 1));
					k--;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		char[][] matrix = new char[3][4];
		matrix[0][0] = '0';
		matrix[0][1] = '1';
		matrix[0][2] = '1';
		matrix[0][3] = '0';
		matrix[1][0] = '0';
		matrix[1][1] = '0';
		matrix[1][2] = '1';
		matrix[1][3] = '0';
		matrix[2][0] = '0';
		matrix[2][1] = '1';
		matrix[2][2] = '1';
		matrix[2][3] = '0';
		System.out.println(maximalRectangle(matrix));
	}
}
