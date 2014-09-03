package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
		List<String> res = new ArrayList<String>();
		if (strs == null || strs.length == 0) {
			return res;
		}
		HashMap<String, ArrayList<String>> wordMap = new HashMap<String, ArrayList<String>>();
		for (String str : strs) {
			char[] strChars = str.toCharArray();
			Arrays.sort(strChars);
			String sortedStr = new String(strChars);

			if (wordMap.containsKey(sortedStr)) {
				wordMap.get(sortedStr).add(str);
			} else {
				ArrayList<String> tmp = new ArrayList<String>();
				tmp.add(str);
				wordMap.put(sortedStr, tmp);
			}
		}

		for (ArrayList<String> tmpRes : wordMap.values()) {
			if (tmpRes.size() > 1) {
				res.addAll(tmpRes);
			}
		}
		return res;
	}
}
