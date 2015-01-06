package hack.leetcode.dev;

import java.util.Arrays;

/*
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		if (num.length < 3) {
			return 0;
		}
		int res = Integer.MAX_VALUE;
		int absDiff = Integer.MAX_VALUE;
		Arrays.sort(num);

		for (int i = 0; i < num.length; i++) {
			int j = i + 1;
			int k = num.length - 1;

			while (j < k) {
				int sum = num[i] + num[j] + num[k];
				int diff = sum - target;
				if (diff == 0) {
					return sum;
				} else if (diff > 0) {
					k--;
				} else {
					j++;
				}
				if (Math.abs(diff) < absDiff) {
					absDiff = Math.abs(diff);
					res = sum;
				}
			}
		}
		return res;
	}
}
