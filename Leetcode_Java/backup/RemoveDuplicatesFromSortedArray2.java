package hack.leetcode.dev;

/*
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesFromSortedArray2 {
	public static int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int idx = 0;
		int pre = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] != pre) {
				idx++;
				A[idx] = A[i];
				pre = A[i];
			} 
		}
		return idx + 1;
	}

	public static void main(String[] args) {
		int[] A = {1,1,2};
		System.out.println(removeDuplicates(A));
	}
}
