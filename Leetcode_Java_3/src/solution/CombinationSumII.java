package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2DP(int[] candidates, int target) {
		List<List<Integer>> empty = new ArrayList<List<Integer>>();

		if (candidates == null || candidates.length == 0) {
			return empty;
		}

		Arrays.sort(candidates);

		Map<Integer, List<List<Integer>>> dp = new HashMap<Integer, List<List<Integer>>>();
		HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>();
		List<List<Integer>> m = new ArrayList<List<Integer>>();
		m.add(new ArrayList<Integer>());
		dp.put(0, m);

		for (int candidate : candidates) {
			if (nums.containsKey(candidate)) {
				nums.put(candidate, nums.get(candidate) + 1);
			} else {
				nums.put(candidate, 1);
			}
		}

		for (int s = 1; s <= target; s++) {

			for (int i = 0; i < candidates.length; i++) {
				int candidate = candidates[i];

				if (i > 0 && candidates[i] == candidates[i - 1]) {
					continue;
				}

				if (s < candidate) {
					break;
				}

				int rem = s - candidate;
				if (dp.containsKey(rem)) {
					List<List<Integer>> a = new ArrayList<List<Integer>>();
					List<List<Integer>> dpList = dp.get(rem);

					for (List<Integer> tmpList : dpList) {
						HashMap<Integer, Integer> mapCopy = (HashMap<Integer, Integer>) nums.clone();
						List<Integer> tmp = new ArrayList<Integer>(tmpList);
						for (int number : tmp) {
							mapCopy.put(number, mapCopy.get(number) - 1);
						}

						if (mapCopy.get(candidate) <= 0) {
							continue;
						}
						tmp.add(candidate);
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

	public static void main(String[] args) {
		CombinationSumII test = new CombinationSumII();
		int[] candidates = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		test.combinationSum2DP(candidates, 8);
	}

	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) {
			return res;
		}
		Arrays.sort(num);

		helper(res, num, target, 0, new ArrayList<Integer>());

		return res;
	}

	private void helper(List<List<Integer>> res, int[] num, int target, int idx, List<Integer> tmp) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}

		if (target < 0 || idx > num.length) {
			return;
		}
		for (int i = idx; i < num.length; i++) {
			if (i > idx && num[i] == num[i - 1])
				continue;
			tmp.add(num[i]);
			helper(res, num, target - num[i], i + 1, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}
}
