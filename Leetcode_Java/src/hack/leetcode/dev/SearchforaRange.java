package hack.leetcode.dev;

/*
 * 	Given a sorted array of integers, find the starting and ending position of a given target value.
 *	Your algorithm's runtime complexity must be in the order of O(log n).
 *	If the target is not found in the array, return [-1, -1].
 *	For example,
 *	Given [5, 7, 7, 8, 8, 10] and target value 8,
 *	return [3, 4].
 */
public class SearchforaRange {
	public int[] searchRange(int[] A, int target) {
		if (A == null || A.length == 0) {
			return null;
		}
		int[] range = { -1, -1 };

		int start = 0;
		int end = A.length - 1;
		int mid = 0;

		while (start < end) {
			mid = (end + start) / 2;
			if (A[mid] < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		if (A[start] != target) {
			return range;
		}
		range[0] = start;

		end = A.length;
		while (start < end) {
			mid = (end + start) / 2;
			if (A[mid] > target) {
				end = mid ;
			} else {
				start = mid + 1;
			}
		}
		range[1] = end - 1;

		return range;
	}
}
