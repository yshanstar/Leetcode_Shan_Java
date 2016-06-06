package solution;

public class SearchinRotatedSortedArray {
	public int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int start = 0;
		int end = A.length - 1;
		while (start <= end) {
			int mid = (end + start) / 2;
			if (A[mid] == target) {
				return mid;
			}
			if (A[start] <= A[mid]) {
				if (A[start] <= target && target < A[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (A[mid] < target && target <= A[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}
}
