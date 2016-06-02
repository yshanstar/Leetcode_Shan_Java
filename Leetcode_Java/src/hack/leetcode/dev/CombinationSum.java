package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 <= a2 <= … <= ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 2,3,6,7 and target 7, 
 A solution set is: 
 [7] 
 [2, 2, 3] 
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0 || target < 0) {
			return res;
		}

		Arrays.sort(candidates);
		helper(candidates, res, target, new ArrayList<Integer>(), 0);

		return res;
	}

	private void helper(int[] candidates, List<List<Integer>> res, int target, List<Integer> tmpList, int start) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(tmpList));
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			if (target < candidates[i]) {
				return;
			}
			tmpList.add(candidates[i]);
			helper(candidates, res, target - candidates[i], tmpList, i);
			tmpList.remove(tmpList.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2 };
		CombinationSum test = new CombinationSum();
		test.combinationSum(nums, 3);
	}
}
