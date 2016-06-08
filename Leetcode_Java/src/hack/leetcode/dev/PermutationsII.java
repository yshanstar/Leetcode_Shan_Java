package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<List<Integer>>();

		if (nums == null || nums.length == 0) {
			return permutations;
		}

		Arrays.sort(nums);

		boolean[] used = new boolean[nums.length];

		helper(nums, used, permutations, new ArrayList<Integer>());

		return permutations;
	}

	private void helper(int[] nums, boolean[] used, List<List<Integer>> permutations, List<Integer> permutation) {
		if (permutation.size() == nums.length) {
			permutations.add(new ArrayList<Integer>(permutation));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				permutation.add(nums[i]);
				used[i] = true;
				helper(nums, used, permutations, permutation);
				used[i] = false;
				permutation.remove(permutation.size() - 1);

				while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
					i++;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 1, 1 };

		PermutationsII test = new PermutationsII();
		test.permuteUnique(nums);
	}
}
