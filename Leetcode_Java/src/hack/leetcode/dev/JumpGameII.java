package hack.leetcode.dev;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGameII {
	public static int jump(int[] A) {
		int curMax = 0;
		int step = 0;
		int nextMax = 0;
		for (int i = 0; i < A.length; i++) {
			if (i > curMax) {
				curMax = nextMax;
				step++;
			}
			nextMax = Math.max(nextMax, A[i] + i);
		}
		return step;
	}

	public static void main(String[] args) {
		int[] A = { 2, 3, 1, 1, 4 };
		System.out.println(jump(A));
	}
}
