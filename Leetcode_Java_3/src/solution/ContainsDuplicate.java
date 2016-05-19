package solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 */
public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return false;
		}

		Arrays.sort(nums);

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				return true;
			}
		}

		return false;
	}

	public boolean containsDuplicate2(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return false;
		}

		Set<Integer> numSet = new HashSet<Integer>();

		for (int num : nums) {
			if (!numSet.add(num)) {
				return true;
			}
		}

		return false;
	}
}
