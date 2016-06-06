package hack.leetcode.dev;

/*
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDuplicatesfromSortedArrayII2 {
	public int removeDuplicates(int[] A) {
		if (A.length <= 1) {
			return A.length;
		}
		int end = 1;
		int count = 1;
		int duplicate = A[0];
		for (int i = 1; i < A.length; i++) {
			A[end] = A[i];
			if (A[i] == duplicate) {
				if (count < 2) {
					count++;
					end++;
					duplicate = A[i];
				} else {
					count++;
				}
			} else {
				count = 1;
				duplicate = A[i];
				end++;
			}
		}
		return end;
	}
}
