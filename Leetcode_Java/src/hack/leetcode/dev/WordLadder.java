package hack.leetcode.dev;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,

 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 */
public class WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		Queue<String> queue = new LinkedList<String>();
		Queue<Integer> length = new LinkedList<Integer>();

		queue.add(start);
		length.add(1);

		while (!queue.isEmpty()) {
			String word = queue.poll();
			int len = length.poll();
			if (canChange(word, end)) {
				return len + 1;
			}
			for (int i = 0; i < word.length(); i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					if (word.charAt(i) == c) {
						continue;
					}
					char[] charArray = word.toCharArray();
					charArray[i] = c;
					String str = String.valueOf(charArray);
					if (dict.contains(str)) {
						queue.add(str);
						length.add(len + 1);
						dict.remove(str);
					}
				}
			}
		}
		return 0;
	}

	private boolean canChange(String s1, String s2) {
		int diff = 0;
		for (int i = 0; i < s1.length(); i++)
			if (s1.charAt(i) != s2.charAt(i)) {
				if (diff >= 1)
					return false;
				else
					diff++;
			}
		return true;
	}
}
