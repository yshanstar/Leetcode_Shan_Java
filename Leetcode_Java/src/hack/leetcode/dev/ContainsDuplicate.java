package hack.leetcode.dev;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		if(nums == null || nums.length <=1){
			return false;
		}
		Set<Integer> numSet = new HashSet<Integer>();
		for (int i : nums) {
			if(numSet.contains(i)){
				return true;
			}
			numSet.add(i);
		}
		return false;
	}
}
