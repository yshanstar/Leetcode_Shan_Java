package hack.leetcode.dev;

/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowsSubstring {
	public static String minWindow(String s, String t) {
		if (t == null || t.length() == 0) {
			return "";
		}

		char[] chars = new char[256];
		char[] hasFound = new char[256];

		for (char c : t.toCharArray()) {
			chars[c]++;
		}

		String res = null;
		int found = 0;
		for (int start = 0, end = 0; end < s.length(); end++) {
			char c = s.charAt(end);
			if (chars[c] == 0) {
				continue;
			}

			hasFound[c]++;

			if (hasFound[c] <= chars[c]) {
				found++;
			}

			if (found == t.length()) {
				char startC = s.charAt(start);
				while (chars[startC] == 0 || hasFound[startC] > chars[startC]) {
					if (hasFound[startC] > chars[startC]) {
						hasFound[startC]--;
					}
					start++;
					startC = s.charAt(start);
				}
				int length = end - start + 1;
				if (res == null || res.length() > (length)) {
					res = s.substring(start, end + 1);
				}
			}
		}

		if (found == t.length()) {
			return res;
		}

		return "";
	}

	public static void main(String[] args) {
		minWindow("aa", "aa");
	}
}
