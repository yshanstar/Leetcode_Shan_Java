package hack.leetcode.dev;

import hack.leetcode.ulti.Ultitool;

/*
 * Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".

Note:
Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Example 1:
Given s = "internationalization", abbr = "i12iz4n":

Return true.
Example 2:
Given s = "apple", abbr = "a2e":

Return false.
 */
public class ValidWordAbbreviation {
	public static boolean validWordAbbreviation(String word, String abbr) {
		if (word == null && abbr == null) {
			return true;
		}

		if (word == null || abbr == null) {
			return false;
		}

		int idx = 0;
		int skip = 0;
		for (char c : abbr.toCharArray()) {
			if (Character.isDigit(c)) {
				skip = skip * 10 + (c - '0');
				if (skip == 0) {
					return false;
				}
			} else {
				idx += skip;
				skip = 0;
				if (idx >= word.length() || word.charAt(idx) != c) {
					return false;
				}
				idx++;
			}
		}
		return skip == (word.length() - idx);
	}

	public static void main(String[] args) {
		Ultitool.print(validWordAbbreviation("abbreviation", "a10n"));
	}
}
