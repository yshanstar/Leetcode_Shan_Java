package hack.leetcode.dev;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two strings s and t, determine if they are isomorphic.
 Two strings are isomorphic if the characters in s can be replaced to get t.
 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.
 Given "foo", "bar", return false.
 Given "paper", "title", return true.
 */

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if (s == null && t == null) {
			return true;
		}

		if (s == null || t == null) {
			return false;
		}

		if (s.length() != t.length()) {
			return false;
		}

		Map<Character, Character> keyMap = new HashMap<Character, Character>();
		Map<Character, Character> resKeyMap = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			char sChar = s.charAt(i);
			char tChar = t.charAt(i);

			if (keyMap.containsKey(sChar)) {
				char target = keyMap.get(sChar);
				if (tChar != target) {
					return false;
				}
			} else {
				if(resKeyMap.containsKey(tChar)){
					char target = resKeyMap.get(tChar);
					if (sChar != target) {
						return false;
					}
				}
				keyMap.put(sChar, tChar);
				resKeyMap.put(tChar, sChar);
			}
		}

		return true;
	}
}
