package hack.leetcode.dev;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [âˆ?2,1,âˆ?3,4,âˆ?1,2,1,âˆ?5,4],
 * the contiguous subarray [4,âˆ?1,2,1] has the largest sum = 6. 
 */
public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			max = Math.max(sum, max);
			if (sum < 0) {
				sum = 0;
			}
		}
		return max;
	}

	public int maxSubArrayDivideAndConquer(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		return divideAndConquer(A, 0, A.length - 1);
	}

	private int divideAndConquer(int[] A, int left, int right) {
		if (left > right) {
			return Integer.MIN_VALUE;
		}

		if (left == right) {
			return A[left];
		}

		int mid = (right + left) / 2;

		int maxLeft = divideAndConquer(A, left, mid - 1);
		int maxRight = divideAndConquer(A, mid + 1, right);

		int midLeft = Integer.MIN_VALUE;
		int leftSum = 0;
		int midRight = Integer.MIN_VALUE;
		int rightSum = 0;

		for (int i = mid - 1; i >= left; i--) {
			leftSum += A[i];
			midLeft = Math.max(midLeft, leftSum);
		}

		for (int i = mid + 1; i <= right; i++) {
			rightSum += A[i];
			midRight = Math.max(midRight, rightSum);
		}

		int maxMid = A[mid] + Math.max(midLeft, 0) + Math.max(midRight, 0);
		return Math.max(Math.max(maxLeft, maxRight), maxMid);
	}
}
