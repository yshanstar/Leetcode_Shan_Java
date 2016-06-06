package solution;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		if (n < 0) {
			return null;
		}

		int[][] res = new int[n][n];

		int x = 0;
		int y = 0;
		int num = 1;

		for (int i = n; i > 0; i -= 2) {
			if (i == 1) {
				res[x][y] = num;
			} else {
				for (int j = 0; j < i - 1; j++) {
					res[x][y++] = num++;
				}
				for (int j = 0; j < i - 1; j++) {
					res[x++][y] = num++;
				}
				for (int j = 0; j < i - 1; j++) {
					res[x][y--] = num++;
				}
				for (int j = 0; j < i - 1; j++) {
					res[x--][y] = num++;
				}
			}
			x++;
			y++;
		}

		return res;
	}
}
