package solution;

/*
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

 Below is one possible representation of s1 = "great":

 great
 /    \
 gr    eat
 / \    /  \
 g   r  e   at
 / \
 a   t
 To scramble the string, we may choose any non-leaf node and swap its two children.

 For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

 rgeat
 /    \
 rg    eat
 / \    /  \
 r   g  e   at
 / \
 a   t
 We say that "rgeat" is a scrambled string of "great".

 Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

 rgtae
 /    \
 rg    tae
 / \    /  \
 r   g  ta  e
 / \
 t   a
 We say that "rgtae" is a scrambled string of "great".

 Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1
 */
public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return true;
		} else if (s1 == null || s2 == null) {
			return false;
		} else if (s1.length() != s2.length()) {
			return false;
		}

		int[] chars = new int[256];

		for (char c : s1.toCharArray()) {
			chars[c]++;
		}

		for (char c : s2.toCharArray()) {
			chars[c]--;
		}

		for (int i : chars) {
			if (i != 0) {
				return false;
			}
		}

		if (s1.length() == 1 && s2.length() == 1) {
			return true;
		}

		int len = s1.length();

		for (int i = 1; i < s1.length(); i++) {
			boolean result = isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i));
			result = result || (isScramble(s1.substring(0, i), s2.substring(len - i)) && isScramble(s1.substring(i), s2.substring(0, len - i)));
			if (result) {
				return true;
			}
		}

		return false;
	}

	public boolean isScramble2(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return true;
		}
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}

		int[] chars = new int[26];
		for (char c : s1.toCharArray()) {
			chars[c - 'a']++;
		}
		for (char c : s2.toCharArray()) {
			chars[c - 'a']--;
		}
		for (int i : chars) {
			if (i != 0) {
				return false;
			}
		}

		if (s1.length() == 1 && s2.length() == 1) {
			return true;
		}

		for (int i = 1; i < s1.length(); i++) {
			boolean result = isScramble2(s1.substring(0, i), s2.substring(0, i)) && isScramble2(s1.substring(i), s2.substring(i));
			result = result || (isScramble2(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble2(s1.substring(i), s2.substring(0, s2.length() - i)));
			if (result) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		ScrambleString test = new ScrambleString();
		System.out.println(test.isScramble("ab", "ba"));
	}
}
