package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/*
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		return dfs(s, wordDict, new HashMap<String, List<String>>());
	}

	private List<String> dfs(String s, Set<String> dict,
			HashMap<String, List<String>> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}

		int length = s.length();
		List<String> res = new ArrayList<String>();
		for (String str : dict) {
			if (!s.startsWith(str)) {
				continue;
			}

			int end = str.length();

			if (end == length) {
				res.add(str);
			} else {
				List<String> tmp = dfs(s.substring(end), dict, map);
				for (String tmpStr : tmp) {
					tmpStr = str + " " + tmpStr;
					res.add(tmpStr);
				}
			}
		}

		map.put(s, res);
		return res;
	}
}
