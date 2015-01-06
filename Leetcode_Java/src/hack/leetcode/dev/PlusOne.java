package hack.leetcode.dev;

/*
 * Given a number represented as an array of digits, plus one to the number.
 */
public class PlusOne {
	public static int[] plusOne(int[] digits) {
		int next = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (i == digits.length - 1) {
				next = (digits[i] + 1) / 10;
				digits[i] = (digits[i] + 1) % 10;
			} else {
				int tmp = digits[i];
				digits[i] = (tmp + next) % 10;
				next = (tmp + next) / 10;
			}
		}
		if (next == 0) {
			return digits;
		}
		int[] newDigits = new int[digits.length + 1];
		newDigits[0] = 1;
		for (int i = 1; i < newDigits.length; i++) {
			newDigits[i] = digits[i - 1];
		}
		return newDigits;
	}
}
