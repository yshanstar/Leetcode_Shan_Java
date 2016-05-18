package solution;

import java.util.HashSet;
import java.util.Set;

/*
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
 */
public class IntersectionofTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
			return new int[0];
		}
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> res = new HashSet<Integer>();

		for (int num : nums1) {
			set1.add(num);
		}

		for (int num : nums2) {
			if (set1.contains(num)) {
				res.add(num);
			}
		}

		int i = 0;
		int[] ans = new int[res.size()];
		for (int num : res) {
			ans[i++] = num;
		}
		return ans;
	}
}
