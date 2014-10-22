package solution;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return null;
		}
		if (s.length() == 1) {
			return s;
		}

		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			// find the longest palindrome string with center of i
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}

			// find the longest palindrome string with center of i, i+1
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest;
	}

	private String helper(String s, int start, int end) {
		while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}

		return s.substring(start + 1, end);
	}
}
