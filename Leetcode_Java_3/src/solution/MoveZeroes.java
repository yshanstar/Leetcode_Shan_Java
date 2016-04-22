package solution;

/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int zeroidx = 0;
		int left = 0;

		while (left < nums.length) {
			if (nums[left] != 0) {
				int tmp = nums[zeroidx];
				nums[zeroidx++] = nums[left];
				nums[left] = tmp;
			}
			left++;
		}
	}

	public static void main(String[] args) {
		MoveZeroes test = new MoveZeroes();
		int[] nums = new int[] { 5, 0, 7, 3, 12 };
		test.moveZeroes(nums);
	}
}
