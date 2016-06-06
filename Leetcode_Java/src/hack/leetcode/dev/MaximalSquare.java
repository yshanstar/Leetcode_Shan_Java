package hack.leetcode.dev;

/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 * For example, given the following matrix:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 */
public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			dp[i][0] = Character.getNumericValue(matrix[i][0]);
		}

		for (int i = 0; i < n; i++) {
			dp[0][i] = Character.getNumericValue(matrix[0][i]);
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					int min = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
					min = Math.min(min, dp[i][j - 1]);
					dp[i][j] = min + 1;
				} else {
					dp[i][j] = 0;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] > max) {
					max = dp[i][j];
				}
			}
		}

		return max * max;
	}
}
