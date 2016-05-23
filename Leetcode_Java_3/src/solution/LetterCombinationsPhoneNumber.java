package solution;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsPhoneNumber {
	String[] dic = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return res;
		}

		helper(digits, 0, res, "");

		return res;
	}

	private void helper(String digits, int idx, List<String> res, String tmp) {
		if (idx == digits.length()) {
			res.add(tmp);
			return;
		}

		int dicIdx = digits.charAt(idx) - '0';
		for (char c : dic[dicIdx].toCharArray()) {
			StringBuilder sb = new StringBuilder(tmp);
			sb.append(c);
			helper(digits, idx + 1, res, sb.toString());
		}
	}
}
