package hack.leetcode.dev;

/*
 * 	Given a sorted array and a target value, return the index if the target is found. 
 * 	If not, return the index where it would be if it were inserted in order.
 *	You may assume no duplicates in the array.
 *	Here are few examples.
 *	[1,3,5,6], 5 → 2
 *	[1,3,5,6], 2 → 1
 *	[1,3,5,6], 7 → 4
 *	[1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		if (A.length == 0) {
			return 0;
		}
		if (A.length == 1) {
			return (target > A[0]) ? 1 : 0;
		}

		int left = 0;
		int right = A.length - 1;
		int mid = 0;
		while (left <= right) {
			mid = (right + left) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		if (A[mid] < target) {
			return mid + 1;
		} else {
			return mid;
		}
	}
}
