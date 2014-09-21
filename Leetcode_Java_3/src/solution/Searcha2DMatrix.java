package solution;

public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		int rowLength = matrix[0].length;
		int start = 0;
		int end = rowLength * matrix.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			int rowIdx = mid / rowLength;
			int colIdx = mid % rowLength;

			if (matrix[rowIdx][colIdx] == target) {
				return true;
			} else if (matrix[rowIdx][colIdx] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return false;
	}
}
