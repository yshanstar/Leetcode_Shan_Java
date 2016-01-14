package solution;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int maxProduct = nums[0];

		int maxCur = nums[0];
		int minCur = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int a = nums[i] * maxCur;
			int b = nums[i] * minCur;

			maxCur = Math.max(Math.max(a, b), nums[i]);
			minCur = Math.min(Math.min(a, b), nums[i]);

			maxProduct = Math.max(maxProduct, maxCur);
		}

		return maxProduct;
	}
}
