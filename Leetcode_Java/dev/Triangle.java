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
 */
public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (triangle.size() == 0)
			return 0;
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

				dp[j] = Math.min(dp[j + 1], dp[j]) + triangle.get(i).get(j);
			}
		}

		return dp[0];
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> one = new ArrayList<Integer>();
		one.add(1);
		ArrayList<Integer> two = new ArrayList<Integer>();
		two.add(2);
		two.add(3);
		ArrayList<Integer> three = new ArrayList<Integer>();
		three.add(1);
		three.add(-1);
		three.add(-3);
		triangle.add(one);
		triangle.add(two);
		triangle.add(three);

		Triangle triangle2 = new Triangle();
		System.out.println(triangle2.minimumTotal(triangle));
	}
}
