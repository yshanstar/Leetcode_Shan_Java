package hack.leetcode.dev;

/*
 * Implement int sqrt(int x).
 Compute and return the square root of x.
 */
public class Sqrt {
	public int mySqrt(int x) {
		if (x <= 0) {
			return 0;
		}

		long low = 0;
		long high = x;

		while (high >= low) {
			long mid = (high + low) / 2;
			if (x < mid * mid) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return (int) high;
	}

	public int sqrt2(int x) {
		long lo = 0;
		long hi = x;

		while (hi >= lo) {
			long mid = (hi + lo) / 2;
			if (x < mid * mid)
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		return (int) hi;
	}
}
