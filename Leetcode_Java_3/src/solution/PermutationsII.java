package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].
 */
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return res;
		}

		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		helper(used, nums, res, new ArrayList<Integer>());

		return res;
	}

	private void helper(boolean[] used, int[] nums, List<List<Integer>> res, List<Integer> tmpList) {
		if (tmpList.size() == nums.length) {
			res.add(new ArrayList<Integer>(tmpList));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				used[i] = true;
				tmpList.add(nums[i]);
				helper(used, nums, res, tmpList);
				used[i] = false;
				tmpList.remove(tmpList.size() - 1);
				while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
					i++;
				}
			}
		}
	}

	public List<List<Integer>> permuteUnique2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			res.add(new ArrayList<Integer>());
			return res;
		}
		Arrays.sort(nums);
		int[] used = new int[nums.length];
		helper2(nums, res, 0, new ArrayList<Integer>(), used);

		return res;
	}

	private void helper2(int[] nums, List<List<Integer>> res, int idx, List<Integer> tmpList, int[] used) {
		if (idx >= nums.length) {
			res.add(new ArrayList<Integer>(tmpList));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i] == 0) {
				tmpList.add(nums[i]);
				used[i] = 1;
				helper2(nums, res, idx + 1, new ArrayList<Integer>(tmpList), used.clone());
				used[i] = 0;
				tmpList.remove(tmpList.size() - 1);
				while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
					i++;
				}
			}
		}
	}
}
