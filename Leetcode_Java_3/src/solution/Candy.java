package solution;

import java.util.Arrays;

/*
 * There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?
 */
public class Candy {
	public static int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}

		int[] candy = new int[ratings.length];
		Arrays.fill(candy, 1);

		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candy[i] = candy[i - 1] + 1;
			}
		}

		for (int i = ratings.length - 1; i > 0; i--) {
			if (ratings[i - 1] > ratings[i] && candy[i - 1] <= candy[i]) {
				candy[i - 1] = candy[i] + 1;
			}
		}

		int res = 0;
		for (int num : candy) {
			res += num;
		}

		return res;
	}

	public int candy2(int[] ratings) {
		if (ratings.length == 0) {
			return 0;
		}
		int[] candies = new int[ratings.length];

		candies[0] = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			} else {
				candies[i] = 1;
			}
		}

		int sum = 0;
		for (int i = ratings.length - 1; i > 0; i--) {
			if (ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i]) {
				candies[i - 1] = candies[i] + 1;
			}
			sum += candies[i];
		}
		sum += candies[0];
		return sum;
	}

	public static void main(String[] args) {
		int[] ratings = new int[] { 1, 2, 3, 4, 5 };
		candy(ratings);
	}
}
