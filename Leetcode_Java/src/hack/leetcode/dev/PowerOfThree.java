package hack.leetcode.dev;

/*
 * Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
 */
public class PowerOfThree {
	public boolean isPowerOfThree(int n) {
		while (n > 1) {
			if (n % 3 != 0) {
				return false;
			}
			n /= 3;
		}

		return n == 1;
	}

	public boolean isPowerOfThree2(int n) {
		return (Math.log10(n) / Math.log10(3)) % 1 == 0;
	}
	
}
