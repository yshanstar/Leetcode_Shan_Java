package hack.leetcode.dev;

/*
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive2 {
	public static int firstMissingPositive(int[] A) {
		int idx = 0;
		while (idx < A.length) {
			if (A[idx] != (idx + 1) && A[idx] >= 1 && A[idx] <= A.length && A[idx] != A[A[idx] - 1]) {
				int tmp = A[idx];
				A[idx] = A[tmp - 1];
				A[tmp - 1] = tmp;
			} else {
				idx++;
			}
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}
		return A.length + 1;
	}

	public static void main(String[] args) {
		int[] A = { -5, 1, 2, 3 };
		System.out.println(firstMissingPositive(A));
	}
}
