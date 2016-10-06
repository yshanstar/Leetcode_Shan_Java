package hack.leetcode.dev;

/*
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
	public int longestSubstring(String s, int k) {
		char[] sChars = s.toCharArray();
		return helper(sChars, 0, s.length(), k);
	}

	private int helper(char[] sChars, int start, int end, int k) {
		if (start > end) {
			return 0;
		}

		if (end - start < k) {
			return 0;
		}

		int[] count = new int[26];

		for (int i = start; i < end; i++) {
			int idx = sChars[i] - 'a';
			count[idx]++;
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] == 0) {
				continue;
			}

			if (count[i] < k) {
				for (int j = start; j < end; j++) {
					if (sChars[j] == i + 'a') {
						int left = helper(sChars, start, j, k);
						int right = helper(sChars, j + 1, end, k);

						return Math.max(left, right);
					}
				}
			}
		}

		return end - start;
	}
}
