package solution;

import java.util.Arrays;

/*
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		if (nums.length < 3) {
			return 0;
		}

		int res = Integer.MAX_VALUE;
		int absDiff = Integer.MAX_VALUE;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {

			int low = i + 1;
			int high = nums.length - 1;

			while (low < high) {
				int sum = nums[i] + nums[low] + nums[high];
				int diff = target - sum;

				if (diff == 0) {
					return sum;
				} else if (diff > 0) {
					low++;
				} else {
					high--;
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
