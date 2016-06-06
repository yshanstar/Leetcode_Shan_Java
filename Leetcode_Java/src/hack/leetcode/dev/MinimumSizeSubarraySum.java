package hack.leetcode.dev;

/*
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int minLength = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		int sum = 0;

		for (i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum >= s) {
				minLength = Math.min(minLength, i - j + 1);
				
				while (sum >= s && j<=i) {
					sum -= nums[j++];
					if (sum >= s) {
						minLength = Math.min(minLength, i - j + 1);
					}
				}
			}
			
		}

		if (minLength == Integer.MAX_VALUE) {
			return 0;
		}

		return minLength;
	}

	public static void main(String[] args) {
		MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
		int res = test.minSubArrayLen(6, new int[] { 10, 2, 3 });
		System.out.println(res);
	}
}
