package hack.leetcode.dev;

import java.util.ArrayList;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 */
public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> in = new ArrayList<Integer>();
		ArrayList<Integer> out = new ArrayList<Integer>();

		int profit = 0;

		boolean increase = false;
		boolean decrease = false;

		for (int i = 0; i < prices.length - 1; i++) {
			int j = i + 1;
			if (prices[j] > prices[i]) {
				if (!increase) {
					increase = true;
					decrease = false;
					in.add(i);
				}
				decrease = false;
			} else if (prices[j] < prices[i]) {
				if (!decrease) {
					decrease = true;
					increase = false;
					if (in.size() > out.size()) {
						out.add(i);
					}
				}
			}
		}

		if (increase && in.size() > out.size()) {
			out.add(prices.length - 1);
		}

		for (int i = 0; i < in.size(); i++) {
			profit += prices[out.get(i)] - prices[in.get(i)];
		}

		return profit;
	}

	public static void main(String[] args) {
		BestTimetoBuyandSellStockII bestTimetoBuyandSellStockII = new BestTimetoBuyandSellStockII();
		int[] prices = { 1, 2, 4 };
		bestTimetoBuyandSellStockII.maxProfit(prices);
	}
}
