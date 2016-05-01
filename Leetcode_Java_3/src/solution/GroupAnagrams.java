package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (strs == null || strs.length == 0) {
			return res;
		}

		Map<String, List<String>> maps = new HashMap<String, List<String>>();

		for (String str : strs) {
			char[] cChars = str.toCharArray();
			Arrays.sort(cChars);

			String key = String.valueOf(cChars);

			if (!maps.containsKey(key)) {
				maps.put(key, new ArrayList<String>());
			}

			maps.get(key).add(str);
		}

		for (Entry<String, List<String>> entry : maps.entrySet()) {
			List<String> values = entry.getValue();
			Collections.sort(values);

			res.add(values);
		}

		return res;
	}
}
