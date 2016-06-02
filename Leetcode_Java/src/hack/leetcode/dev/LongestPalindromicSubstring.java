package hack.leetcode.dev;

/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}

		String longest = s.substring(0, 1);

		for (int i = 0; i < s.length(); i++) {
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}

			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}

		return longest;
	}

	private String helper(String str, int start, int end) {
		while (start >= 0 && end <= str.length() - 1 && str.charAt(start) == str.charAt(end)) {
			start--;
			end++;
		}

		return str.substring(start + 1, end);
	}
}
