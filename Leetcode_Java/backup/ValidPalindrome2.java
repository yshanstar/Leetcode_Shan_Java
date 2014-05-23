package hack.leetcode.dev;

/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome2 {
	public boolean isPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return true;
		}

		char[] sChar = s.toLowerCase().toCharArray();
		int i = 0;
		int j = s.length() - 1;

		while (i < j) {
			if (!isAlphanumber(sChar[i])) {
				i++;
			} else if (!isAlphanumber(sChar[j])) {
				j--;
			} else if (sChar[i++] != sChar[j--]) {
				return false;
			}
		}
		return true;
	}

	private boolean isAlphanumber(char c) {
		if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
			return true;
		}
		return false;
	}
}
