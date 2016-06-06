package hack.leetcode.dev;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimetoBuyandSellStockIII {
	public static int maxProfit(int[] prices) {
		if ((prices == null) || (prices.length == 0))
			return 0;
		int[] endWithI = new int[prices.length];
		int[] startWithI = new int[prices.length];
		int min = prices[0];
		int max = prices[prices.length - 1];

		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			endWithI[i] = Math.max(endWithI[i - 1], prices[i] - min);
		}

		for (int i = prices.length - 2; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			startWithI[i] = Math.max(startWithI[i + 1], max - prices[i]);
		}

		int maxProfile = 0;
		for (int i = 0; i < prices.length; i++) {
			maxProfile = Math.max(startWithI[i] + endWithI[i], maxProfile);
		}
		return maxProfile;
	}

	public static void main(String[] args) {
		int[] prices = { 1 };
		System.out.println(maxProfit(prices));
	}
}
