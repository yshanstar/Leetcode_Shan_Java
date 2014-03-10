package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.HashMap;

/*
 *  Given a string s, partition s such that every substring of the partition is a palindrome.
 *	Return all possible palindrome partitioning of s.
 *	For example, given s = "aab",
 *	Return
 *	[
 *		["aa","b"],
 *		["a","a","b"]
 *	]
 */
public class PalindromePartitioning {
	HashMap<String, Boolean> subStringPalindrome = new HashMap<String, Boolean>();

	public ArrayList<ArrayList<String>> partition(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		partitionHelper(res, s, new ArrayList<String>());
		return res;
	}

	private void partitionHelper(ArrayList<ArrayList<String>> res, String s, ArrayList<String> buffer) {
		if (s.length() == 0) {
			res.add(buffer);
			return;
		}
		for (int i = 1; i <= s.length(); i++) {
			String tmp = s.substring(0, i);
			if (isPalindrome(tmp)) {
				ArrayList<String> nBuffer = new ArrayList<String>(buffer);
				nBuffer.add(tmp);
				partitionHelper(res, s.substring(i), nBuffer);
			}
		}
	}

	private boolean isPalindrome(String s) {
		if (s == null)
			return true;
		if (subStringPalindrome.containsKey(s))
			return subStringPalindrome.get(s);
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--)) {
				subStringPalindrome.put(s, false);
				return false;
			}
		}
		subStringPalindrome.put(s, true);
		return true;
	}

	public static void main(String[] args) {
		PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
		palindromePartitioning.partition("a");

	}
}
