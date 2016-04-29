package solution;

/*
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

 Note:
 All costs are positive integers.

 Follow up:
 Could you solve it in O(nk) runtime?
 */
public class PaintHouseII {
	public static int minCostII(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}

		int m = costs.length;
		int n = costs[0].length;

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < n; k++) {
					if (k == j) {
						continue;
					}
					min = Math.min(min, costs[i - 1][k]);
				}
				costs[i][j] += min;
			}
		}

		int min = Integer.MAX_VALUE;
		for (int j = 0; j < n; j++) {
			min = Math.min(min, costs[m - 1][j]);
		}

		return min;
	}

	public static void main(String[] args) {
		int[][] costs = new int[][] { { 1, 5, 3 }, { 2, 9, 4 } };
		minCostII(costs);
	}
}
