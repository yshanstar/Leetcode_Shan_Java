package solution;


/*
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Try to solve it in linear time/space.

 Return 0 if the array contains less than 2 elements.

 You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class MaximumGap {
	public int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		int minValue = Integer.MAX_VALUE;
		int maxValue = Integer.MIN_VALUE;

		for (int num : nums) {
			minValue = Math.min(num, minValue);
			maxValue = Math.max(num, maxValue);
		}

		int gap = (int) Math.ceil((double) (maxValue - minValue) / (nums.length - 1));

		Pair[] pairs = new Pair[nums.length - 1];
		for (int i = 0; i < pairs.length; i++) {
			pairs[i] = new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
		}

		for (int num : nums) {
			if (num == minValue || num == maxValue) {
				continue;
			}
			int idx = (num - minValue) / gap;
			pairs[idx].min = Math.min(pairs[idx].min, num);
			pairs[idx].max = Math.max(pairs[idx].max, num);
		}

		int maxGap = 0;
		int previous = minValue;

		for (Pair p : pairs) {
			if (p.min == Integer.MAX_VALUE && p.max == Integer.MIN_VALUE) {
				continue;
			}
			maxGap = Math.max(maxGap, p.min - previous);
			previous = p.max;
		}

		maxGap = Math.max(maxGap, maxValue - previous);
		return maxGap;
	}

	class Pair {
		int min;
		int max;

		public Pair(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 15252, 16764, 27963, 7817, 26155, 20757, 3478, 22602, 20404, 6739, 16790, 10588, 16521, 6644, 20880, 15632, 27078, 25463, 20124, 15728, 30042, 16604, 17223, 4388,
				23646, 32683, 23688, 12439, 30630, 3895, 7926, 22101, 32406, 21540, 31799, 3768, 26679, 21799, 23740 };

		MaximumGap test = new MaximumGap();
		test.maximumGap(nums);

	}
}
