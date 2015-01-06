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

/*
 * Solution1: 二维dp�? f(i, j) == f(i, j-1) && s2[j-1] == s3[i+j-1)  OR f(i-1, j) && s1[i-1] == s3[i+j-1],
 *            i, j 代表 s1, s2 的长度，f(i, j) 表示 s1[0, i), s2[0, j) 是否可以interleaving 形成 s3[0, i+j)
 * 
 */
public class InterleavingString {
	public static boolean isInterleave(String s1, String s2, String s3) {
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

	public static void main(String[] args) {
		boolean a = isInterleave("ab", "ac", "acab");
		System.out.println(a);
	}
}
