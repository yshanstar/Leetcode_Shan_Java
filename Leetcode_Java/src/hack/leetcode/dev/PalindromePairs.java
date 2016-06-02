package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]
Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 */
public class PalindromePairs {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (words == null || words.length == 0) {
			return res;
		}

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}

		// If dic has empty string
		if (map.containsKey("")) {
			int idx = map.get("");
			for (String w : words) {
				if (!w.equals("") && isPal(w)) {
					res.add(Arrays.asList(idx, map.get(w)));
					res.add(Arrays.asList(map.get(w), idx));
				}
			}
		}

		// find all string and reverse string
		for (int i = 0; i < words.length; i++) {
			String reverseStr = reverse(words[i]);
			if (map.containsKey(reverseStr)) {
				int idx = map.get(reverseStr);
				if (idx != i) {
					res.add(Arrays.asList(i, idx));
				}
			}
		}

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			for (int cut = 1; cut < word.length(); cut++) {
				if (isPal(word.substring(0, cut))) {
					String word_r = reverse(word.substring(cut));
					if (map.containsKey(word_r)) {
						int idx = map.get(word_r);
						if (idx != i) {
							res.add(Arrays.asList(idx, i));
						}
					}
				}

				if (isPal(word.substring(cut))) {
					String word_r = reverse(word.substring(0, cut));
					if (map.containsKey(word_r)) {
						int idx = map.get(word_r);
						if (idx != i) {
							res.add(Arrays.asList(i, idx));
						}
					}
				}
			}
		}

		return res;
	}

	private String reverse(String word) {
		StringBuilder sb = new StringBuilder(word);
		return sb.reverse().toString();
	}

	private boolean isPal(String word) {
		if (word == null) {
			return false;
		}

		if (word.isEmpty()) {
			return true;
		}

		int i = 0;
		int j = word.length() - 1;
		while (i < j) {
			if (word.charAt(i++) != word.charAt(j--)) {
				return false;
			}
		}

		return true;
	}
}
