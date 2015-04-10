package hack.leetcode.dev;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimetoBuyandSellStockIV {
	public int maxProfit(int k, int[] prices) {
		int len = prices.length;

		if (len < 2 || k <= 0) {
			return 0;
		}

		if (k >= len) {
			return helper(prices);
		}

		int[][] global = new int[len][k + 1];
		int[][] local = new int[len][k + 1];

		for (int i = 1; i < len; i++) {
			int diff = prices[i] - prices[i - 1];
			for (int j = 1; j <= k; j++) {
				local[i][j] = Math.max(
						global[i - 1][j - 1] + Math.max(diff, 0),
						local[i - 1][j] + diff);
				global[i][j] = Math.max(global[i - 1][j], local[i][j]);
			}
		}

		return global[prices.length - 1][k];
	}

	private int helper(int[] prices) {
		int profit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			profit = Math.max(profit, profit + prices[i + 1] - prices[i]);
		}

		return profit;
	}
}
