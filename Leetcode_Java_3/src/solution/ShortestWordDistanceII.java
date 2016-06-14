package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.
 */
public class ShortestWordDistanceII {
	private Map<String, List<Integer>> wordMap;

	public ShortestWordDistanceII(String[] words) {
		this.wordMap = new HashMap<String, List<Integer>>();

		for (int i = 0; i < words.length; i++) {
			String key = words[i];

			if (!this.wordMap.containsKey(key)) {
				this.wordMap.put(key, new ArrayList<Integer>());
			}

			List<Integer> pos = this.wordMap.get(key);
			pos.add(i);
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> pos1 = this.wordMap.get(word1);
		List<Integer> pos2 = this.wordMap.get(word2);

		int minDis = Integer.MAX_VALUE;
		for (int i = 0, j = 0; i < pos1.size() && j < pos2.size();) {
			int idx1 = pos1.get(i);
			int idx2 = pos2.get(j);

			if (idx1 < idx2) {
				minDis = Math.min(minDis, idx2 - idx1);
				i++;
			} else {
				minDis = Math.min(minDis, idx1 - idx2);
				j++;
			}
		}

		return minDis;
	}
}
