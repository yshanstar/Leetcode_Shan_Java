package solution;

import java.util.HashMap;
import java.util.Map;

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
public class MaximumSizeSubarraySumEqualsToK {
	public int maxSubArrayLen(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i - 1];
		}

		int maxLength = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);

		for (int i = 0; i < n; i++) {
			if (map.containsKey(nums[i] - k)) {
				maxLength = Math.max(maxLength, i - map.get(nums[i] - k));
			}

			if (!map.containsKey(nums[i])) {
				map.put(nums[i], i);
			}
		}

		return maxLength;
	}
}
