package hack.leetcode.dev;

import java.util.ArrayList;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimetoBuyandSellStockII2 {
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 1) {
			return 0;
		}

		int maxProfit = 0;
		ArrayList<Integer> buy = new ArrayList<Integer>();
		ArrayList<Integer> sell = new ArrayList<Integer>();
		int i = 0;
		int next = 1;
		while (next < prices.length) {
			if (prices[next] >= prices[i]) {
				if (buy.size() == sell.size()) {
					buy.add(i);
				}
			} else {
				if (buy.size() > sell.size()) {
					sell.add(i);
				}
			}
			next++;
			i++;
		}
		if (buy.size() > sell.size()) {
			sell.add(prices.length - 1);
		}

		for (int j = 0; j < buy.size(); j++) {
			maxProfit += prices[sell.get(j)] - prices[buy.get(j)];
		}
		return maxProfit;
	}

	public static void main(String[] agrs) {
		int[] prices = { 1, 2 };
		System.out.println(maxProfit(prices));
	}
}
