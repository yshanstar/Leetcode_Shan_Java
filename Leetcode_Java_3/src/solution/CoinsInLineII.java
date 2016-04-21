package solution;

/*
 * There are n coins with different value in a line. Two players take turns to take one or two coins from left side until there are no more coins left. The player who take the coins with the most value wins.
Could you please decide the first player will win or lose?
Example Given values array A = [1,2,2], return true.
Given A = [1,2,4], return false.
 */
public class CoinsInLineII {
	public boolean firstWillWin(int[] values) {
		if (values == null || values.length == 0) {
			return false;
		}

		if (values.length <= 2) {
			return true;
		}

		// DP[i]表示从i到end能取到的最大value
		int length = values.length;
		int[] dp = new int[values.length];
		dp[length - 1] = values[length - 1];
		dp[length - 2] = values[length - 1] + values[length - 2];

		for (int i = length - 3; i >= 0; i--) {
			int a = (i + 4 <= length - 1) ? dp[i + 4] : 0;
			int b = (i + 3 <= length - 1) ? dp[i + 3] : 0;
			int c = (i + 2 <= length - 1) ? dp[i + 2] : 0;

			int v1 = values[i] + Math.min(c, b);
			int v2 = values[i] + values[i + 1] + Math.min(a, b);
			dp[i] = Math.max(v1, v2);
		}

		int total = 0;
		for (int value : values) {
			total += value;
		}

		return dp[0] > total - dp[0];
	}
}
