package solution;

import java.util.ArrayList;
import java.util.List;

/*
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

 Ensure that numbers within the set are sorted in ascending order.


 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]

 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
	public List<List<Integer>> combinationSum3II(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (k <= 0) {
			return res;
		}

		helper2(res, k, n, 1, new ArrayList<Integer>());

		return res;
	}

	private void helper2(List<List<Integer>> res, int k, int target, int start, List<Integer> tmpList) {
		if (tmpList.size() > k) {
			return;
		} else if (tmpList.size() == k && target == 0) {
			res.add(new ArrayList<Integer>(tmpList));
			return;
		} else {
			for (int i = start; i <= 9; i++) {
				tmpList.add(i);
				helper2(res, k, target - i, i + 1, tmpList);
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (k <= 0) {
			return res;
		}

		helper(res, k, n, 1, new ArrayList<Integer>());

		return res;
	}

	private void helper(List<List<Integer>> res, int k, int target, int start, List<Integer> tmp) {
		if (k == 1) {
			if (target < start || target > 9) {
				return;
			}
			tmp.add(target);
			res.add(tmp);
			return;
		}

		for (int i = start; i < 10 && i <= target / k; i++) {
			List<Integer> subIntegers = new ArrayList<Integer>(tmp);
			subIntegers.add(i);
			helper(res, k - 1, target - i, i + 1, subIntegers);
		}
	}
}
