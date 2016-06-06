package hack.leetcode.dev;

/*
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 */
public class RotateImage2 {
	public static void rotate(int[][] matrix) {
		if (matrix == null) {
			return;
		}
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
				matrix[n - 1 - i][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2 }, { 3, 4 } };
		rotate(matrix);
	}
}
