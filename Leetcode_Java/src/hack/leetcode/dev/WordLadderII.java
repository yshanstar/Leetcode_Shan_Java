package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/*
 *  Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 *	Only one letter can be changed at a time
 *	Each intermediate word must exist in the dictionary
 *	For example,
 *	Given:
 *	start = "hit"
 *	end = "cog"
 *	dict = ["hot","dot","dog","lot","log"]
 *	Return
 *	[
 *	["hit","hot","dot","dog","cog"],
 *	["hit","hot","lot","log","cog"]
 *	]
 */
public class WordLadderII {
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		// Start typing your Java solution below
		// DO NOT write main() function

		HashMap<Integer, ArrayList<ArrayList<String>>> resultMap = new HashMap<Integer, ArrayList<ArrayList<String>>>();

		ArrayList<String> wordList = new ArrayList<String>();

		if (start.equals(end)) {
			return new ArrayList<ArrayList<String>>();
		}
		if (!dict.contains(start))
			dict.add(start);
		if (!dict.contains(end))
			dict.add(end);
		wordList.add(start);
		for (String word : getAllAdjacent(start, dict, wordList)) {
			checkedWord(word, end, wordList, dict, resultMap);
		}

		int min = Integer.MAX_VALUE;

		if (resultMap.isEmpty()) {
			return new ArrayList<ArrayList<String>>();
		}

		for (Integer i : resultMap.keySet()) {
			if (i < min)
				min = i;
		}
		return resultMap.get(min);
	}

	private void checkedWord(String word, String end, ArrayList<String> wordList, HashSet<String> dict,
			HashMap<Integer, ArrayList<ArrayList<String>>> resultMap) {
		ArrayList<String> newWordList = new ArrayList<String>(wordList);
		if (word.equals(end)) {
			newWordList.add(word);
			if (resultMap.containsKey(newWordList.size())) {
				ArrayList<ArrayList<String>> resultList = resultMap.get(newWordList.size());
				resultList.add(newWordList);
			} else {
				ArrayList<ArrayList<String>> resultList = new ArrayList<ArrayList<String>>();
				resultList.add(newWordList);
				resultMap.put(newWordList.size(), resultList);
			}
		} else {
			newWordList.add(word);
			for (String adjanct : getAllAdjacent(word, dict, newWordList)) {
				checkedWord(adjanct, end, newWordList, dict, resultMap);
			}
		}
	}

	private ArrayList<String> getAllAdjacent(String word, HashSet<String> dict, ArrayList<String> wordList) {
		ArrayList<String> res = new ArrayList<String>();
		Iterator<String> i = dict.iterator();
		while (i.hasNext()) {
			String tmp = i.next();
			if (calculateDiff(word, tmp) == 1 && !wordList.contains(tmp)) {
				res.add(tmp);
			}
		}
		return res;
	}

	private int calculateDiff(String target, String word) {
		if (target.length() != word.length()) {
			return -1;
		}
		char[] wordArray = word.toCharArray();
		char[] targetArray = target.toCharArray();
		int diff = 0;
		for (int i = 0; i < target.length(); i++) {
			if (wordArray[i] != targetArray[i]) {
				diff++;
			}
		}
		return diff;
	}

	public static void main(String[] args) {
		WordLadderII wordLadderII = new WordLadderII();
		HashSet<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		dict.add("c");
		wordLadderII.findLadders("a", "c", dict);
	}
}
