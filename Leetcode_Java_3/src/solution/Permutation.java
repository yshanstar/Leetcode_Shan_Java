package solution;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutation {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			res.add(new ArrayList<Integer>());
			return res;
		}
		int[] used = new int[nums.length];
		helper(nums, res, 0, new ArrayList<Integer>(), used);

		return res;
	}

	private void helper(int[] nums, List<List<Integer>> res, int idx, List<Integer> tmpList, int[] used) {
		if (idx >= nums.length) {
			res.add(new ArrayList<Integer>(tmpList));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i] == 0) {
				tmpList.add(nums[i]);
				used[i] = 1;
				helper(nums, res, idx + 1, new ArrayList<Integer>(tmpList), used.clone());
				used[i] = 0;
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}
}
