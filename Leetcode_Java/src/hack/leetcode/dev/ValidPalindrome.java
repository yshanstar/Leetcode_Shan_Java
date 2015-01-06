package hack.leetcode.dev;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() == 0 || s.length() == 1) {
			return true;
		}
		int i = 0;
		int j = s.length() - 1;
		char[] sChar = s.toLowerCase().toCharArray();
		while (i < j) {
			if (!isAlphanumber(sChar[i])) {
				i++;
			} else if (!isAlphanumber(sChar[j])) {
				j--;
			} else if (sChar[i++] != sChar[j--])
				return false;
		}
		return true;
	}

	private boolean isAlphanumber(char c) {
		if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ValidPalindrome validPalindrome = new ValidPalindrome();
		validPalindrome.isPalindrome("......a.....");
	}
}
