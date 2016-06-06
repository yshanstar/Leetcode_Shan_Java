package hack.leetcode.dev;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */

public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int maxProduct = A[0];

		// max current number
		int maxTmp = A[0];

		// min current number
		int minTmp = A[0];

		for (int i = 1; i < A.length; i++) {
			int a = A[i] * maxTmp;
			int b = A[i] * minTmp;

			maxTmp = Math.max(Math.max(a, b), A[i]);
			minTmp = Math.min(Math.min(a, b), A[i]);

			maxProduct = Math.max(maxProduct, maxTmp);
		}

		return maxProduct;
	}
}
