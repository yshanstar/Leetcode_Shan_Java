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
public class PalindromePartitioning2 {
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		HashMap<String, Boolean> palindromeMap = new HashMap<String, Boolean>();
		partitionHelper(s, res, new ArrayList<String>(), palindromeMap);
		return res;
	}

	private void partitionHelper(String s, ArrayList<ArrayList<String>> res, ArrayList<String> tmpRes, HashMap<String, Boolean> palindromeMap) {
		if (s.length() == 0) {
			res.add(tmpRes);
			return;
		}
		for (int i = 1; i <= s.length(); i++) {
			String tmpStr = s.substring(0, i);
			if (isPalindrome(tmpStr, palindromeMap)) {
				ArrayList<String> newTmp = new ArrayList<String>(tmpRes);
				newTmp.add(tmpStr);
				partitionHelper(s.substring(i), res, newTmp, palindromeMap);
			}
		}
	}

	private boolean isPalindrome(String s, HashMap<String, Boolean> palindromeMap) {
		if (s == null) {
			return true;
		}
		if (palindromeMap.containsKey(s)) {
			return palindromeMap.get(s);
		} else {
			int i = 0;
			int j = s.length() - 1;
			while (i < j) {
				if (s.charAt(i++) != s.charAt(j--)) {
					palindromeMap.put(s, false);
					return false;
				}
			}
			palindromeMap.put(s, true);
			return true;
		}
	}
}
