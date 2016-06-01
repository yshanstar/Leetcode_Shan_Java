package solution;

/*
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		if (n <= 0) {
			return false;
		}

		return (Math.log10(n) / Math.log10(2)) % 1 == 0;
	}

	public boolean isPowerOfTwo2(int n) {
		if (n <= 0) {
			return false;
		}

		n &= (n - 1);

		return n == 0;
	}
}
