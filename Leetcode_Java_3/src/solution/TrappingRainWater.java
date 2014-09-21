package solution;

public class TrappingRainWater {
	public int trap(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		int left[] = new int[A.length];
		int right[] = new int[A.length];

		int max = 0;
		for (int i = 0; i < A.length; i++) {
			left[i] = max;
			max = Math.max(max, A[i]);
		}

		max = A[A.length - 1];
		right[A.length - 1] = max;
		for (int i = A.length - 2; i >= 0; i--) {
			right[i] = max;
			max = Math.max(max, A[i]);
		}

		int cTrap = 0;
		for (int i = 0; i < A.length; i++) {
			int tmp = Math.min(left[i], right[i]) - A[i];
			cTrap += (tmp > 0) ? tmp : 0;
		}

		return cTrap;
	}
}
