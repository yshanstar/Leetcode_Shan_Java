package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the word list
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]
 Return
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 */
public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> res = new ArrayList<List<String>>();

		if (beginWord.equals(endWord)) {
			return res;
		}

		wordList.add(beginWord);
		wordList.add(endWord);

		Map<String, Set<String>> neighbours = new HashMap<String, Set<String>>();

		for (String str : wordList) {
			getNeighbor(neighbours, str, wordList);
		}

		// BFS search queue
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(null, beginWord, 1));

		// BFS level
		int previousLevel = 0;

		// mark which nodes have been visited, to break infinite loop
		Map<String, Integer> visited = new HashMap<String, Integer>();

		while (!queue.isEmpty()) {
			Node n = queue.poll();
			if (endWord.equals(n.str)) {
				if (previousLevel == 0 || previousLevel == n.level) {
					previousLevel = n.level;
					findPath(n, res);
				} else {
					break;
				}
			} else {
				Set<String> set = neighbours.get(n.str);

				if (set == null || set.isEmpty()) {
					continue;
				}

				ArrayList<String> toRemove = new ArrayList<String>();
				for (String s : set) {

					// if s has been visited before at a smaller level, there is
					// already a shorter
					// path from start to s thus we should ignore s so as to
					// break infinite loop; if
					// on the same level, we still need to put it into queue.
					if (visited.containsKey(s)) {
						Integer occurLevel = visited.get(s);
						if (n.level + 1 > occurLevel) {
							neighbours.get(s).remove(n.str);
							toRemove.add(s);
							continue;
						}
					}
					visited.put(s, n.level + 1);
					queue.add(new Node(n, s, n.level + 1));
					if (neighbours.containsKey(s))
						neighbours.get(s).remove(n.str);
				}
				for (String s : toRemove) {
					set.remove(s);
				}

			}
		}

		return res;
	}

	public void findPath(Node n, List<List<String>> result) {
		List<String> path = new ArrayList<String>();
		Node p = n;
		while (p != null) {
			path.add(0, p.str);
			p = p.parent;
		}
		result.add(path);
	}

	private void getNeighbor(Map<String, Set<String>> neighbours, String str, Set<String> wordList) {
		int length = str.length();
		char[] chars = str.toCharArray();

		for (int i = 0; i < length; i++) {
			char old = chars[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == old) {
					continue;
				}

				chars[i] = c;
				String newstr = new String(chars);
				if (wordList.contains(newstr)) {
					if (!neighbours.containsKey(str)) {
						neighbours.put(str, new HashSet<String>());
					}

					neighbours.get(str).add(newstr);
				}

			}
			chars[i] = old;
		}
	}

	class Node {
		public Node parent;
		public String str;
		public int level;

		public Node(Node p, String s, int l) {
			parent = p;
			str = s;
			level = l;
		}
	}
}
