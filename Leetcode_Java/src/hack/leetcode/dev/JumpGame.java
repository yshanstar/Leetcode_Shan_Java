package hack.leetcode.dev;

/*
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *	Each element in the array represents your maximum jump length at that position.
 *	Determine if you are able to reach the last index.
 *	For example:
 *	A = [2,3,1,1,4], return true.
 *	A = [3,2,1,0,4], return false.
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		if (A == null || A.length <= 1) {
			return true;
		}
		int length = A.length;
		boolean[] ret = new boolean[length];
		ret[length - 1] = true;

		for (int i = length - 2; i >= 0; i--) {
			int maxLength = A[i];
			for (int j = i + 1; (j < length) && (j <= i + maxLength); j++) {
				if (ret[j]) {
					ret[i] = true;
					break;
				}
			}
		}
		return ret[0];
	}

	public boolean canJump2(int[] A) {
		if (A.length <= 1) {
			return true;
		}

		int maxCover = 0;
		for (int i = 0; i <= maxCover && i < A.length; i++) {
			if (A[i] + i > maxCover) {
				maxCover = A[i] + i;
			}
			if (maxCover >= A.length - 1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

	}
}
