package solution;

/*
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		if (matrix.length == 0) {
			return;
		} else if (matrix[0].length == 0) {
			return;
		}

		boolean hasZeroFirstRow = false;
		boolean hasZeroFirstCol = false;

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				hasZeroFirstCol = true;
				break;
			}
		}

		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				hasZeroFirstRow = true;
				break;
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (hasZeroFirstCol) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}

		if (hasZeroFirstRow) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}
	}
}
