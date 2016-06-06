package hack.leetcode.dev;

/*
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory. 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 â†? 1,3,2
 * 3,2,1 â†? 1,2,3
 * 1,1,5 â†? 1,5,1
 */
public class NextPermutation {
	public void nextPermutation(int[] num) {
		if (num == null || num.length == 0) {
			return;
		}

		int targetIdx = num.length - 1;
		while (targetIdx > 0) {
			if (num[targetIdx - 1] < num[targetIdx]) {
				break;
			}
			targetIdx--;
		}

		if (targetIdx > 0) {
			targetIdx--;
			int rightIdx = num.length - 1;
			while (rightIdx >= 0 && num[rightIdx] <= num[targetIdx]) {
				rightIdx--;
			}

			int swap = num[rightIdx];
			num[rightIdx] = num[targetIdx];
			num[targetIdx] = swap;
			targetIdx++;
		}

		int end = num.length - 1;
		while (end > targetIdx) {
			int swap = num[end];
			num[end] = num[targetIdx];
			num[targetIdx] = swap;
			end--;
			targetIdx++;
		}
	}
}
