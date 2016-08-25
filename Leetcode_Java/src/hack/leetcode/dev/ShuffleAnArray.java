package hack.leetcode.dev;

import java.util.Random;

/*
 * Shuffle a set of numbers without duplicates.

 Example:

 // Init an array with set 1, 2, and 3.
 int[] nums = {1,2,3};
 Solution solution = new Solution(nums);

 // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 solution.shuffle();

 // Resets the array back to its original configuration [1,2,3].
 solution.reset();

 // Returns the random shuffling of array [1,2,3].
 solution.shuffle();
 */
public class ShuffleAnArray {
	int[] nums;
	int[] initNums;

	public ShuffleAnArray(int[] nums) {
		this.nums = nums;
		this.initNums = this.nums.clone();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return this.initNums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		Random r = new Random();
		int length = this.nums.length;

		while (length > 0) {
			int idx = r.nextInt(length);
			int tmp = this.nums[idx];
			this.nums[idx] = this.nums[length - 1];
			this.nums[length - 1] = tmp;
			length--;
		}

		return this.nums;
	}
}
