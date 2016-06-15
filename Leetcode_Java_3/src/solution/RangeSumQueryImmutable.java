package solution;

/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i <= j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 */
public class RangeSumQueryImmutable {
	int[] dp;

	public RangeSumQueryImmutable(int[] nums) {
		this.dp = new int[nums.length];

		if (nums.length >= 1) {
			this.dp[0] = nums[0];
		}

		for (int i = 1; i < nums.length; i++) {
			this.dp[i] = this.dp[i - 1] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		return (i == 0) ? dp[j] : dp[j] - dp[i - 1];
	}
}
