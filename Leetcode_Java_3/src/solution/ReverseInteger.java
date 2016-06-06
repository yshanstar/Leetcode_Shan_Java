package solution;

public class ReverseInteger {
	public int reverse(int x) {
		if (x == 0) {
			return 0;
		}
		boolean isNeg = (x < 0);
		x = Math.abs(x);
		int res = 0;
		while (x > 0) {
			int tmp = x % 10;
			res = res * 10 + tmp;
			x = x / 10;
		}
		return isNeg ? 0 - res : res;
	}
}
