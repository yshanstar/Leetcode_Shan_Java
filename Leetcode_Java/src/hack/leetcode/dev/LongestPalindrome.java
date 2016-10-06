package hack.leetcode.dev;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {
	public int longestPalindrome(String s) {
		int res = 0;
		Set<Character> set = new HashSet<>();

		for (char c : s.toCharArray()) {
			if (set.contains(c)) {
				set.remove(c);
				res += 2;
			} else {
				set.add(c);
			}
		}

		return res + (set.isEmpty() ? 0 : 1);
	}
}
