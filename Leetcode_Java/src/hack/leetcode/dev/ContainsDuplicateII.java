package hack.leetcode.dev;

import java.util.HashMap;

/*
 *	Given an array of integers and an integer k, find out whether there there are two distinct indices i and j in the array 
 *	such that nums[i] = nums[j] and the difference between i and j is at most k.
 * 
 */

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return false;
		}

		HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int tmp = nums[i];

			if (!numMap.containsKey(tmp)) {
				numMap.put(tmp, i);
			} else {
				int pos = numMap.get(tmp);
				if (i - pos <= k) {
					return true;
				} else {
					numMap.put(tmp, i);
				}
			}
		}

		return false;
	}
}
