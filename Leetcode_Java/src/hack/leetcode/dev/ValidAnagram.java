package hack.leetcode.dev;

/*
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.
 */

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if ((s == null && t == null) || (s.length() == 0 && t.length() == 0)) {
			return true;
		}

		if (s == null || t == null) {
			return false;
		}

		if (s.length() != t.length()) {
			return false;
		}

		int[] res = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int shift = s.charAt(i) - 'a';
			res[shift]++;
			shift = t.charAt(i) - 'a';
			res[shift]--;
		}

		for (int i = 0; i < res.length; i++) {
			if (res[i] != 0) {
				return false;
			}
		}

		return true;
	}
}
