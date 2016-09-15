package hack.leetcode.dev;

import java.util.Random;

/*
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);
 */
public class RandomPickIndex {
	private int[] nums;
	private Random rand;

	public RandomPickIndex(int[] nums) {
		this.nums = nums;
		this.rand = new Random();
	}

	public int pick(int target) {
		int total = 0;
		int res = -1;

		for (int i = 0; i < this.nums.length; i++) {
			if (this.nums[i] == target) {
				int x = this.rand.nextInt(++total);
				res = (x == 0 ? i : res);
			}
		}

		return res;
	}
}
