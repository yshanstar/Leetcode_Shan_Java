package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreakII {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<ArrayList<Integer>> pos = new ArrayList<ArrayList<Integer>>();
		ArrayList<String> res = new ArrayList<String>();
		findPos(s, 0, new ArrayList<Integer>(), pos, dict, res, "");
		return res;
	}

	private void findPos(String s, int idx, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> pos, Set<String> dict, ArrayList<String> res,
			String strRes) {
		if (idx == s.length()) {
			pos.add(tmp);
			res.add(strRes);
			return;
		}
		for (int i = 0; idx + i < s.length(); i++) {
			ArrayList<Integer> tmpPos = new ArrayList<Integer>(tmp);
			String str = s.substring(idx, idx + i + 1);
			if (dict.contains(str)) {
				tmpPos.add(idx + i);
				findPos(s, idx + i + 1, tmpPos, pos, dict, res, (((idx + i + 1) == s.length()) ? (strRes + str) : (strRes + str + " ")));
			}
		}
	}

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		WordBreakII test = new WordBreakII();
		System.out.println(test.wordBreak("catsanddog", dict));
	}
}
