package solution;

/*
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") -> false
 isMatch("aa","aa") -> true
 isMatch("aaa","aa") -> false
 isMatch("aa", "*") -> true
 isMatch("aa", "a*") -> true
 isMatch("ab", "?*") -> true
 isMatch("aab", "c*a*b") -> false
 */
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		if ((s == null && p == null) || (s.length() == 0 && p.length() == 0)) {
			return true;
		}

		int m = s.length();
		int n = p.length();

		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;

		for (int i = 1; i <= m; i++) {
			dp[m][0] = false;
		}

		for (int i = 1; i <= n; i++) {
			dp[0][i] = (dp[0][i - 1] && p.charAt(i - 1) == '*');
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (p.charAt(j - 1) == '?'
						|| s.charAt(i - 1) == p.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		WildcardMatching test = new WildcardMatching();
		System.out.println(test.isMatch("aa", "*"));
	}
}
