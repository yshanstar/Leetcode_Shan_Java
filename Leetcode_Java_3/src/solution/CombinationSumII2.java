package solution;

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
 */
public class CombinationSumII2 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates);

		helper(res, candidates, new ArrayList<Integer>(), 0, target);
		return res;
	}

	private void helper(List<List<Integer>> res, int[] candidates, List<Integer> tmp, int idx, int target) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}

		if (target < 0 || idx > candidates.length) {
			return;
		}

		for (int i = idx; i < candidates.length; i++) {
			if (i > idx && candidates[i] == candidates[i - 1]) {
				continue;
			}

			tmp.add(candidates[i]);
			helper(res, candidates, tmp, i + 1, target - candidates[i]);
			tmp.remove(tmp.size() - 1);
		}
	}
}
