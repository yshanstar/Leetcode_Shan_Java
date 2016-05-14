package solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the word list
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.
 */
public class WordLadder {
	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if (beginWord == null || endWord == null) {
			return 0;
		}

		Queue<String> queue = new LinkedList<String>();
		Queue<Integer> length = new LinkedList<Integer>();

		queue.offer(beginWord);
		length.add(1);

		while (!queue.isEmpty()) {
			String word = queue.poll();
			int len = length.poll();
			if (oneStep(word, endWord)) {
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
					if (wordList.contains(str)) {
						queue.add(str);
						length.add(len + 1);
						wordList.remove(str);
					}
				}
			}
		}
		return 0;
	}

	private static boolean oneStep(String s1, String s2) {
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

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("ab");
		System.out.println(ladderLength("a", "ab", dict));
	}
}
