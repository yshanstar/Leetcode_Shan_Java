package solution;

public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] A) {
		if (A == null) {
			return 0;
		}
		if (A.length <= 2) {
			return A.length;
		}

		int idx = 0;
		int count = 1;
		int target = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] == target) {
				count++;
				if (count > 2) {
					continue;
				}
			} else {
				count = 1;
			}
			idx++;
			A[idx] = A[i];
			target = A[i];
		}

		return idx + 1;
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArrayII test = new RemoveDuplicatesfromSortedArrayII();
		int[] A = new int[] { 1, 1, 1, 1, 3, 3 };
		System.out.println(test.removeDuplicates(A));
		System.out.println(A);
	}
}
