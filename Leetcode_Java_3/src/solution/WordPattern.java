package solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern {
	public static boolean wordPattern(String pattern, String str) {
		if ((pattern == null || pattern.length() == 0) && (str == null || str.length() == 0)) {
			return true;
		}

		if ((pattern == null || pattern.length() == 0) || (str == null || str.length() == 0)) {
			return false;
		}

		String[] strs = str.split(" ");
		if (pattern.length() != strs.length) {
			return false;
		}

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (Integer i = 0; i < strs.length; i++) {
			char c = pattern.charAt(i);
			if (map.put(c + "*", i) != map.put(strs[i], i)) {
				return false;
			}
		}

		return true;
	}

	public static boolean wordPattern2(String pattern, String str) {
		if ((pattern == null || pattern.length() == 0) && (str == null || str.length() == 0)) {
			return true;
		}

		if ((pattern == null || pattern.length() == 0) || (str == null || str.length() == 0)) {
			return false;
		}

		String[] strs = str.split(" ");
		if (pattern.length() != strs.length) {
			return false;
		}

		Map<Character, String> map = new HashMap<Character, String>();
		Set<String> wordSet = new HashSet<String>();

		for (int i = 0; i < strs.length; i++) {
			char c = pattern.charAt(i);
			if (!map.containsKey(c)) {
				if (!wordSet.add(strs[i])) {
					return false;
				}
				map.put(c, strs[i]);
			} else if (!map.get(c).equals(strs[i])) {
				return false;
			}
		}

		return true;
	}
}
