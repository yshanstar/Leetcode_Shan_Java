package hack.leetcode.dev;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
	public static boolean wordBreak(String s, Set<String> dict) {
		boolean[] wordCanBreak = new boolean[s.length() + 1];
		wordCanBreak[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (wordCanBreak[j] && dict.contains(s.substring(j, i))) {
					wordCanBreak[i] = true;
					break;
				}
			}
		}

		return wordCanBreak[s.length()];
	}

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");

		System.out.println(wordBreak("leetcode", dict));
	}
}
