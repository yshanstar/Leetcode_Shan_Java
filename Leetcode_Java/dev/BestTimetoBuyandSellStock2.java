package hack.leetcode.dev;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 */
public class BestTimetoBuyandSellStock2 {
	public int maxProfit(int[] prices) {
		int min = 0;
		int maxProfilt = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < prices[min]) {
				min = i;
			}
			int profit = prices[i] - prices[min];
			if (profit > maxProfilt) {
				maxProfilt = profit;
			}
		}
		return maxProfilt;
	}
}
