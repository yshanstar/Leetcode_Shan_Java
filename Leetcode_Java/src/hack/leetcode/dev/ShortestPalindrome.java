package hack.leetcode.dev;

/*
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s).reverse();
		for (int i = 0; i < s.length(); i++) {
			if (s.startsWith(sb.substring(i))) {
				return sb.substring(0, i) + s;
			}
		}
		return s;
	}
}
