package solution;

/*
 * 给一个int[][]的matirx，对于一条从左上到右下的path p_i，p_i中的最小值是m_i，求所有m_i中的最大值。只能往下或右.
比如：
[8, 4, 7]
[6, 5, 9]
有3条path：
8-4-7-9 min: 4
8-4-5-9 min: 4
8-6-5-9 min: 5
return: 5
 */
public class MaximumMinimumPath {
	private int min, max, row, col;

	public int getMaxMin(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dp = new int[m][n];
		dp[0][0] = matrix[0][0];

		for (int i = 1; i < m; i++) {
			dp[i][0] = Math.min(dp[i - 1][0], matrix[i - 1][0]);
		}

		for (int i = 1; i < n; i++) {
			dp[0][i] = Math.min(dp[0][i - 1], matrix[0][i]);
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.min(Math.max(dp[i - 1][j], dp[i][j - 1]), matrix[i][j]);
			}
		}

		return dp[m - 1][n - 1];
	}

	public int maxMinPath(int[][] matrix) {
		row = matrix.length;
		col = matrix[0].length;
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		dfsHelper(matrix, min, 0, 0);
		return max;
	}

	public void dfsHelper(int[][] matrix, int min, int i, int j) {
		if (i >= row || j >= col)
			return;
		if (i == row - 1 && j == col - 1) {
			min = Math.min(min, matrix[i][j]);
			max = Math.max(max, min);
			return;
		}
		min = Math.min(min, matrix[i][j]);
		dfsHelper(matrix, min, i, j + 1);
		dfsHelper(matrix, min, i + 1, j);
	}

	public static void main(String[] args) {
		MaximumMinimumPath test = new MaximumMinimumPath();
		int[][] matrix = new int[][] { { 8, 4, 7 }, { 6, 5, 9 } };
		System.out.println(test.maxMinPath(matrix));
		System.out.println(test.getMaxMin(matrix));
	}
}
