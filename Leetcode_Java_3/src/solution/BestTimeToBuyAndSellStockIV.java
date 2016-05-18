package solution;

import java.util.Arrays;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIV {
	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length < 2 || k <= 0) {
			return 0;
		}

		int len = prices.length;
		if (k > len / 2) {
			return getMaxProfile(prices);
		}

		int[] buy = new int[k];
		int[] sell = new int[k];

		Arrays.fill(buy, Integer.MIN_VALUE);

		for (int price : prices) {
			int tmp = 0;
			for (int i = 0; i < k; i++) {
				int buffer = 0;
				buffer = tmp - price;

				buy[i] = Math.max(buy[i], buffer);

				buffer = buy[i] + price;

				sell[i] = Math.max(sell[i], buffer);

				tmp = sell[i];
			}
		}

		return sell[k - 1];
	}

	private int getMaxProfile(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}

		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			maxProfit = Math.max(maxProfit, maxProfit + prices[i] - prices[i - 1]);
		}

		return maxProfit;
	}
}
