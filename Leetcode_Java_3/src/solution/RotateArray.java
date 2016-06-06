package solution;

public class RotateArray {
	public void rotate(int[] nums, int k) {
		int length = nums.length;
		k = k % length;

		if (k == 0) {
			return;
		}

		swap(nums, 0, length - 1);
		swap(nums, 0, k - 1);
		swap(nums, k, length - 1);
	}

	private void swap(int[] nums, int left, int right) {
		while (left < right) {
			int tmp = nums[left];
			nums[left] = nums[right];
			nums[right] = tmp;
			left++;
			right--;
		}
	}
}
