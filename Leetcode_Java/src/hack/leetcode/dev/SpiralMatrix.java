package hack.leetcode.dev;

import java.util.ArrayList;

/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (matrix == null || matrix.length <= 0) {
			return res;
		}

		int startRow = 0;
		int endRow = matrix.length - 1;

		int startCol = 0;
		int endCol = matrix[0].length - 1;

		while (true) {
			for (int i = startCol; i <= endCol; i++) {
				res.add(matrix[startRow][i]);
			}
			startRow++;
			if (startRow > endRow) {
				break;
			}

			for (int i = startRow; i <= endRow; i++) {
				res.add(matrix[i][endCol]);
			}
			endCol--;
			if (startCol > endCol) {
				break;
			}

			for (int i = endCol; i >= startCol; i--) {
				res.add(matrix[endRow][i]);
			}
			endRow--;
			if (startRow > endRow) {
				break;
			}

			for (int i = endRow; i >= startRow; i--) {
				res.add(matrix[i][startCol]);
			}
			startCol++;
			if (startCol > endCol) {
				break;
			}
		}

		return res;
	}
}
