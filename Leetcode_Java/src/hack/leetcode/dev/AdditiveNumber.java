package hack.leetcode.dev;

import java.math.BigInteger;

/*
 * Additive number is a positive integer whose digits can form additive sequence.

 A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

 For example:
 "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 1 + 99 = 100, 99 + 100 = 199
 Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

 Given a string represents an integer, write a function to determine if it's an additive number.

 Follow up:
 How would you handle overflow for very large input integers?
 */
public class AdditiveNumber {
	public boolean isAdditiveNumber(String num) {
		int len = num.length();
		for (int i = 1; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (helper(num, i, j - i)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean helper(String num, int len1, int len2) {
		if (num.length() < len1 + len2) {
			return false;
		}

		String num1 = num.substring(0, len1);
		String num2 = num.substring(len1, len1 + len2);

		if ((num1.length() != 1 && num1.startsWith("0"))
				|| (num2.length() != 1 && num2.startsWith("0"))) {
			return false;
		}

		BigInteger sum = new BigInteger(num1).add(new BigInteger(num2));
		String sumStr = sum.toString();

		if (len1 + len2 + sumStr.length() > num.length()) {
			return false;
		}

		if (num.substring(len1 + len2, len1 + len2 + sumStr.length()).equals(
				sumStr)) {
			if (len1 + len2 + sumStr.length() == num.length()) {
				return true;
			} else {
				return helper(num.substring(len1), len2, sumStr.length());
			}
		}
		return false;
	}

	public static void main(String[] args) {
		AdditiveNumber test = new AdditiveNumber();
		test.isAdditiveNumber("112358");
	}
}
