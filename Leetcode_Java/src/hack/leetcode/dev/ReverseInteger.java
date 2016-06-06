package hack.leetcode.dev;

/*
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class ReverseInteger {
	public int reverse(int x) {
		int num = Math.abs(x);
		int ret = 0;
		while (num != 0) {
			ret = ret * 10 + num % 10;
			num /= 10;
		}
		if (x < 0) {
			return -ret;
		} else {
			return ret;
		}
	}
}
