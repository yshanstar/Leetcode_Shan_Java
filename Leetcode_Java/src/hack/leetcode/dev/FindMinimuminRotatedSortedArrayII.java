package hack.leetcode.dev;

/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 * 
 */

public class FindMinimuminRotatedSortedArrayII {
	public int findMin(int[] num) {
		if (num == null || num.length == 0) {
			return Integer.MIN_VALUE;
		}

		int minValue = Integer.MAX_VALUE;
		int left = 0;
		int right = num.length - 1;
		while (left < right) {
			int mid = (right + left) / 2;
			minValue = Math.min(minValue, num[mid]);

			if (num[left] < num[mid]) {
				minValue = Math.min(num[left], minValue);
				left = mid + 1;
			} else if (num[left] > num[mid]) {
				right = mid - 1;
			} else {
				left++;
			}
		}
		minValue = Math.min(minValue, num[left]);
		minValue = Math.min(minValue, num[right]);

		return minValue;
	}
}
