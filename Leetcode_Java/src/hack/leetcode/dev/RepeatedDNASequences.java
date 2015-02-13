package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 For example,
 Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

 Return:
 ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Character, Integer> mole = new HashMap<Character, Integer>();

		mole.put('A', 0);
		mole.put('C', 1);
		mole.put('G', 2);
		mole.put('T', 3);

		List<String> res = new ArrayList<String>();

		if (s == null || s.length() < 10) {
			return res;
		}

		int mask = (1 << 20) - 1;
		int x = 0;
		for (int i = 0; i < 10; i++) {
			x = (x << 2) | mole.get(s.charAt(i));
		}

		map.put(x, 1);

		for (int i = 10; i < s.length(); i++) {
			x = (x << 2) | mole.get(s.charAt(i));
			x = x & mask;

			if (map.containsKey(x)) {
				if (map.get(x) == 1) {
					res.add(convert2Str(x));
					map.put(x, -1);
				}
			} else {
				map.put(x, 1);
			}
		}

		return res;
	}

	private String convert2Str(int x) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			int k = x & 3;
			if (k == 0) {
				sb.insert(0, 'A');
			}
			if (k == 1) {
				sb.insert(0, 'C');
			}
			if (k == 2) {
				sb.insert(0, 'G');
			}
			if (k == 3) {
				sb.insert(0, 'T');
			}
			x = x >> 2;
		}
		return sb.toString();
	}
}
