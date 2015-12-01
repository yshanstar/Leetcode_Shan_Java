package solution;

/*
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?
 */
public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int[] dp = new int[m];
		dp[0] = 1;

		for (int col = 0; col < n; col++) {
			for (int row = 1; row < m; row++) {
				dp[row] = dp[row - 1] + dp[row];
			}
		}

		return dp[m - 1];
	}
}
