package hack.leetcode.dev;

/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int indexZero = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				if (indexZero == -1) {
					indexZero = i;
				}
			} else {
				if (indexZero != -1 && indexZero < i) {
					nums[indexZero] = nums[i];
					nums[i] = 0;
					while (indexZero < i) {
						indexZero += 1;
						if (nums[indexZero] == 0) {
							break;
						}
					}
				}
			}
		}
		return;
	}

	public static void main(String[] args) {
		MoveZeroes test = new MoveZeroes();
		test.moveZeroes(new int[] { 0, 1, 0, 3, 12 });
	}
}
