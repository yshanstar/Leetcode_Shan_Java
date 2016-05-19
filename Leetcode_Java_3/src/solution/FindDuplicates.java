package solution;

/*
 * Find duplicates in O(n) time and O(1) extra space
 Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times. Find these repeating numbers in O(n) and using only constant memory space.

 For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.

 This problem is an extended version of following problem.
 */
public class FindDuplicates {
	public static void findDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[Math.abs(nums[i])] >= 0) {
				nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
			} else {
				System.out.println(Math.abs(nums[i]));
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 2, 3, 1, 5, 6, 4 };
		findDuplicate(nums);
	}
}
