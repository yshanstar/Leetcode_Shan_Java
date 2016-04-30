package solution;

import java.util.ArrayList;
import java.util.List;

/*
 * Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Show Company Tags
Show Tags
Show Similar Problems

 */
public class GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<String>();
		helper(word, res, 0, "", 0);
		return res;
	}

	private void helper(String word, List<String> res, int idx, String tmp, int count) {
		if (idx == word.length()) {
			if (count > 0) {
				tmp += count;
			}
			res.add(tmp);
		} else {
			helper(word, res, idx + 1, tmp, count + 1);
			helper(word, res, idx + 1, tmp + ((count > 0) ? count : "") + word.charAt(idx), 0);
		}
	}
}
