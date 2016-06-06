package hack.leetcode.dev;

import java.util.ArrayList;

/*
 *  Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *	For example,
 *	If n = 4 and k = 2, a solution is:
 *	[
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 *	]
 *
 */
public class Combinations {
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (k > n) {
			return res;
		}
		if (k == 1) {
			for (int i = 1; i <= n; i++) {
				ArrayList<Integer> tmpRes = new ArrayList<Integer>();
				tmpRes.add(i);
				res.add(tmpRes);
			}
			return res;
		}
		for (int i = n; i >= k; i--) {
			for(ArrayList<Integer> tmp : combine(i-1, k-1)){
				tmp.add(i);
				res.add(tmp);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> res = combine(5, 2);
		System.out.println(res);
	}
}
