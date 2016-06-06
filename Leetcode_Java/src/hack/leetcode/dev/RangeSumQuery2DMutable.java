package hack.leetcode.dev;

/*
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

 Range Sum Query 2D
 The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

 Example:
 Given matrix = [
 [3, 0, 1, 4, 2],
 [5, 6, 3, 2, 1],
 [1, 2, 0, 1, 5],
 [4, 1, 0, 1, 7],
 [1, 0, 3, 0, 5]
 ]

 sumRegion(2, 1, 4, 3) -> 8
 update(3, 2, 2)
 sumRegion(2, 1, 4, 3) -> 10
 Note:
 The matrix is only modifiable by the update function.
 You may assume the number of calls to update and sumRegion function is distributed evenly.
 You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class RangeSumQuery2DMutable {
	int[][] rowSum;
	int[][] matrix;

	public RangeSumQuery2DMutable(int[][] matrix) {
		int m = matrix.length;
		if (m == 0 || matrix[0].length == 0) {
			return;
		}

		int n = matrix[0].length;
		this.matrix = matrix;
		rowSum = new int[m][n + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 1; j <= n; j++) {
				rowSum[i][j] = rowSum[i][j - 1] + matrix[i][j - 1];
			}
		}
	}

	public void update(int row, int col, int val) {
		int diff = val - matrix[row][col];
		for (int j = col + 1; j <= matrix[0].length; j++) {
			rowSum[row][j] += diff;
		}
		matrix[row][col] = val;
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int sum = 0;
		for (int i = row1; i <= row2; i++) {
			sum += rowSum[i][col2 + 1] - rowSum[i][col1];
		}

		return sum;
	}
}
