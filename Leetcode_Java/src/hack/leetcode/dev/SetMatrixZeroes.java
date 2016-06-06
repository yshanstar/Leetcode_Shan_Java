package hack.leetcode.dev;

/*
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		boolean hasZeroFirstRow = false;
		boolean hasZeroFirstCol = false;

		if (matrix.length == 0) {
			return;
		} else if (matrix[0].length == 0) {
			return;
		}

		int idx = 0;
		while (idx < matrix.length) {
			if (matrix[idx][0] == 0) {
				hasZeroFirstCol = true;
			}
			idx++;
		}

		idx = 0;
		while (idx < matrix[0].length) {
			if (matrix[0][idx] == 0) {
				hasZeroFirstRow = true;
			}
			idx++;
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (hasZeroFirstRow) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}

		if (hasZeroFirstCol) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}
