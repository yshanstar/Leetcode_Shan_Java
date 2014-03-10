package hack.leetcode.dev;

import java.util.ArrayList;

/*
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			res.add(new ArrayList<Integer>());
			return res;
		}
		int[] used = new int[num.length];
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		helper(0, num, tmp, res, used);
		return res;
	}

	private void helper(int idx, int[] num, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> res, int[] used) {
		if (idx == num.length) {
			ArrayList<Integer> temp = new ArrayList<Integer>(tmp);
			res.add(temp);
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (used[i] == 0) {
				tmp.add(num[i]);
				used[i] = 1;
				helper(idx + 1, num, tmp, res, used);
				used[i] = 0;
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
