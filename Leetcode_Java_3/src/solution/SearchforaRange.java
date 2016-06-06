package solution;

public class SearchforaRange {
	public int[] searchRange(int[] A, int target) {
		int[] res = new int[2];
		res[0] = -1;
		res[1] = -1;

		if (A.length == 0) {
			return res;
		} else if (A.length == 1) {
			if (A[0] == target) {
				res[0] = res[1] = 0;
			}
			return res;
		}

		int start = 0;
		int end = A.length - 1;
		while (start < end) {
			int mid = (end + start) / 2;
			if (A[mid] < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		if (A[start] != target) {
			return res;
		}

		res[0] = start;
		start = 0;
		end = A.length - 1;
		while (start < end) {
			int mid = (end + start) / 2;
			if (A[mid] > target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		if (A[start] != target) {
			res[1] = start - 1;
		} else {
			res[1] = start;
		}

		return res;
	}

	public static void main(String[] args) {
		SearchforaRange test = new SearchforaRange();
		int[] A = { 1, 2, 3 };
		System.out.println(test.searchRange(A, 2));
	}
}
