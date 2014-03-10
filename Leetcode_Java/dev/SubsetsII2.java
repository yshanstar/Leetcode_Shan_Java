package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
	 [
		 [2],
		 [1],
		 [1,2,2],
		 [2,2],
		 [1,2],
		 []
	 ]
 */
public class SubsetsII2 {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		if (num.length < 0) {
			return null;
		}
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		res.add(new ArrayList<Integer>());
		helper(num, 0, res, new ArrayList<Integer>());
		return res;
	}

	@SuppressWarnings("unchecked")
	private void helper(int[] num, int idx, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmpRes) {
		ArrayList<Integer> tmpSubSet = new ArrayList<Integer>(tmpRes);
		if (idx >= num.length) {
			return;
		}
		for (int i = idx; i < num.length; i++) {
			tmpSubSet.add(num[i]);
			res.add((ArrayList<Integer>) tmpSubSet.clone());
			helper(num, i + 1, res, tmpSubSet);
			while (i < num.length - 1 && num[i] == num[i + 1]) {
				i++;
			}
			tmpSubSet.remove(tmpSubSet.size() - 1);
		}
	}
}
