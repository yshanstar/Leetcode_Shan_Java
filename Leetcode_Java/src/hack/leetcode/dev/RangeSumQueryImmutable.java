package hack.leetcode.dev;

import hack.leetcode.ulti.Ultitool;

/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

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
		if (nums != null && nums.length != 0) {
			dp = new int[nums.length];

			int total = nums[0];
			dp[0] = total;
			for (int i = 1; i < nums.length; i++) {
				total += nums[i];
				dp[i] = total;
			}
		}
	}

	public int sumRange(int i, int j) {
		if (i == 0) {
			return dp[j];
		} else {
			return dp[j] - dp[i - 1];
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] { -2, 0, 3, -5, 2, -1 };
		RangeSumQueryImmutable test = new RangeSumQueryImmutable(array);
		Ultitool.print(test.sumRange(0, 2));
		Ultitool.print(test.sumRange(2, 5));
		Ultitool.print(test.sumRange(0, 5));
	}
}
