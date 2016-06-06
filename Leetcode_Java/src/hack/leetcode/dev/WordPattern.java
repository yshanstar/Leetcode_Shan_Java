package hack.leetcode.dev;

import java.util.HashMap;

/*
 * Given a pattern and a string str, find if str follows the same pattern.
 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 Both pattern and str contains only lowercase alphabetical letters.
 Both pattern and str do not have leading or trailing spaces.
 Each word in str is separated by a single space.
 Each letter in pattern must map to a word with length that is at least 1.
 */
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		if ((pattern == null || pattern.length() == 0)
				&& (str == null || str.length() == 0)) {
			return true;
		}

		if ((pattern == null || pattern.length() == 0)
				|| (str == null || str.length() == 0)) {
			return false;
		}

		HashMap<String, String> patternMap = new HashMap<String, String>();
		String[] words = str.split(" ");

		if (pattern.length() != words.length) {
			return false;
		}

		for (int i = 0; i < pattern.length(); i++) {
			String c = String.valueOf(pattern.charAt(i));

			if (!patternMap.containsKey(c)) {
				patternMap.put(c, words[i]);
			} else {
				String tmp = patternMap.get(c);
				if (!tmp.equals(words[i])) {
					return false;
				}
			}
		}

		patternMap = new HashMap<String, String>();

		for (int i = 0; i < pattern.length(); i++) {
			String c = String.valueOf(pattern.charAt(i));

			if (!patternMap.containsKey(words[i])) {
				patternMap.put(words[i], c);
			} else {
				String patternS = patternMap.get(words[i]);
				if (!patternS.equals(c)) {
					return false;
				}
			}
		}

		return true;
	}
}
