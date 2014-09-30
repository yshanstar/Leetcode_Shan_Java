package solution;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null || s.isEmpty() || s.trim().isEmpty()) {
			return true;
		}
		char[] sChars = s.trim().toLowerCase().toCharArray();

		int i = 0;
		int j = sChars.length - 1;

		while (i < j) {
			if (!isAlphanumber(sChars[i])) {
				i++;
				continue;
			}
			if (!isAlphanumber(sChars[j])) {
				j--;
				continue;
			}
			if (i < j) {
				if (sChars[i] != sChars[j]) {
					return false;
				}
				i++;
				j--;
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

	public static void main(String[] args) {
		ValidPalindrome test = new ValidPalindrome();
		System.out.println(test.isPalindrome("......a....."));
	}
}
