package solution;

public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
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
			boolean result = isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i));
			result = result || (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)));
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
