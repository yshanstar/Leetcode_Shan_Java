package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to num2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
			return new int[0];
		}

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int p1 = 0;
		int p2 = 0;
		List<Integer> tmp = new ArrayList<Integer>();

		while (p1 < nums1.length && p2 < nums2.length) {
			if (nums1[p1] == nums2[p2]) {
				tmp.add(nums1[p1]);
				p1++;
				p2++;
			} else if (nums1[p1] > nums2[p2]) {
				p2++;
			} else {
				p1++;
			}
		}

		int[] res = new int[tmp.size()];

		for (int i = 0; i < res.length; i++) {
			res[i] = tmp.get(i);
		}

		return res;
	}
}
