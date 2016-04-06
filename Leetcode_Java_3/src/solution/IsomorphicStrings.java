package solution;

/*
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true
 */
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if (s == null && t == null) {
			return true;
		}

		if ((s == null || t == null) || (s.length() != t.length())) {
			return false;
		}

		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();

		char[] sm = new char[256];
		char[] tm = new char[256];

		for (int i = 0; i < s.length(); i++) {
			char sc = sChar[i];
			char tc = tChar[i];

			if (sm[sc] == 0 && tm[tc] == 0) {
				sm[sc] = tc;
				tm[tc] = sc;
			} else {
				if (sm[sc] != tc || tm[tc] != sc) {
					return false;
				}
			}
		}

		return true;
	}
}
