package solution;

public class JumpGame {
	public boolean canJump(int[] A) {
		if (A == null || A.length <= 1) {
			return true;
		}
		int length = A.length;
		int max = 0;
		for (int i = 0; i <= max && i < length; i++) {
			if (A[i] + i > max) {
				max = A[i] + i;
			}
			if (max >= length - 1) {
				return true;
			}
		}
		return false;
	}
}
