package hack.leetcode.dev;

/*
 * Divide two integers without using multiplication, division and mod operator.
 */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		int res = 0;
		boolean sign = true;

		if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
			sign = false;
		}
		long a = dividend;
		a = Math.abs(a);
		long b = divisor;
		b = Math.abs(b);

		while (a >= b) {
			int multier = 1;
			long tmp = b;
			while (a >= tmp) {
				a -= tmp;
				res += multier;
				tmp += tmp;
				multier += multier;
			}
		}

		if (sign) {
			return -res;
		}
		return res;
	}

	public static void main(String[] args) {
		DivideTwoIntegers test = new DivideTwoIntegers();
		System.out.println(test.divide(-2147483648, 1));
	}
}
