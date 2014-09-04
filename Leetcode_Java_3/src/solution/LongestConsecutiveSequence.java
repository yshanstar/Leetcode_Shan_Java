package solution;

import java.util.HashSet;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
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
