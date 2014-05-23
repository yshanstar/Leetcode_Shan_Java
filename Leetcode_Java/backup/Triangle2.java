package hack.leetcode.dev;

import java.util.ArrayList;

/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
	 [
			 [2],
			[3,4],
		   [6,5,7],
		  [4,1,8,3]
	 ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle2 {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle.size() == 0) {
			return 0;
		}
		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}

		int[] dp = new int[triangle.size()];

		for (int i = triangle.size() - 1; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				if (i == triangle.size() - 1) {
					dp[j] = triangle.get(i).get(j);
					continue;
				}
				dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
			}
		}
		return dp[0];
	}
}
