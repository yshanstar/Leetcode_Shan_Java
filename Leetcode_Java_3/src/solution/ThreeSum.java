package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {

			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int low = i + 1;
			int high = nums.length - 1;

			while (low < high) {
				int sum_two = nums[low] + nums[high];

				if (sum_two + nums[i] > 0) {
					high--;
				} else if (sum_two + nums[i] < 0) {
					low++;
				} else {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[low]);
					list.add(nums[high]);
					res.add(list);

					low++;
					high--;

					while (low < high && nums[low] == nums[low - 1]) {
						low++;
					}
					while (low < high && nums[high] == nums[high + 1]) {
						high--;
					}
				}
			}
		}
		return res;
	}
}
