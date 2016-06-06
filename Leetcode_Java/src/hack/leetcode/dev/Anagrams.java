package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 */
public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> res = new ArrayList<String>();
		Map<String, ArrayList<String>> wordMap = new HashMap<String, ArrayList<String>>();

		for (String s : strs) {
			String sSorted = sortStr(s);
			if (!wordMap.containsKey(sSorted)) {
				ArrayList<String> tmpRes = new ArrayList<String>();
				tmpRes.add(s);
				wordMap.put(sSorted, tmpRes);
			} else {
				wordMap.get(sSorted).add(s);
			}
		}

		for (String s : wordMap.keySet()) {
			if (wordMap.get(s).size() > 1) {
				res.addAll(wordMap.get(s));
			}
		}
		return res;
	}

	private String sortStr(String s) {
		char[] sChars = s.toCharArray();
		Arrays.sort(sChars);
		return new String(sChars);
	}

	public static void main(String[] args) {
		Anagrams test = new Anagrams();
		String[] strs = { "''''", "''''" };
		System.out.println(test.anagrams(strs));
	}
}
