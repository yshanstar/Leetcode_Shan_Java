package hack.leetcode.dev;

import java.util.HashMap;

/*
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

 a) it                      --> it    (no abbreviation)

 1
 b) d|o|g                   --> d1g

 1    1  1
 1---5----0----5--8
 c) i|nternationalizatio|n  --> i18n

 1
 1---5----0
 d) l|ocalizatio|n          --> l10n
 Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

 Example: 
 Given dictionary = [ "deer", "door", "cake", "card" ]

 isUnique("dear") -> false
 isUnique("cart") -> true
 isUnique("cane") -> false
 isUnique("make") -> true
 */
public class ValidWordAbbr {
	HashMap<String, String> dic;

	public ValidWordAbbr(String[] dictionary) {
		dic = new HashMap<String, String>();

		for (String str : dictionary) {
			String key = abbr(str);
			if (dic.containsKey(key)) {
				dic.put(key, "");
			} else {
				dic.put(key, str);
			}
		}
	}

	public boolean isUnique(String word) {
		String key = abbr(word);
		return !dic.containsKey(key) || dic.get(key).equals(word);
	}

	private String abbr(String str) {
		if (str == null || str.length() <= 2) {
			return str;
		}

		String key = str.charAt(0) + Integer.toString(str.length() - 2)
				+ str.charAt(str.length() - 1);

		return key;
	}
}
