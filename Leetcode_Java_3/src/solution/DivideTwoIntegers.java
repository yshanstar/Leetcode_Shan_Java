package solution;

/*
 * Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {
	public static int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}

		if (dividend == 0) {
			return 0;
		}

		long res = 0;
		boolean sign = true;

		if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
			sign = false;
		}

		long a = dividend;
		a = Math.abs(a);
		long b = divisor;
		b = Math.abs(b);

		while (a >= b) {
			int count = 1;
			long tmp = b;
			while (a >= tmp) {
				a -= tmp;
				res += count;
				count = count << 1;
				tmp = tmp << 1;
			}
		}

		if (sign) {
			if (-res < Integer.MIN_VALUE) {
				return Integer.MAX_VALUE;
			}
			return (int) -res;
		}

		if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		return (int) res;
	}

	public static void main(String[] args) {
		divide(-2147483648, 1);
	}
}
