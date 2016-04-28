package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <= b <= c <= d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (nums == null || nums.length == 0) {
			return res;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			if (i != 0 && nums[i - 1] == nums[i]) {
				continue;
			}

			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				getRestCandidates(nums, i, j, j + 1, nums.length - 1, target, res);
			}
		}

		return res;
	}

	private void getRestCandidates(int[] nums, int i, int j, int p, int q, int target, List<List<Integer>> res) {
		while (p < q) {
			int sum = nums[i] + nums[j] + nums[p] + nums[q];
			if (sum == target) {
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.add(nums[i]);
				tmp.add(nums[j]);
				tmp.add(nums[p]);
				tmp.add(nums[q]);
				res.add(tmp);
				p++;
				q--;
				while (p < q && nums[p] == nums[p - 1]) {
					p++;
				}
				while (p < q && nums[q] == nums[q + 1]) {
					q--;
				}
			} else if (sum < target) {
				p++;
			} else {
				q--;
			}
		}
	}
}
