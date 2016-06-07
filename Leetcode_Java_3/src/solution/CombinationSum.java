package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7, 
 A solution set is: 
 */
public class CombinationSum {
	public List<List<Integer>> combinationSumDP(int[] candidates, int target) {
		List<List<Integer>> empty = new ArrayList<List<Integer>>();

		if (candidates == null || candidates.length == 0) {
			return empty;
		}

		Arrays.sort(candidates);

		Map<Integer, List<List<Integer>>> dp = new HashMap<Integer, List<List<Integer>>>();
		List<Integer> m = new ArrayList<Integer>();
		List<List<Integer>> n = new ArrayList<List<Integer>>();
		n.add(m);
		dp.put(0, n);

		for (int i = 0; i < candidates.length; i++) {
			for (int s = 1; s <= target; s++) {
				if (s >= candidates[i] && dp.containsKey(s - candidates[i])) {
					List<List<Integer>> dpList = dp.get(s - candidates[i]);
					List<List<Integer>> a = new ArrayList<List<Integer>>();

					for (List<Integer> list : dpList) {
						List<Integer> tmp = new ArrayList<Integer>(list);
						tmp.add(candidates[i]);
						a.add(tmp);
					}

					if (dp.containsKey(s)) {
						List<List<Integer>> b = dp.get(s);
						b.addAll(a);
					} else {
						dp.put(s, a);
					}
				}
			}
		}

		return dp.containsKey(target) ? dp.get(target) : empty;
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (candidates == null || candidates.length == 0) {
			return res;
		}

		Arrays.sort(candidates);

		helperCom(candidates, res, new ArrayList<Integer>(), target, 0);

		return res;
	}

	private void helperCom(int[] candidates, List<List<Integer>> res, List<Integer> tmpRes, int target, int startIdx) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(tmpRes));
			return;
		}

		for (int i = startIdx; i < candidates.length; i++) {
			int candidate = candidates[i];
			if (candidate > target) {
				return;
			}

			tmpRes.add(candidate);
			helperCom(candidates, res, tmpRes, target - candidate, i);
			tmpRes.remove(tmpRes.size() - 1);
		}
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
