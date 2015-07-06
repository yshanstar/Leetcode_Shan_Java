package hack.leetcode.dev;

/*
 * Given an integer, write a function to determine if it is a power of two.
 */

public class PowerofTwo {
	public boolean isPowerOfTwo(int n) {
		if (n <= 0) {
			return false;
		}

		if (n == 1) {
			return true;
		}

		int count = 0;
		while (n != 0) {
			int tmp = n & 1;
			if (tmp == 1) {
				count++;
			}

			n = n >> 1;
		}

		return count == 1;
	}
}
