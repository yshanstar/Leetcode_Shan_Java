package hack.leetcode.dev;

/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:
 *
	 [
		 [1,   3,  5,  7],
		 [10, 11, 16, 20],
		 [23, 30, 34, 50]
	 ]
 * Given target = 3, return true.
 */
public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null) {
			return false;
		}
		int upperRow = 0;
		int lowerRow = matrix.length - 1;

		while (upperRow < lowerRow) {
			int row = (lowerRow + upperRow) / 2 + 1;
			if (matrix[row][0] == target) {
				return true;
			} else if (matrix[row][0] > target) {
				lowerRow = row - 1;
			} else {
				upperRow = row + 1;
			}
		}

		upperRow = Math.min(upperRow, lowerRow);

		int left = 0;
		int right = matrix[upperRow].length - 1;
		
		if (left == right) {
			return (matrix[upperRow][left] == target);
		}
		
		while (left < right) {
			int col = (left + right) / 2 + 1;
			if (matrix[upperRow][col] == target) {
				return true;
			} else if (matrix[upperRow][col] > target) {
				right = col - 1;
			} else {
				left = col + 1;
			}
		}

		if (left == right) {
			return (matrix[upperRow][left] == target);
		}
		return false;
	}
}
