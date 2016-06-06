package hack.leetcode.dev;

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {
	public static int trap(int[] A) {
		int len = A.length;
		if (len < 3) {
			return 0;
		}
		int start = 0;
		int end = len - 1;
		int res = 0;
		int runner = 0;
		while (start < end) {
			if (A[start] <= A[end]) {
				runner = start + 1;
				while (A[runner] <= A[start] && runner < end) {
					res += A[start] - A[runner];
					runner++;
				}
				start = runner;
			} else {
				runner = end - 1;
				while (A[runner] <= A[end] && runner > start) {
					res += A[end] - A[runner];
					runner--;
				}
				end = runner;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] A = { 0, 0, 0, 0, 1, 2 };
		System.out.println(trap(A));
	}
}
