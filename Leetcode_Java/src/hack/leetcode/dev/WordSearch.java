package hack.leetcode.dev;

/*
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * For example,
 * Given board =
 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					board[i][j] = ' ';
					if (find(board, i, j, word.substring(1))) {
						return true;
					}
					board[i][j] = word.charAt(0);
				}
			}
		}
		return false;
	}

	private boolean find(char[][] borad, int i, int j, String subWord) {
		if (subWord.length() == 0) {
			return true;
		}
		int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		for (int m = 0; m < direction.length; m++) {
			int ii = i + direction[m][0];
			int jj = j + direction[m][1];
			if (ii >= 0 && ii < borad.length && jj >= 0 && jj < borad[i].length && borad[ii][jj] == subWord.charAt(0)) {
				borad[ii][jj] = ' ';
				if (subWord.length() == 1 || find(borad, ii, jj, subWord.substring(1))) {
					return true;
				}
				borad[ii][jj] = subWord.charAt(0);
			}
		}
		return false;
	}
}
