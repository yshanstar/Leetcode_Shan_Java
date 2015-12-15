package hack.leetcode.dev;

/*
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"
 */
public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}

		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}

		boolean[] inResult = new boolean[26];
		int end = -1;
		char[] res = new char[s.length()];

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int idx = c - 'a';
			if (inResult[idx]) {
				count[idx]--;
				continue;
			}

			while (end >= 0) {
				char sc = res[end];

				if (sc >= c && count[sc - 'a'] > 0) {
					end--;
					inResult[sc - 'a'] = false;
				} else {
					break;
				}
			}

			res[++end] = c;
			count[idx]--;
			inResult[idx] = true;
		}

		return String.valueOf(res).substring(0, end + 1);
	}
}
