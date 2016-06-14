package solution;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given set of points.

Example 1:
Given points = [[1,1],[-1,1]], return true.

Example 2:
Given points = [[1,1],[-1,-1]], return false.

Follow up:
Could you do better than O(n2)?
 */
public class LineReflection {
	public static boolean isReflected(int[][] points) {
		if (points == null) {
			return false;
		}

		if (points.length == 0 || points[0].length == 0) {
			return true;
		}

		if (points.length == 1) {
			return true;
		}

		int minX = points[0][0];
		int maxX = points[0][0];
		int y = points[0][1];

		for (int[] point : points) {
			if (point[1] != y) {
				y = point[1];
			}
			minX = Math.min(minX, point[0]);
			maxX = Math.max(maxX, point[0]);
		}

		final int xmax = maxX;
		final int xmin = minX;

		Arrays.sort(points, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0])
					return o1[0] - o2[0];
				return o1[0] - xmin <= xmax - o1[0] ? o1[1] - o2[1] : o2[1] - o1[1];
			}
		});

		int n = points.length;
		for (int i = 0, j = n - 1; i <= j; i++, j--)
			if ((points[i][0] - minX != maxX - points[j][0])
					|| (points[i][0] * 2 != minX + maxX && points[i][1] != points[j][1]))
				return false;

		return true;
	}

	public static void main(String[] args) {
		int[][] nums = new int[][] { { 1, 1 }, { 0, 0 }, { -1, 1 } };
		System.out.println(isReflected(nums));
	}
}
