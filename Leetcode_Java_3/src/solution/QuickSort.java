package solution;

import java.util.Arrays;

public class QuickSort {
	public static void quickSort(int[] nums) {
		quickSortHelper(nums, 0, nums.length - 1);
	}

	private static void quickSortHelper(int[] nums, int low, int high) {
		if (nums == null || nums.length == 0) {
			return;
		}
		if (low >= high) {
			return;
		}

		int mid = low + (high - low) / 2;
		int pivot = nums[mid];

		int i = low;
		int j = high;
		while (i <= j) {
			while (nums[i] < pivot) {
				i++;
			}

			while (nums[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				i++;
				j--;
			}
		}

		if (low < j) {
			quickSortHelper(nums, low, j);
		}

		if (high > i) {
			quickSortHelper(nums, i, high);
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 6, 9, 2, 1, 1, 5, 4 };
		quickSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
