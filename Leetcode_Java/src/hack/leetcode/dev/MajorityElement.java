package hack.leetcode.dev;

/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */

public class MajorityElement {
	public int majorityElement(int[] num) {
		if (num == null || num.length == 0) {
			return Integer.MIN_VALUE;
		}

		int res = Integer.MIN_VALUE;
		int count = 0;

		for (int i = 0; i < num.length; i++) {
			if (count == 0) {
				res = num[i];
				count = 1;
			} else {
				if (num[i] == res) {
					count++;
				} else {
					count--;
				}
			}
		}

		return res;
	}
}
