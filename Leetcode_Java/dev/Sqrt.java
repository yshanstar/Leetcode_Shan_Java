package hack.leetcode.dev;

public class Sqrt {
	public int sqrt(int x) {
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
