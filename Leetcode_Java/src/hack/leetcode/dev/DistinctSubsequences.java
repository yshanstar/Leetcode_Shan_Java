package hack.leetcode.dev;

/*
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) 
 * of the characters without disturbing the relative positions of the remaining characters. 
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3. s
 */
public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = S.length();
		int m = T.length();
		int dp[] = new int[m];
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				if (T.charAt(j) == S.charAt(i)) {
					if (j == 0)
						dp[0]++;
					else {
						dp[j] += dp[j - 1];
					}
				}
			}
		}
		return dp[m - 1];
	}

	public static void main(String[] args) {
		DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
		distinctSubsequences.numDistinct("aacaaccac", "ca");
	}
}
