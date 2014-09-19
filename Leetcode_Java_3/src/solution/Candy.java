package solution;

public class Candy {
	public int candy(int[] ratings) {
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
}
