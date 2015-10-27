package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<String>();

		if (nums == null || nums.length == 0) {
			res.add(getRange(lower, upper));
			return res;
		}

		int prev;
		if (nums[0] - lower > 0) {
			res.add(getRange(lower, nums[0] - 1));
			prev = nums[0];
		} else {
			prev = nums[0];
		}

		for (int cur : nums) {
			if (cur - prev > 1) {
				res.add(getRange(prev + 1, cur - 1));
			}
			prev = cur;
		}

		if (upper > prev) {
			res.add(getRange(prev + 1, upper));
		}

		return res;
	}

	private String getRange(int low, int high) {
		return (low == high) ? String.valueOf(low) : low + "->" + high;
	}
}
