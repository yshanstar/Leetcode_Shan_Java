package solution;

/*
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum >= s. 
 * If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int result = Integer.MAX_VALUE;

		if (nums.length == 0) {
			return 0;
		}

		int sum = 0;
		int i = 0;
		int j = 0;

		for (i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum >= s) {
				result = Math.min(i - j + 1, result);

				while (sum >= s) {
					sum -= nums[j++];
					if (sum >= s) {
						result = Math.min(i - j + 1, result);
					}
				}
			}
		}

		if (result == Integer.MAX_VALUE) {
			return 0;
		}

		return result;
	}
}
