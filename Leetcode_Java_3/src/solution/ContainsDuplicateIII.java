package solution;

import java.util.SortedSet;
import java.util.TreeSet;

/*
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 */
public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length < 0 || t < 0 || k < 1) {
			return false;
		}

		SortedSet<Long> numSet = new TreeSet<Long>();
		for (int i = 0; i < nums.length; i++) {
			SortedSet<Long> subSet = numSet.subSet((long) nums[i] - t,
					(long) nums[i] + t + 1);

			if (!subSet.isEmpty()) {
				return true;
			}

			if (i >= k) {
				numSet.remove((long) nums[i - k]);
			}

			numSet.add((long) nums[i]);
		}

		return false;
	}
}
