package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

 For example:

 Given s = "aabb", return ["abba", "baab"].

 Given s = "abc", return [].
 */
public class PalindromePermutationII {
	public List<String> generatePalindromes(String s) {
		if (s == null) {
			throw new IllegalArgumentException("String is empty");
		}

		List<String> res = new ArrayList<String>();
		if (s.isEmpty()) {
			return res;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		int oddCount = 0;
		char oddChar = 'a';

		for (char c : map.keySet()) {
			if (map.get(c) % 2 == 1) {
				oddCount++;
				oddChar = c;
			}
		}

		if (oddCount > 1) {
			return res;
		}

		if (oddCount == 1) {
			helper(map, oddChar + "", s.length(), res);
		} else {
			helper(map, "", s.length(), res);
		}

		return res;
	}

	private void helper(Map<Character, Integer> map, String tmp, int length, List<String> res) {
		if (tmp.length() == length) {
			res.add(tmp);
			return;
		}

		for (char c : map.keySet()) {
			if (map.get(c) >= 2) {
				String cur = c + tmp + c;
				map.put(c, map.get(c) - 2);
				helper(map, cur, length, res);
				map.put(c, map.get(c) + 2);
			}
		}
	}

	public List<String> generatePalindromes2(String s) {
		if (s == null) {
			throw new IllegalArgumentException("s is null");
		}

		List<String> res = new ArrayList<String>();
		int len = s.length();
		if (len == 0) {
			return res;
		}

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		int oddCount = 0;
		char oddChar = 'a';

		for (char c : map.keySet()) {
			if (map.get(c) % 2 == 1) {
				oddCount++;
				oddChar = c;
			}
		}

		if (oddCount >= 2) {
			return res;
		}

		if (oddCount == 1) {
			helper(map, oddChar + "", len, res);
		} else {
			helper(map, "", len, res);
		}

		return res;
	}

	private void helper(HashMap<Character, Integer> map, String cur, int target, List<String> res) {
		String newCur = cur;
		int len = newCur.length();

		if (len == target) {
			res.add(newCur);
			return;
		}

		for (char c : map.keySet()) {
			if (map.get(c) >= 2) {
				newCur = c + cur + c;
				map.put(c, map.get(c) - 2);
				helper(map, newCur, target, res);
				map.put(c, map.get(c) + 2);
			}
		}
	}

	public static void main(String[] args) {
		PalindromePermutationII test = new PalindromePermutationII();
		test.generatePalindromes("a");
	}
}
