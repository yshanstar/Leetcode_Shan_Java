package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 */
public class SubstringwithConcatenationofAllWords {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (L == null || L.length == 0 || S == null || S.length() == 0) {
			return res;
		}

		int n = L[0].length();
		Map<String, Integer> covered = new HashMap<String, Integer>();
		for (int j = 0; j < L.length; j++) {
			if (covered.containsKey(L[j])) {
				covered.put(L[j], covered.get(L[j]) + 1);
			} else {
				covered.put(L[j], 1);
			}
		}

		int i = 0;
		while (S.length() - i >= L.length * n) {
			Map<String, Integer> tmp = new HashMap<String, Integer>(covered);
			for (int j = 0; j < L.length; j++) {
				String subStr = S.substring(i + j * n, i + (j + 1) * n);
				if (tmp.containsKey(subStr)) {
					if (tmp.get(subStr) - 1 == 0) {
						tmp.remove(subStr);
					} else {
						tmp.put(subStr, tmp.get(subStr) - 1);
					}
				} else {
					break;
				}
			}
			if (tmp.size() == 0) {
				res.add(i);
			}
			i++;
		}

		return res;
	}
}
