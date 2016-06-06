package solution;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		if (A == null) {
			return 0;
		}

		int idx = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == elem) {
				continue;
			} else {
				A[idx++] = A[i];
			}
		}
		return idx;
	}
}
