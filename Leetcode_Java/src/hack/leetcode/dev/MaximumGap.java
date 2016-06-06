package hack.leetcode.dev;

import java.util.Arrays;

/*
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Try to solve it in linear time/space.

 Return 0 if the array contains less than 2 elements.

 You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class MaximumGap {
	public int maximumGap(int[] num) {
		if (num == null || num.length < 2) {
			return 0;
		}

		int min = num[0];
		int max = num[0];

		for (int i : num) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}

		int gap = (int) Math.ceil((double) (max - min) / (num.length - 1));

		int[] bucketMin = new int[num.length - 1];
		int[] bucketMax = new int[num.length - 1];

		Arrays.fill(bucketMin, Integer.MAX_VALUE);
		Arrays.fill(bucketMax, Integer.MIN_VALUE);

		for (int i : num) {
			if (i == min || i == max) {
				continue;
			}
			int idx = (i - min) / gap;
			bucketMax[idx] = Math.max(bucketMax[idx], i);
			bucketMin[idx] = Math.min(bucketMin[idx], i);
		}

		// scan the buckets for the max gap
		int maxGap = Integer.MIN_VALUE;
		int previous = min;

		for (int i = 0; i < num.length - 1; i++) {
			if (bucketMax[i] == Integer.MIN_VALUE
					&& bucketMin[i] == Integer.MAX_VALUE) {
				continue;
			}

			maxGap = Math.max(maxGap, bucketMin[i] - previous);
			previous = bucketMax[i];
		}
		
		maxGap = Math.max(maxGap, max - previous); 
        return maxGap;
	}
}
