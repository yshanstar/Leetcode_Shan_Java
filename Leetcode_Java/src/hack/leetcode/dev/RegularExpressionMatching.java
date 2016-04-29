package hack.leetcode.dev;

/*
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") -> false
 isMatch("aa","aa") -> true
 isMatch("aaa","aa") -> false
 isMatch("aa", "a*") -> true
 isMatch("aa", ".*") -> true
 isMatch("ab", ".*") -> true
 isMatch("aab", "c*a*b") -> true
 */
public class RegularExpressionMatching {
	public static boolean isMatch(String s, String p) {
		assert (p != null && (p.length() == 0 || p.charAt(0) != '*'));

		if (p.length() == 0) {
			return s.length() == 0;
		}

		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() < 1 || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) {
				return false;
			}
			return isMatch(s.substring(1), p.substring(1));
		} else {
			int i = -1;
			while (i < s.length() && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a"));
	}
}
