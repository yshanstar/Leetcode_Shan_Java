package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePartitioning {
	HashMap<String, Boolean> subStringPalindrom = new HashMap<String, Boolean>();

	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();

		partitionHelper(res, s, new ArrayList<String>());

		return res;

	}

	private void partitionHelper(List<List<String>> res, String s, List<String> tmp) {
		if (s.length() == 0) {
			res.add(tmp);
			return;
		}

		for (int i = 1; i <= s.length(); i++) {
			String sub = s.substring(0, i);
			if (isPalindrom(sub)) {
				List<String> buffer = new ArrayList<String>(tmp);
				buffer.add(sub);
				partitionHelper(res, s.substring(i), buffer);
			}
		}
	}

	private boolean isPalindrom(String s) {
		if (s == null || s.trim().length() <= 1) {
			return true;
		}

		if (subStringPalindrom.containsKey(s))
			return subStringPalindrom.get(s);

		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				subStringPalindrom.put(s, false);
				return false;
			}
			start++;
			end--;
		}

		subStringPalindrom.put(s, true);
		return true;
	}
}
