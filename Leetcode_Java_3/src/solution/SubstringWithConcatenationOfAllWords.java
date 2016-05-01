package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 */
public class SubstringWithConcatenationOfAllWords {
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		if (words == null || words.length == 0 || s == null || s.isEmpty()) {
			return res;
		}

		Map<String, Integer> needToFound = new HashMap<String, Integer>();
		int wordLen = 0;
		int size = words.length;
		for (String word : words) {
			wordLen = word.length();
			if (needToFound.containsKey(word)) {
				needToFound.put(word, needToFound.get(word) + 1);
			} else {
				needToFound.put(word, 1);
			}
		}

		if (s.length() < words.length * wordLen) {
			return res;
		}

		for (int i = 0; i <= s.length() - wordLen * size; i++) {
			String subString = s.substring(i, i + wordLen * size);
			if (isValid(subString, new HashMap<String, Integer>(needToFound), wordLen)) {
				res.add(i);
			}
		}
		return res;
	}

	private static boolean isValid(String str, Map<String, Integer> needToFound, int wordLength) {
		for (int i = 0; i < str.length(); i += wordLength) {
			String word = str.substring(i, i + wordLength);
			if (!needToFound.containsKey(word)) {
				return false;
			}

			int count = needToFound.get(word);
			count--;
			if (count == 0) {
				needToFound.remove(word);
			} else {
				needToFound.put(word, count);
			}
		}

		if (needToFound.size() == 0) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" });
	}
}
