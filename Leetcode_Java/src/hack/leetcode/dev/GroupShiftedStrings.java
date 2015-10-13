package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
 * Return:

 [
 ["abc","bcd","xyz"],
 ["az","ba"],
 ["acef"],
 ["a","z"]
 ]
 */
public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
		if (strings == null) {
			throw new IllegalArgumentException("strings is null");
		}

		List<List<String>> res = new ArrayList<List<String>>();

		if (strings.length == 0) {
			return res;
		}

		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		for (String str : strings) {
			String shifted_str = shiftStr(str);
			if (map.containsKey(shifted_str)) {
				map.get(shifted_str).add(str);
			} else {
				List<String> item = new ArrayList<String>();
				item.add(str);
				map.put(shifted_str, item);
				res.add(item);
			}
		}

		for (List<String> list : res) {
			Collections.sort(list);
		}

		return res;
	}

	private String shiftStr(String str) {
		StringBuffer buffer = new StringBuffer();
		char[] char_array = str.toCharArray();
		int dist = str.charAt(0) - 'a';
		for (char c : char_array) {
			buffer.append((c - 'a' - dist + 26) % 26 + 'a');
		}

		return buffer.toString();
	}

	public static void main(String[] args) {
		GroupShiftedStrings test = new GroupShiftedStrings();
		test.groupStrings(new String[] { "ab", "bd" });
	}
}
