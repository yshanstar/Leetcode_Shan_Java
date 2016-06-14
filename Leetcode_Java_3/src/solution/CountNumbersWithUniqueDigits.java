package solution;

/*
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 <= x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 <= x < 100, excluding [11,22,33,44,55,66,77,88,99])
 */
public class CountNumbersWithUniqueDigits {
	public static int countNumbersWithUniqueDigits(int n) {
		if (n == 0) {
			return 1;
		}

		int result = 1;
		int availDigits = 9;
		int tmp = 1;

		for (int i = 0; i < n; i++) {
			if (i > 1) {
				availDigits -= 1;
			}
			tmp *= availDigits;
			result += tmp;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(countNumbersWithUniqueDigits(3));
	}
}
