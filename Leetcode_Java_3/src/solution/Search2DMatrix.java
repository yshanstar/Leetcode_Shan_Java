package solution;

/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int rowLength = matrix[0].length;

		int low = 0;
		int high = matrix.length * rowLength - 1;

		while (low <= high) {
			int mid = (high + low) / 2;

			int rowIdx = mid / rowLength;
			int colIdx = mid % rowLength;

			if (matrix[rowIdx][colIdx] == target) {
				return true;
			} else if (matrix[rowIdx][colIdx] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return false;
	}

}
