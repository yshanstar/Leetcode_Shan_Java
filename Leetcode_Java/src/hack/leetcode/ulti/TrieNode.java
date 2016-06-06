package hack.leetcode.ulti;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	public char c;
	public Map<Character, TrieNode> children;
	public boolean isLeaf;

	public TrieNode() {
		this.isLeaf = false;
		this.children = new HashMap<Character, TrieNode>();
	}

	public TrieNode(char c) {
		this.c = c;
		this.isLeaf = false;
		this.children = new HashMap<Character, TrieNode>();
	}
}
