package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

 For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:
 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class SingleNumberIII {
	public int[] singleNumber(int[] nums) {

		// write your code here
		// the idea is that:
		// two numbers that appear onece must differ in certain
		// bit x. The XOR of all elements will represent
		// this difference, thus we can group original
		// input into two groups based on first bit that is 1.
		// Then do the XOR on each group is the single element.
		int len = nums.length;
		int [] res = new int[2];
		if (len == 0) {
			return new int[0];
		}

		int xor = 0;

		for (int i : nums) {
			xor ^= i;
		}

		int oneBit = 1;
		for (int i = 0; i < 32; i++) {
			oneBit = 1 << i;
			if ((xor & oneBit) != 0) {
				oneBit = i;
				break;
			}
		}

		int ones = 0;
		int zeros = 0;
		for (int i : nums) {
			if (((i >> oneBit) & 1) == 1) {
				ones ^= i;
			} else {
				zeros ^= i;
			}
		}

		res[0] = ones;
		res[1] = zeros;

		return res;
	}
}
