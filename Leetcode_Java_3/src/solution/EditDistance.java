package solution;

public class EditDistance {
	public int minDistance(String word1, String word2) {
		int row = word1.length() + 1;
		int col = word2.length() + 1;
		int[][] dp = new int[row][col];

		for (int i = 0; i < row; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j < col; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int edit = dp[i - 1][j - 1] + 1;
					int add = dp[i][j - 1] + 1;
					int del = dp[i - 1][j] + 1;
					dp[i][j] = Math.min(edit, Math.min(add, del));
				}
			}
		}

		return dp[row - 1][col - 1];
	}
}
