package hack.leetcode.dev;


/*
 *  Given a 2D board and a word, find if the word exists in the grid.
 *	The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. 
 *	The same letter cell may not be used more than once.
 *
 *	For example,
 *	Given board =
 *
 *	[
 *	["ABCE"],
 *	["SFCS"],
 *	["ADEE"]
 *	]
 *
 *	word = "ABCCED", -> returns true,
 *	word = "SEE", -> returns true,
 *	word = "ABCB", -> returns false.
 */
public class WorldSearch {
	public boolean exist(char[][] board, String word) {
		if (word.length() == 0) {
			return true;
		} else if (word.length() > 0 && board.length == 0) {
			return false;
		}

		if (word.length() == 1) {
			return inBoard(board, word.charAt(0));
		}

		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (DFS(board, i, j, word, 0, visited)) {
					return true;
				}
			}
		}
		return false;

	}

	private boolean DFS(char[][] board, int i, int j, String word, int idx, boolean[][] visited) {
		if (visited[i][j] || board[i][j] != word.charAt(idx)) {
			return false;
		}
		if (idx == word.length() - 1) {
			return true;
		}

		visited[i][j] = true;
		if (i != 0 && DFS(board, i - 1, j, word, idx + 1, visited)) {
			return true;
		}
		if (i != board.length - 1 && DFS(board, i + 1, j, word, idx + 1, visited)) {
			return true;
		}
		if (j != 0 && DFS(board, i, j - 1, word, idx + 1, visited)) {
			return true;
		}
		if (j != board[i].length - 1 && DFS(board, i, j + 1, word, idx + 1, visited)) {
			return true;
		}
		visited[i][j] = false;
		return false;
	}

	private boolean inBoard(char[][] board, char a) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == a) {
					return true;
				}
			}
		}
		return false;
	}
}
