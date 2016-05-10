package solution;

/*
 * Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII {
	public int singleNumber2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] count = new int[32];
		int res = 0;
		for (int i = 0; i < count.length; i++) {
			for (int num : nums) {
				if ((num >> i & 1) > 0) {
					count[i]++;
				}
			}
			res |= ((count[i] % 3)) << i;
		}

		return res;
	}

	public int singleNumber(int[] A) {
		int[] count = new int[32];
		int res = 0;
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (((A[j] >> i) & 1) > 0) {
					count[i]++;
				}
			}
			res |= ((count[i] % 3)) << i;
		}
		return res;
	}
}
