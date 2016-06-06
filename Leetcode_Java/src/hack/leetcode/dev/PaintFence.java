package hack.leetcode.dev;

/*
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * Return the total number of ways you can paint the fence.
 */
public class PaintFence {
	public int numWays(int n, int k) {
		if (n == 0 || k == 0) {
			return 0;
		}

		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			if (i == 0) {
				dp[i] = k;
			} else if (i == 1) {
				dp[i] = k * k;
			} else {
				dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1);
			}
		}

		return dp[dp.length - 1];
	}

	public int numWays2(int n, int k) {
		if (n <= 0 || k <= 0) {
			return 0;
		}

		if (n == 1)
			return k;
		if (n == 2)
			return k * k;

		int sameColor = k;
		int notSame = k * (k - 1);

		for (int i = 2; i < n; i++) {
			int temp = sameColor;
			sameColor = notSame;
			notSame = temp * (k - 1) + notSame * (k - 1);
		}

		return sameColor + notSame;
	}
}
