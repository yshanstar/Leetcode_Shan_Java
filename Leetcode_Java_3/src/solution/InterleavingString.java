package solution;

/*
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != (s1.length() + s2.length())) {
			return false;
		}

		boolean[][] isMatch = new boolean[s1.length() + 1][s2.length() + 1];
		isMatch[0][0] = true;

		for (int i = 1; i <= s1.length(); i++) {
			if (s3.charAt(i - 1) == s1.charAt(i - 1)) {
				isMatch[i][0] = isMatch[i - 1][0];
			}
		}

		for (int i = 1; i <= s2.length(); i++) {
			if (s3.charAt(i - 1) == s2.charAt(i - 1)) {
				isMatch[0][i] = isMatch[0][i - 1];
			}
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				isMatch[i][j] = (s3.charAt(i + j - 1) == s1.charAt(i - 1) && isMatch[i - 1][j])
						|| (s3.charAt(i + j - 1) == s2.charAt(j - 1) && isMatch[i][j - 1]);
			}
		}

		return isMatch[s1.length()][s2.length()];
	}
}
