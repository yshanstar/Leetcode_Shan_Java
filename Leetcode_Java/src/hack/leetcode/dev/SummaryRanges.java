package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		if (nums == null || nums.length == 0) {
			return res;
		}

		Range range = new Range(nums[0], nums[0]);

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - 1 == nums[i - 1]) {
				range.end = nums[i];
			} else {
				res.add(ToString(range));
				range = new Range(nums[i], nums[i]);
			}
		}

		res.add(ToString(range));

		return res;
	}

	private String ToString(Range r) {
		StringBuilder sb = new StringBuilder();
		if (r == null) {
			return "";
		}

		if (r.start == r.end) {
			return String.valueOf(r.start);
		}

		return sb.append(r.start).append("->").append(r.end).toString();
	}

	class Range {
		int start;
		int end;

		public Range(int s, int e) {
			this.start = s;
			this.end = e;
		}
	}
}
