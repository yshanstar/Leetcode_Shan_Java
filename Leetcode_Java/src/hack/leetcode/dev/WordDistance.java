package hack.leetcode.dev;

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
public class WordDistance {
	private Map<String, List<Integer>> wordMap;

	public WordDistance(String[] words) {
		wordMap = new HashMap<String, List<Integer>>();

		for (int i = 0; i < words.length; i++) {
			String tmp = words[i];
			if (wordMap.containsKey(tmp)) {
				wordMap.get(tmp).add(i);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				wordMap.put(tmp, list);
			}
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> word1Pos = wordMap.get(word1);
		List<Integer> word2Pos = wordMap.get(word2);

		int minDis = Integer.MAX_VALUE;
		for (int i = 0, j = 0; i < word1Pos.size() && j < word2Pos.size();) {
			int index1 = word1Pos.get(i), index2 = word2Pos.get(j);
			if (index1 < index2) {
				minDis = Math.min(minDis, index2 - index1);
				i++;
			} else {
				minDis = Math.min(minDis, index1 - index2);
				j++;
			}
		}

		return minDis;
	}
}
