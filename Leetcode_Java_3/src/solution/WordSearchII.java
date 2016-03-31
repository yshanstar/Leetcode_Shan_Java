package solution;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =

 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 Return ["eat","oath"].
 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 */
public class WordSearchII {
	int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	// build trie for for words
	class TrieNodeC {
		String word;
		TrieNodeC[] next;

		public TrieNodeC() {
			next = new TrieNodeC[26];
		}
	}

	public List<String> findWordsII(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();
		if (board == null || board.length == 0 || board[0].length == 0
				|| words == null || words.length == 0) {
			return res;
		}

		TrieNodeC root = buildTrie(words);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				helperDFS(board, i, j, res, root);
			}
		}

		return res;
	}

	private TrieNodeC buildTrie(String[] words) {
		TrieNodeC root = new TrieNodeC();

		for (String word : words) {
			TrieNodeC p = root;
			for (char c : word.toCharArray()) {
				int idx = c - 'a';
				if (p.next[idx] == null) {
					p.next[idx] = new TrieNodeC();
				}
				p = p.next[idx];
			}
			p.word = word;
		}

		return root;
	}

	private void helperDFS(char[][] board, int i, int j, List<String> res,
			TrieNodeC node) {
		char c = board[i][j];

		if (c == '-' || node.next[c - 'a'] == null) {
			return;
		}

		node = node.next[c - 'a'];

		if (node.word != null) {
			res.add(node.word);
			node.word = null;
		}

		board[i][j] = '-';
		for (int[] dir : direction) {
			int ii = i + dir[0];
			int jj = j + dir[1];

			if (ii < 0 || ii >= board.length || jj < 0 || jj >= board[0].length
					|| board[ii][jj] == '-') {
				continue;
			}
			
			helperDFS(board, ii, jj, res, node);
		}

		board[i][j] = c;
	}

	// Use search word solution to go through all words
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();

		if (board == null || board.length == 0 || board[0].length == 0) {
			return res;
		}

		if (words == null || words.length == 0) {
			return res;
		}

		for (String word : words) {
			if (exist(board, word)) {
				res.add(word);
			}
		}

		return res;
	}

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}

		if (word == null || word.length() == 0) {
			return true;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					board[i][j] = '-';
					if (helper(board, word.substring(1), i, j)) {
						board[i][j] = word.charAt(0);
						return true;
					}
					board[i][j] = word.charAt(0);
				}
			}
		}

		return false;
	}

	private boolean helper(char[][] board, String subWord, int i, int j) {
		if (subWord.length() == 0) {
			return true;
		}

		for (int[] dir : direction) {
			int ii = i + dir[0];
			int jj = j + dir[1];

			if (ii < 0 || ii >= board.length || jj < 0 || jj >= board[0].length
					|| board[ii][jj] != subWord.charAt(0)) {
				continue;
			}

			board[ii][jj] = '-';
			if (helper(board, subWord.substring(1), ii, jj)) {
				board[ii][jj] = subWord.charAt(0);
				return true;
			}

			board[ii][jj] = subWord.charAt(0);
		}

		return false;
	}
}
