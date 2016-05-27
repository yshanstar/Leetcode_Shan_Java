package solution;

/*
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

http://blog.csdn.net/abcbc/article/details/8978146
 */
public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
		int[][] dp = new int[t.length() + 1][s.length() + 1];
		dp[0][0] = 1;

		// dp[1...T.length()-1][0] = 0 when S is empty
		for (int i = 1; i <= t.length(); i++) {
			dp[i][0] = 0;
		}

		// dp[0][1....S.length()-1] = 1 when t is empty
		for (int j = 1; j <= s.length(); j++) {
			dp[0][j] = 1;
		}

		for (int i = 1; i <= t.length(); i++) {
			for (int j = 1; j <= s.length(); j++) {
				dp[i][j] = dp[i][j - 1];
				if (t.charAt(i - 1) == s.charAt(j - 1)) {
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}

		return dp[t.length()][s.length()];
	}
}
