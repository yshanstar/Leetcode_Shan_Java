package solution;

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
		List<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return res;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}

		char oddChar = 0;
		int count = 0;

		for (char c : map.keySet()) {
			if (map.get(c) % 2 != 0) {
				count++;
				oddChar = c;
			}
		}

		if (count > 1) {
			return res;
		}

		if (count == 0) {
			helper(map, "", res, s.length());
		} else {
			helper(map, oddChar + "", res, s.length());
		}

		return res;
	}

	private void helper(Map<Character, Integer> map, String tmpStr,
			List<String> res, int targetLen) {
		if (tmpStr.length() == targetLen) {
			res.add(tmpStr);
			return;
		}

		for (char c : map.keySet()) {
			if (map.get(c) >= 2) {
				String tmp = tmpStr;
				tmp = c + tmp + c;
				map.put(c, map.get(c) - 2);
				helper(map, tmp, res, targetLen);
				map.put(c, map.get(c) + 2);
			}
		}
	}
}
