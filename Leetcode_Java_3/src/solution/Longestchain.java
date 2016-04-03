package solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * You are given a library with n words (W[0], W[1], W[2].. W[n-1]), You choose a word from it,
 * and in each step, remove one letter from this word only if doing so yields a another word 
 * in the library. What is the longest possible chain of these removal steps?
 */
public class Longestchain {
	public int longestchain(String[] words) {
		if (words == null || words.length == 0) {
			return 0;
		}

		int res = 0;
		Set<String> wordSet = new HashSet<String>();
		Map<String, Integer> wordMap = new HashMap<String, Integer>();

		Arrays.sort(words, new Comp());

		for (String word : words) {
			if (!wordSet.contains(word)) {
				wordSet.add(word);
			}
		}

		for (int i = words.length - 1; i >= 0; i--) {
			String word = words[i];

			if (word.length() < res) {
				// Since we started with longest word to shortest word.
				// If we already fond the longest chain which is longer
				// than the word. We should break the loop.
				break;
			}

			int length = findLongestChain(word, wordSet, wordMap) + 1;
			wordMap.put(word, length);
			res = Math.max(res, length);
		}

		return res;
	}

	private int findLongestChain(String word, Set<String> wordSet, Map<String, Integer> wordMap) {
		int tmpRest = 0;
		for (int i = 0; i < word.length(); i++) {
			String subString = word.substring(0, i) + word.substring(i + 1);
			if (wordSet.contains(subString)) {
				if (wordMap.containsKey(subString)) {
					tmpRest = Math.max(tmpRest, wordMap.get(subString));
				} else {
					tmpRest = Math.max(tmpRest, findLongestChain(subString, wordSet, wordMap) + 1);
				}
			}
		}
		return tmpRest;
	}

	public static void main(String[] args) {
		Longestchain test = new Longestchain();
		System.out.println(test.longestchain(new String[] { "a", "abcd", "bcd", "abd", "cd", "c" }));

	}

	class Comp implements Comparator<String> {
		public int compare(String o1, String o2) {
			return Integer.compare(o1.length(), o2.length());
		}
	}
}
