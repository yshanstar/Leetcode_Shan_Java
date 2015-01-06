package hack.leetcode.dev;

/*
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class Candy {
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		int[] candies = new int[ratings.length];
		for (int i = 0; i < ratings.length; i++) {
			candies[i] = 1;
		}
		for (int i = 1; i < ratings.length; i++) {
			checkCandy(candies, i, ratings);
		}

		int total = 0;
		for (int i : candies) {
			total += i;
		}
		return total;
	}

	private void checkCandy(int[] candies, int start, int[] ratings) {
		while (start > 0) {
			if (ratings[start - 1] > ratings[start] && candies[start - 1] <= candies[start]) {
				candies[start - 1] = candies[start] + 1;
			} else if (ratings[start - 1] < ratings[start] && candies[start - 1] >= candies[start]) {
				candies[start] = candies[start - 1] + 1;
			} else {
				return;
			}
			start--;
		}
	}
}
