package hack.leetcode.dev;

import java.util.HashMap;

/*
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
 */
public class MaximumSizeSubarraySumEqualsk {
	public int maxSubArrayLen(int[] nums, int k) {
		int sum = 0;
		int maxLength = 0;

		HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			if (sum == k) {
				maxLength = i + 1;
			} else if (maps.containsKey(sum - k)) {
				maxLength = Math.max(maxLength, i - maps.get(sum - k));
			}

			if (!maps.containsKey(sum)) {
				maps.put(sum, i);
			}
		}

		return maxLength;
	}

	public static void main(String[] args) {
		MaximumSizeSubarraySumEqualsk test = new MaximumSizeSubarraySumEqualsk();
		test.maxSubArrayLen(new int[] { 1, -1, 5, -2, 3 }, 4);
	}
}
