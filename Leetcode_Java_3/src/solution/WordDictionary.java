package solution;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
	private TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	// Adds a word into the data structure.
	public void addWord(String word) {
		word = word.trim();

		Map<Character, TrieNode> children = root.children;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			TrieNode t = null;

			if (children.containsKey(c)) {
				t = children.get(c);
			} else {
				t = new TrieNode(c);
				children.put(c, t);
			}

			children = t.children;

			if (i == word.length() - 1) {
				t.isLeaf = true;
			}
		}
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return dfs(root.children, word, 0);
	}

	private boolean dfs(Map<Character, TrieNode> children, String word,
			int start) {
		if (start == word.length()) {
			if (children.size() == 0) {
				return true;
			} else {
				return false;
			}
		}

		char c = word.charAt(start);

		if (children.containsKey(c)) {
			if (start == word.length() - 1 && children.get(c).isLeaf) {
				return true;
			}

			return dfs(children.get(c).children, word, start + 1);
		} else if (c == '.') {
			boolean result = false;
			for (Map.Entry<Character, TrieNode> child : children.entrySet()) {
				if (start == word.length() - 1 && child.getValue().isLeaf) {
					return true;
				}

				if (dfs(child.getValue().children, word, start + 1)) {
					result = true;
				}
			}
			return result;
		} else {
			return false;
		}
	}
}

class TrieNode {
	public Character c;
	public boolean isLeaf;
	public Map<Character, TrieNode> children;

	public TrieNode(char c) {
		this.c = c;
		this.isLeaf = false;
		this.children = new HashMap<Character, TrieNode>();
	}

	public TrieNode() {
		this.isLeaf = false;
		this.children = new HashMap<Character, TrieNode>();
	}
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
