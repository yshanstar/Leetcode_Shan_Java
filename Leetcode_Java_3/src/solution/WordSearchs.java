package solution;

/*
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class WordSearchs {
	int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

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
