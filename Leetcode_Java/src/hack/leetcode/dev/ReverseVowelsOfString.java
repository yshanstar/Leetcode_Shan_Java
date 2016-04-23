package hack.leetcode.dev;

/*
 * Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".
 */
public class ReverseVowelsOfString {
	public String reverseVowels(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		int i = 0;
		int j = s.length() - 1;

		char[] sChars = s.toCharArray();

		while (i < j) {
			while (i < j && !isVowels(sChars[i])) {
				i++;
			}

			while (i < j && !isVowels(sChars[j])) {
				j--;
			}

			if (i < j) {
				char tmp = sChars[i];
				sChars[i] = sChars[j];
				sChars[j] = tmp;
				i++;
				j--;
			}
		}

		return new String(sChars);
	}

	private boolean isVowels(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			return true;
		}

		if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
			return true;
		}

		return false;
	}
}
