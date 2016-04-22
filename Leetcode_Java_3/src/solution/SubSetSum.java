package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array of integers and a target, find the sub set(any elements) that sum up to target
 */
public class SubSetSum {
	public List<List<Integer>> findSubSet(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (nums == null || nums.length == 0) {
			return res;
		}

		Arrays.sort(nums);

		helper(nums, target, new ArrayList<Integer>(), res, 0);

		return res;
	}

	private void helper(int[] nums, int target, List<Integer> tmpRes, List<List<Integer>> res, int idx) {
		if (target != 0 && idx == nums.length) {
			return;
		}

		if (target == 0) {
			res.add(new ArrayList<Integer>(tmpRes));
			return;
		}

		for (int i = idx; i < nums.length; i++) {
			tmpRes.add(nums[i]);
			helper(nums, target - nums[i], tmpRes, res, i + 1);
			tmpRes.remove(tmpRes.size() - 1);
		}
	}

	public static void main(String[] args) {
		SubSetSum test = new SubSetSum();
		int[] nums = new int[] { 2, 1, 4, 2, 5 }; // {1, 2, 2, 4, 5}

		/*
		 * 1 1 2 1 2 2 1 2 2 4 1 2 2 5 1 2 2 1 2 1 2 2 2 2
		 */

		List<List<Integer>> res = test.findSubSet(nums, 7);
		for (List<Integer> set : res) {
			print(set);
		}
	}

	private static void print(List<Integer> list) {
		String listString = "";

		for (int s : list) {
			listString += s + "\t";
		}

		System.out.println(listString);
	}
}
