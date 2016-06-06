package hack.leetcode.dev;

/*
 * 	Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *	Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid == null) {
			return 0;
		}
		if (grid.length == 0) {
			return 0;
		}
		if (grid[0].length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			dp[i][0] = (i - 1 >= 0) ? dp[i - 1][0] + grid[i][0] : grid[i][0];
		}

		for (int i = 0; i < n; i++) {
			dp[0][i] = (i - 1 >= 0) ? dp[0][i - 1] + grid[0][i] : grid[0][i];
		}

		if (m == 1) {
			return dp[0][n - 1];
		}
		if (n == 1) {
			return dp[n - 1][0];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}

		return dp[m - 1][n - 1];
	}
}
