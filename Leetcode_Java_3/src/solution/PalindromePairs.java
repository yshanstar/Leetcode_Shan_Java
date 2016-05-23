package solution;

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

		// special cases: "" can be combine with any palindrome string
		if (map.containsKey("")) {
			int index = map.get("");
			for (int i = 0; i < words.length; i++) {
				if (i != index && isPalindrom(words[i])) {
					res.add(Arrays.asList(index, i));
					res.add(Arrays.asList(i, index));
				}
			}
		}

		// find all string and reverse string pairs
		for (int i = 0; i < words.length; i++) {
			String reverse = reverseString(words[i]);
			if (map.containsKey(reverse)) {
				int idx = map.get(reverse);
				if (idx != i) {
					res.add(Arrays.asList(i, idx));
				}
			}
		}

		// find the pair s1, s2 that
		// case1 : s1[0:cut] is palindrome and s1[cut+1:] = reverse(s2) =>
		// (s2,s1)
		// case2 : s1[cut+1:] is palindrome and s1[0:cut] = reverse(s2) =>
		// (s1,s2)

		for (int i = 0; i < words.length; i++) {
			String cur = words[i];
			for (int cut = 1; cut < cur.length(); cut++) {
				if (isPalindrom(cur.substring(0, cut))) {
					String cut_r = reverseString(cur.substring(cut));
					if (map.containsKey(cut_r)) {
						int found = map.get(cut_r);
						if (found == i)
							continue;
						res.add(Arrays.asList(found, i));
					}
				}
				if (isPalindrom(cur.substring(cut))) {
					String cut_r = reverseString(cur.substring(0, cut));
					if (map.containsKey(cut_r)) {
						int found = map.get(cut_r);
						if (found == i)
							continue;
						res.add(Arrays.asList(i, found));
					}
				}
			}
		}

		return res;
	}

	private String reverseString(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	}

	private boolean isPalindrom(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
