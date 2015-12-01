package solution;

/*
 * Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.
 */
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
			return 0;
		}

		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;

		int[][] res = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (obstacleGrid[i][j] == 1) {
					res[i][j] = 0;
				} else if (i == 0 && j == 0) {
					res[i][j] = 1;
				} else if (i == 0) {
					res[i][j] = res[i][j - 1];
				} else if (j == 0) {
					res[i][j] = res[i - 1][j];
				} else {
					res[i][j] = res[i - 1][j] + res[i][j - 1];
				}
			}
		}
		return res[row - 1][col - 1];
	}

	public int uniquePathsWithObstaclesII(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
			return 0;
		}

		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;

		int[] dp = new int[col];
		dp[0] = 1 - obstacleGrid[0][0];

		for (int i = 1; i < col; i++) {
			dp[i] = dp[i - 1] * (1 - obstacleGrid[0][i]);
		}

		for (int i = 1; i < row; i++) {
			dp[0] *= (1 - obstacleGrid[i][0]);

			for (int j = 1; j < col; j++) {
				dp[j] = (dp[j - 1] + dp[j]) * (1 - obstacleGrid[i][j]);
			}
		}

		return dp[col - 1];
	}
}
