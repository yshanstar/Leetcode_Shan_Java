package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 <= a2 <= … <= ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 A solution set is: 
 [1, 7] 
 [1, 2, 5] 
 [2, 6] 
 [1, 1, 6] 

 https://leetcode.com/discuss/104331/approach-backtracking-questions-permutations-combination
 */
public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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

			if (i > start && candidates[i] == candidates[i - 1]) {
				continue;
			}

			tmpList.add(candidates[i]);
			helper(candidates, res, target - candidates[i], tmpList, i + 1);
			tmpList.remove(tmpList.size() - 1);
		}
	}
}
