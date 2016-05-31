package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return res;
		}

		Set<Integer> numSet = new HashSet<Integer>();
		for (int n : nums) {
			numSet.add(n);
		}
		helper(numSet, nums.length, new ArrayList<Integer>(), res);

		return res;
	}

	private void helper(Set<Integer> set, int size, List<Integer> tmpList, List<List<Integer>> res) {
		if (tmpList.size() == size) {
			res.add(new ArrayList<Integer>(tmpList));
			return;
		}

		Set<Integer> copySet = new HashSet<Integer>(set);

		for (Integer i : set) {
			tmpList.add(i);
			copySet.remove(i);
			helper(copySet, size, tmpList, res);
			tmpList.remove(tmpList.size() - 1);
			copySet.add(i);
		}
	}

	public static void main(String[] args) {
		Permutations test = new Permutations();
		int[] nums = new int[] { 0, 1 };
		test.permute(nums);
	}

	public List<List<Integer>> permute3(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return res;
		}

		boolean[] used = new boolean[nums.length];
		helper(nums, new ArrayList<Integer>(), used, res);

		return res;
	}

	private void helper(int[] nums, List<Integer> tmpList, boolean[] used, List<List<Integer>> res) {
		if (tmpList.size() == nums.length) {
			res.add(new ArrayList<Integer>(tmpList));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				used[i] = true;
				tmpList.add(nums[i]);
				helper(nums, tmpList, used, res);
				tmpList.remove(tmpList.size() - 1);
				used[i] = false;
			}
		}
	}

	public ArrayList<ArrayList<Integer>> permute2(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num.length == 0) {
			return res;
		}
		int[] used = new int[num.length];
		helper2(res, 0, num, new ArrayList<Integer>(), used);
		return res;
	}

	private void helper2(ArrayList<ArrayList<Integer>> res, int idx, int[] num, ArrayList<Integer> tmp, int[] used) {
		if (idx == num.length) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}

		for (int i = 0; i < num.length; i++) {
			if (used[i] == 0) {
				used[i] = 1;
				tmp.add(num[i]);
				helper2(res, idx + 1, num, tmp, used);
				used[i] = 0;
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
