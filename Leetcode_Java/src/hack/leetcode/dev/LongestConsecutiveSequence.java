package hack.leetcode.dev;

import java.util.HashSet;

/*
 *  Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *	For example,
 *	Given [100, 4, 200, 1, 3, 2],
 *	The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *	Your algorithm should run in O(n) complexity. 
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num.length < 2)
			return num.length;
		HashSet<Integer> numbers = new HashSet<Integer>();
		for (int i : num) {
			numbers.add(i);
		}
		int maxOccr = 1;
		for (int i : num) {
			int left = i - 1;
			int right = i + 1;
			int occr = 1;
			while (numbers.contains(left)) {
				numbers.remove(left);
				left--;
				occr++;
			}
			while (numbers.contains(right)) {
				numbers.remove(right);
				right++;
				occr++;
			}
			maxOccr = Math.max(maxOccr, occr);
		}
		return maxOccr;
	}
}
