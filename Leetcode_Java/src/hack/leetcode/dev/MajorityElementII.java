package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
 * The algorithm should run in linear time and in O(1) space.
 */

public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return res;
		}

		if (nums.length < 3) {
			for (int i : nums) {
				if (!res.contains(i))
					res.add(i);
			}
			return res;
		}

		Map<Integer, Integer> values = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (values.size() < 2) {
				if (values.containsKey(nums[i])) {
					int count = values.get(nums[i]);
					values.put(nums[i], count + 1);
				} else {
					values.put(nums[i], 1);
				}
			} else {
				if (values.containsKey(nums[i])) {
					int count = values.get(nums[i]);
					values.put(nums[i], count + 1);
				} else {
					Map<Integer, Integer> newMap = new HashMap<Integer, Integer>(
							values);
					for (int key : newMap.keySet()) {
						if (values.get(key) == 1) {
							values.remove(key);
						} else {
							int count = values.get(key);
							values.put(key, count - 1);
						}
					}
				}
			}
		}

		for (int key : values.keySet()) {
			int ac = 0;
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] == key) {
					ac++;
				}
			}
			if(ac > (nums.length/3)){
				res.add(key);
			}
		}
		return res;
	}
}
