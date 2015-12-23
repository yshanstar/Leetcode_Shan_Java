package solution;

/*
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */
public class NumberofDigitOne {
	public int countDigitOne(int n) {
		int ones = 0;
		for (long m = 1; m <= n; m *= 10) {
			long a = n / m, b = n % m;
			ones += (a + 8) / 10 * m;
			if (a % 10 == 1)
				ones += b + 1;
		}
		return ones;
	}

	public int countDigitOne2(int n) {
		if (n <= 0)
			return 0;
		int q = n, x = 1, ans = 0;
		do {
			int digit = q % 10;
			q /= 10;
			ans += q * x;
			if (digit == 1)
				ans += n % x + 1;
			if (digit > 1)
				ans += x;
			x *= 10;
		} while (q > 0);
		return ans;
	}

	public static void main(String[] args) {
		NumberofDigitOne test = new NumberofDigitOne();
		test.countDigitOne2(13);
	}
}
