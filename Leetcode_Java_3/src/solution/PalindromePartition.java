package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 */
public class PalindromePartition {
	Map<String, Boolean> stringPalindrom = new HashMap<String, Boolean>();

	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (s == null || s.length() == 0) {
			return res;
		}

		helper(s, new ArrayList<String>(), res);

		return res;
	}

	private void helper(String str, ArrayList<String> tmpList, List<List<String>> res) {
		if (str.length() == 0) {
			res.add(new ArrayList<String>(tmpList));
			return;
		}

		for (int i = 1; i <= str.length(); i++) {
			String subString = str.substring(0, i);
			if (isPalindrome(subString)) {
				tmpList.add(subString);
				helper(str.substring(i), tmpList, res);
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}

		if (stringPalindrom.containsKey(str)) {
			return stringPalindrom.get(str);
		}

		int i = 0;
		int j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i++) != str.charAt(j--)) {
				stringPalindrom.put(str, false);
				return false;
			}
		}

		stringPalindrom.put(str, true);
		return true;
	}

	public static void main(String[] args) {
		PalindromePartition test = new PalindromePartition();
		test.partition("bb");
	}
}
