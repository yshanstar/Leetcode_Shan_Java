package hack.leetcode.dev;

/*
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 */
public class SearchinRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		int left = 0;
		int right = A.length - 1;
		int mid = 0;
		while (left <= right) {
			mid = (right + left) / 2;
			if (A[mid] == target) {
				return true;
			} else if (A[left] != A[right]) {
				if (A[left] <= A[mid]) {
					if (A[left] <= target && target < A[mid]) {
						right = mid - 1;
					} else {
						left = mid + 1;
					}
				} else {
					if (target <= A[right] && target > A[mid]) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}
			} else {
				for (int i = left; i < right; i++) {
					if (A[i] == target) {
						return true;
					}
				}
				return false;
			}
		}
		return true;
	}
}
