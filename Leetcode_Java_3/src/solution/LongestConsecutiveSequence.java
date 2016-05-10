package solution;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();

		for (int i : nums) {
			set.add(i);
		}

		int max = 0;

		for (int num : nums) {
			int left = num - 1;
			int right = num + 1;
			int count = 1;

			while (set.contains(left)) {
				set.remove(left--);
				count++;
			}

			while (set.contains(right)) {
				set.remove(right++);
				count++;
			}

			max = Math.max(max, count);
		}

		return max;
	}

	public int longestConsecutive2(int[] num) {
		HashSet<Integer> numbers = new HashSet<Integer>();
		for (int i : num) {
			numbers.add(i);
		}

		int maxLegth = 0;

		for (int i : num) {
			int left = i - 1;
			int right = i + 1;
			int count = 1;
			while (numbers.contains(left)) {
				numbers.remove(left--);
				count++;
			}
			while (numbers.contains(right)) {
				numbers.remove(right++);
				count++;
			}
			maxLegth = Math.max(maxLegth, count);
		}

		return maxLegth;
	}
}
