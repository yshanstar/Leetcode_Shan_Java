package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates);
		helper(res, candidates, 0, target, new ArrayList<Integer>());
		return res;
	}

	private void helper(List<List<Integer>> res, int[] candidates, int idx, int target, List<Integer> tmp) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}

		for (int i = idx; i < candidates.length; i++) {
			if (target - candidates[i] < 0) {
				return;
			}
			tmp.add(candidates[i]);
			helper(res, candidates, i, target - candidates[i], tmp);
			tmp.remove(tmp.size() - 1);
		}
	}
}
