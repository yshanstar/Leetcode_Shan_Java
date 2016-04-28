package hack.leetcode.dev;

import java.util.Arrays;

/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 */
public class MoveZeroe {
	public void moveZeroes(int[] nums) {
		int idx = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				int tmp = nums[idx];
				nums[idx++] = nums[i];
				nums[i] = tmp;
			}
		}
	}

	public void moveZeroesToBegining(int[] nums) {
		int idx = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] != 0) {
				nums[idx--] = nums[i];
			}
		}
		while (idx >= 0) {
			nums[idx--] = 0;
		}
	}

	public static void main(String[] args) {
		MoveZeroe test = new MoveZeroe();

		int[] nums = new int[] { 3, 0, 1, 2, 6, 0, 5, 0 };
		int[] nums2 = new int[] { 3, 0, 1, 2, 0, 0, 5, 0, 9, 1 };

		test.moveZeroes(nums);
		test.moveZeroesToBegining(nums2);

		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(nums2));
	}
}
