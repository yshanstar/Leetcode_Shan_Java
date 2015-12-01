package hack.leetcode.dev;

/*
 * Given two sparse matrices A and B, return the result of AB.

 You may assume that A's column number is equal to B's row number.

 Example:

 A = [
 [ 1, 0, 0],
 [-1, 0, 3]
 ]

 B = [
 [ 7, 0, 0 ],
 [ 0, 0, 0 ],
 [ 0, 0, 1 ]
 ]


 |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 | 0 0 1 |
 */
public class SparseMatrixMultiplication {
	public int[][] multiply(int[][] A, int[][] B) {
		if (A.length == 0 || B.length == 0) {
			return new int[0][0];
		}

		int row = A.length;
		int col = A[0].length;
		int colB = B[0].length;

		int[][] res = new int[row][colB];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (A[i][j] != 0) {
					for (int colIdx = 0; colIdx < colB; colIdx++) {
						if (B[j][colIdx] != 0) {
							res[i][colIdx] += A[i][j] * B[j][colIdx];
						}
					}
				}
			}
		}

		return res;
	}
}
