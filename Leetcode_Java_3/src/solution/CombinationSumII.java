package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
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
