package hack.leetcode.dev;

import java.util.HashMap;

/*
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

 For example, Given s = “eceba”,

 T is "ece" which its length is 3.
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s.length() <= 2) {
			return s.length();
		}

		HashMap<Character, Integer> indexMap = new HashMap<Character, Integer>();

		int low = 0;
		int high = 0;
		int maxLength = 0;

		while (high < s.length()) {
			if (indexMap.size() <= 2) {
				char c = s.charAt(high);
				indexMap.put(c, high);
				high++;
			}
			if (indexMap.size() > 2) {
				int leftMost = s.length();
				for (int i : indexMap.values()) {
					leftMost = Math.min(leftMost, i);
				}
				char c = s.charAt(leftMost);
				indexMap.remove(c);
				low = leftMost + 1;
			}
			maxLength = Math.max(maxLength, high - low);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		LongestSubstringwithAtMostTwoDistinctCharacters test = new LongestSubstringwithAtMostTwoDistinctCharacters();
		test.lengthOfLongestSubstringTwoDistinct("abaccc");
	}
}
