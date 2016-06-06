package solution;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int start = 0;
		int end = A.length - 1;
		while (start < end) {
			int mid = (end + start) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if (A[start] >= target) {
			return start;
		} else {
			return start + 1;
		}
	}
}
