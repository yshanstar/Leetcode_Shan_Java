package solution;

/* 2-d array of "sharpness" values. Fine the path from left to right which has the highest minimum sharpness. 
 * 路径必须是从左往右，先有个起始点，然后每次要往右上，正右或右下跳一步。也就是说，路径长度是列数n，假设路径为(i1,1),(i2,2),...,(in,n)，
 * 路径必须满足每对i_k与i_{k-1}的距离不能大于1.

.5 .7 .2
.7 .5 .8
.9 .1 .5

在这个例子中，理想路径是.7->.7->.8因为这条路径中的最小值.7在所有路径中最大
*/
public class HighestMinimumSharpness {
	public static double maxPath(double[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0.0;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		double ans = 0;

		for (int c = 0; c < n; c++) {
			for (int r = 0; r < m; r++) {
				double t = matrix[r][c];
				if (r - 1 >= 0)
					t = Math.max(t, matrix[r - 1][c]);
				if (r + 1 < m)
					t = Math.max(t, matrix[r + 1][c]);
				matrix[r][c] = Math.min(matrix[r][c], t);

				if (c == n - 1)
					ans = Math.max(ans, matrix[r][c]);
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		double[][] matrix = new double[][] { { 0.5, 0.7, 0.2, 0.6 }, { 0.6, 0.8, 0.1, 0.9 }, { 0.7, 0.8, 0.2, 0.6 },
				{ 0.6, 0.9, 0.8, 0.2 } };
		System.out.println(maxPath(matrix));
	}
}
