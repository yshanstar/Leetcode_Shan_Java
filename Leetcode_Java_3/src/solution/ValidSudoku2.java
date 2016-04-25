package solution;

import java.util.HashSet;

/*
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class ValidSudoku2 {
	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9) {
			return false;
		}

		if (!validateRows(board) || !validateCols(board)) {
			return false;
		}

		for (int i = 0; i <= board.length - 3; i += 3) {
			for (int j = 0; j <= board[0].length - 3; j += 3) {
				if (!validateSubMatrix(board, i, j)) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean validateRows(char[][] board) {
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
		return true;
	}

	private boolean validateCols(char[][] board) {
		HashSet<Character> hs;
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
		return true;
	}

	private boolean validateSubMatrix(char[][] board, int rowStart, int colStart) {
		HashSet<Character> hs;
		hs = new HashSet<Character>();
		for (int i = rowStart; i < rowStart + 3; i++) {
			for (int j = colStart; j < colStart + 3; j++) {
				if (board[j][i] != '.' && hs.contains(board[j][i])) {
					return false;
				}
				hs.add(board[j][i]);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidSudoku2 test = new ValidSudoku2();
		char[][] board = new char[][] { "......5..".toCharArray(), ".........".toCharArray(), ".........".toCharArray(), "93..2.4..".toCharArray(), "..7...3..".toCharArray(),
				".........".toCharArray(), "...34....".toCharArray(), ".....3...".toCharArray(), ".....52..".toCharArray() };
		test.isValidSudoku(board);
	}
}
