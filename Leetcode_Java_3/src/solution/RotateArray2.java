package solution;

/*
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II
 */
public class RotateArray2 {
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int length = nums.length;
		int step = k % length;
		swap(nums, 0, length - 1);
		swap(nums, 0, step - 1);
		swap(nums, step, length - 1);

	}

	private void swap(int[] nums, int start, int end) {
		while (start < end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}
}
