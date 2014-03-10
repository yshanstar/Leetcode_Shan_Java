package hack.leetcode.dev;

import java.util.HashSet;

/*
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		HashSet<Character> hs;

		// Check each row
		for (int i = 0; i < board.length; i++) {
			hs = new HashSet<Character>();
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != '.' && hs.contains(board[i][j])) {
					return false;
				} 
				hs.add(board[i][j]);
			}
		}

		// Check each col
		for (int i = 0; i < board.length; i++) {
			hs = new HashSet<Character>();
			for (int j = 0; j < board[i].length; j++) {
				if (board[j][i] != '.' && hs.contains(board[j][i])) {
					return false;
				}
				hs.add(board[j][i]);
			}
		}

		// Check the subMatrix
		int col_offset;
		int row_offset;
		for (int k = 0; k < board.length; k++) {
			col_offset = 3 * (k / 3);
			row_offset = (3 * k) % 9;

			hs = new HashSet<Character>();
			for (int i = row_offset; i < row_offset + 3; i++) {
				for (int j = col_offset; j < col_offset + 3; j++) {
					if (board[i][j] != '.' && hs.contains(board[i][j])) {
						return false;
					} 
					hs.add(board[i][j]);
				}
			}

		}
		return true;
	}
}
