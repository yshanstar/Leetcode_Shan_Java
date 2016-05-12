package solution;

import java.util.Arrays;

/*
 * Follow up for N-Queens problem.
Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueensII {
	int res;

	public int totalNQueens(int n) {
		res = 0;
		int[] colUsed = new int[n];
		Arrays.fill(colUsed, -1);
		dfs(colUsed, 0);

		return res;
	}

	private void dfs(int[] colUsed, int row) {
		int n = colUsed.length;
		if (row == n) {
			res++;
			return;
		}

		for (int col = 0; col < n; col++) {
			if (isValid(colUsed, row, col)) {
				colUsed[row] = col;
				dfs(colUsed, row + 1);
			}
		}
	}

	private boolean isValid(int[] colUsed, int row, int col) {
		for (int i = 0; i < row; i++) {
			// Excludes used columns and diagonal positions
			// (x2-x1)/(y2-y1) == 1 or -1
			if (colUsed[i] == col || row - i == Math.abs(col - colUsed[i])) {
				return false;
			}
		}

		return true;
	}
}
