package hack.leetcode.dev;

/*
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString2 {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null && s2 == null && s3 == null) {
			return true;
		} else if (s3 == null) {
			return false;
		} else if (s1 == null) {
			return s3.equals(s2);
		} else if (s2 == null) {
			return s3.equals(s1);
		}

		if (s3.length() != s1.length() + s2.length()) {
			return false;
		}

		boolean match[][] = new boolean[s1.length() + 1][s2.length() + 1];
		match[0][0] = true;

		for (int i = 1; i <= s1.length(); i++) {
			if (s3.charAt(i - 1) == s1.charAt(i - 1)) {
				match[i][0] = match[i - 1][0];
			}
		}

		for (int i = 1; i <= s2.length(); i++) {
			if (s3.charAt(i - 1) == s2.charAt(i - 1)) {
				match[0][i] = match[0][i - 1];
			}
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				match[i][j] = ((s3.charAt(i + j - 1) == s1.charAt(i - 1)) && match[i - 1][j])
						|| ((s3.charAt(i + j - 1) == s2.charAt(j - 1)) && match[i][j - 1]);
			}
		}

		return match[s1.length()][s2.length()];
	}
}
