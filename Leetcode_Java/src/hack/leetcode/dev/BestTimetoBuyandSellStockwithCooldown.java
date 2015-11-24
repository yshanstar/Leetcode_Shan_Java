package hack.leetcode.dev;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 Example:

 prices = [1, 2, 3, 0, 2]
 maxProfit = 3
 transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimetoBuyandSellStockwithCooldown {
	public int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		int[] dp = new int[prices.length];
		int[] buy = new int[prices.length];
		int[] sell = new int[prices.length];
		int[] rest = new int[prices.length];

		buy[0] = -prices[0];

		for (int i = 1; i < prices.length; i++) {
			int price = prices[i];
			buy[i] = Math.max(rest[i - 1] - price, buy[i - 1]);
			sell[i] = Math.max(buy[i - 1] + price, sell[i - 1]);
			rest[i] = Math.max(rest[i - 1], Math.max(sell[i - 1], buy[i - 1]));
			dp[i] = Math.max(sell[i], Math.max(rest[i], buy[i]));
		}

		return dp[dp.length - 1];
	}
}
