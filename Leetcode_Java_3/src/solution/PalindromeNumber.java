package solution;

/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		if (x >= 0 && x <= 9) {
			return true;
		}

		int count = 1;
		while (count <= x / 10) {
			count *= 10;
		}

		for (int j = 1; j < count; j *= 10, count /= 10) {
			int dh = (x / count) % 10;
			int dl = (x / j) % 10;
			if (dh != dl) {
				return false;
			}
		}

		return true;
	}
}
