package hack.leetcode.dev;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
 */
public class MaximumProductofWordLengths {
	public int maxProduct(String[] words) {
		int max = 0;

		Arrays.sort(words, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.length() - o1.length();
			}
		});

		int[] masks = new int[words.length];

		for (int i = 0; i < words.length; i++) {
			for (char c : words[i].toCharArray()) {
				masks[i] |= 1 << (c - 'a');
			}
		}

		for (int i = 0; i < masks.length; i++) {
			if (words[i].length() * words[i].length() <= max) {
				break;
			}

			for (int j = i + 1; j < words.length; j++) {
				if ((masks[i] & masks[j]) == 0) {
					max = Math.max(max, words[i].length() * words[j].length());
					break;
				}
			}
		}

		return max;
	}
}
