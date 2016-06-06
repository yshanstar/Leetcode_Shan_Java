package solution;

public class SortColors {
	public void sortColors(int[] A) {
		if (A.length == 0) {
			return;
		}
		int redIdx = -1;
		int blueIdx = A.length;
		for (int i = 0; i < blueIdx; i++) {
			if (A[i] == 0) {
				redIdx++;
				int tmp = A[redIdx];
				A[redIdx] = A[i];
				A[i] = tmp;
			} else if (A[i] == 2) {
				blueIdx--;
				int tmp = A[blueIdx];
				A[blueIdx] = A[i];
				A[i] = tmp;
				i--;
			}
		}
	}
}
