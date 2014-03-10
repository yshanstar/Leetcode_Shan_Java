package hack.leetcode.dev;

/*
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
	public static void sortColors(int[] A) {
		if (A.length == 1) {
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
				A[i--] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		int[] A = { 2, 2 };
		sortColors(A);
		System.out.println(A);
	}
}
