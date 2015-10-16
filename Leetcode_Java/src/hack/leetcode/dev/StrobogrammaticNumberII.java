package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Find all strobogrammatic numbers that are of length = n.
 * For example,
 * Given n = 2, return ["11","69","88","96"].
 */
public class StrobogrammaticNumberII {
	public List<String> findStrobogrammatic(int n) {
		Map<Character, Character> map = buildMap();

		List<String> res = n % 2 == 0 ? Arrays.asList("") : Arrays.asList("1",
				"8", "0");

		for (int i = n % 2 == 0 ? 1 : 2; i < n; i += 2) {
			List<String> cur = new ArrayList<>();
			for (char c : map.keySet()) {
				for (String s : res) {
					// don't add leading 0s!
					if (i != n - 1 || c != '0')
						cur.add(c + s + map.get(c));
				}
			}
			res = cur;
		}

		return res;
	}

	private Map<Character, Character> buildMap() {
		Map<Character, Character> map = new HashMap<>();
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		map.put('0', '0');
		return map;
	}
}
