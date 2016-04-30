package solution;

/*
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissPositive {
	public static int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 1;
		}

		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i + 1) {
				if (nums[i] <= 0 || nums[i] > nums.length) {
					break;
				}

				if (nums[i] == nums[nums[i] - 1]) {
					break;
				}

				int tmp = nums[i];
				nums[i] = nums[tmp - 1];
				nums[tmp - 1] = tmp;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}

		return nums.length + 1;
	}
	
	public static void main(String[] args){
		firstMissingPositive(new int[]{2,1});
	}
}
