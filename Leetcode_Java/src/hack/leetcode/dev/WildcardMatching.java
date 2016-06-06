package hack.leetcode.dev;

/*
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") â†? false
 * isMatch("aa","aa") â†? true
 * isMatch("aaa","aa") â†? false
 * isMatch("aa", "*") â†? true
 * isMatch("aa", "a*") â†? true
 * isMatch("ab", "?*") â†? true
 * isMatch("aab", "c*a*b") â†? false
 */
public class WildcardMatching {
	public static boolean isMatch(String s, String p) {
		if (s == null && p == null) {
			return true;
		}
		if (s == null || p == null) {
			return false;
		}

		if (p.startsWith("*")) {
			if (p.substring(1).endsWith("*")) {
				if (s.contains(p.subSequence(1, p.length() - 1)))
					return true;
				if (p.subSequence(1, p.length() - 1).toString().contains(s))
					return false;
			}
		}

		boolean match[][] = new boolean[s.length() + 1][p.length() + 1];
		match[0][0] = true;

		for (int i = 1; i <= p.length(); i++) {
			match[0][i] = match[0][i - 1] && p.charAt(i - 1) == '*';
		}

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= p.length(); j++) {
				if (p.charAt(j - 1) == '*') {
					match[i][j] = match[i - 1][j - 1] || match[i - 1][j] || match[i][j - 1] ;
				} else if (p.charAt(j - 1) == '?') {
					match[i][j] = match[i - 1][j - 1];
				} else {
					match[i][j] = match[i - 1][j - 1] && p.charAt(j - 1) == s.charAt(i - 1);
				}

			}
		}
		return match[s.length()][p.length()];
	}

	public static void main(String[] args) {
		System.out.println(isMatch("aa", "aa"));
	}
}
