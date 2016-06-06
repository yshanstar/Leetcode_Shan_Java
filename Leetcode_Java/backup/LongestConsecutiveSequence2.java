package hack.leetcode.dev;

import java.util.HashSet;

/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence2 {
	public int longestConsecutive(int[] num) {
		if (num == null) {
			return 0;
		}
		if (num.length < 2) {
			return num.length;
		}

		HashSet<Integer> numbers = new HashSet<Integer>();
		for (int i : num) {
			numbers.add(i);
		}

		int maxCons = 1;
		for (int i : num) {
			int left = i - 1;
			int right = i + 1;
			int cons = 1;
			while (numbers.contains(left)) {
				numbers.remove(left);
				left--;
				cons++;
			}
			while (numbers.contains(right)) {
				numbers.remove(right);
				right++;
				cons++;
			}
			maxCons = Math.max(maxCons, cons);
		}

		return maxCons;
	}
}
