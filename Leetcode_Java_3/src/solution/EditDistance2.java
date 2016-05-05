package solution;

/*
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
 */
public class EditDistance2 {
	public int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null) {
			return 0;
		}

		if (word1.length() == 0 && word2.length() == 0) {
			return 0;
		}

		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			dp[i][0] = i;
		}

		for (int i = 0; i <= n; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(word1.charAt(i-1) == word2.charAt(j-1)){
					dp[i][j] = dp[i - 1][j - 1];
				}else{
					int edit = dp[i - 1][j - 1] + 1;
					int add = dp[i][j - 1] + 1;
					int del = dp[i - 1][j] + 1;
					dp[i][j] = Math.min(Math.min(edit, add), del);
				}
			}
		}
		
		return dp[m][n];
	}
}
