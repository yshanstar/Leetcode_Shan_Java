package solution;

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
public class MaximumProductWordLengths {
	public int maxProduct(String[] words) {
		if (words == null || words.length < 2) {
			return 0;
		}

		int maxProduct = 0;
		int length = words.length;
		int[] wordBits = new int[length];

		for (int i = 0; i < words.length; i++) {
			for (char c : words[i].toCharArray()) {
				wordBits[i] |= (1 << (c - 'a'));
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if ((wordBits[i] & wordBits[j]) == 0) {
					maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
				}
			}
		}

		return maxProduct;
	}
}
