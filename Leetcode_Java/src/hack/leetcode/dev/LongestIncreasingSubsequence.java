package hack.leetcode.dev;

/*
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.
 */
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int max = 0;

		for (int i = 0; i < nums.length; i++) {
			max = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					max = Math.max(max, dp[j] + 1);
				}
			}
			dp[i] = max;
		}

		for (int i = 0; i < dp.length; i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public int lengthOfLISII(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int[] tails = new int[nums.length];
		int length = 0;
		tails[0] = nums[0];
		length++;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < tails[0]) {
				tails[0] = nums[i];
			} else if (nums[i] > tails[length - 1]) {
				tails[length] = nums[i];
				length++;
			} else {
				int idx = binarySearch(tails, 0, length - 1, nums[i]);
				tails[idx] = nums[i];
			}
		}
		return length;
	}

	private int binarySearch(int[] nums, int start, int end, int target) {
		while (start + 1 < end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (nums[start] == target) {
			return start;
		} else {
			return end;
		}
	}
}
