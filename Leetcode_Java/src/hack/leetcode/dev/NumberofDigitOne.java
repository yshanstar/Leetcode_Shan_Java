package hack.leetcode.dev;

/*
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * For example:
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */
public class NumberofDigitOne {
	public int countDigitOne(int n) {
		int ret = 0;
		int x = 1;
		int prev = 0;
		while (n > 0) {
			if (n % 10 > 0) {
				if (n % 10 > 1) {
					ret += x;
				} else {
					ret += prev + 1;
				}
			}
			prev += (n % 10) * x;
			n /= 10;
			ret += n * x;
			x *= 10;
		}
		return ret;
	}

	public static void main(String[] args) {
		NumberofDigitOne test = new NumberofDigitOne();
		test.countDigitOne(13);
	}
}
