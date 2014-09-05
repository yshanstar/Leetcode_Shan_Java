package solution;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			max = Math.max(max, sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		return max;
	}
}
