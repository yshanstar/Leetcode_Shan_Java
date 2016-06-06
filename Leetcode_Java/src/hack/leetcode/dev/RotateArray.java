package hack.leetcode.dev;

public class RotateArray {
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		rotate(nums, 0, nums.length - 1);
		rotate(nums, 0, k - 1);
		rotate(nums, k, nums.length - 1);
	}

	private void rotate(int[] nums, int start, int end) {
		while (start < end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}
}
