package solution;

import java.util.Arrays;
import java.util.Stack;

/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

 Empty cells are indicated by the character '.'.

 You may assume that there will be only one unique solution.
 */
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		Stack<Point> emptyPoints = new Stack<Point>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					emptyPoints.push(new Point(i, j));
				}
			}
		}

		solve(board, emptyPoints);
	}

	private boolean solve(char[][] board, Stack<Point> emptyPoints) {
		if (emptyPoints.isEmpty()) {
			return true;
		}

		Point p = emptyPoints.peek();
		for (int value = 1; value <= 9; value++) {
			char newValue = (char) (value + '0');
			if (isValid(board, p.x, p.y, newValue)) {
				board[p.x][p.y] = newValue;
				emptyPoints.pop();
				if (solve(board, emptyPoints)) {
					return true;
				}
				board[p.x][p.y] = '.';
				emptyPoints.push(p);
			}
		}

		return false;
	}

	private boolean isValid(char[][] board, int row, int col, char newValue) {
		for (int idx = 0; idx < 9; idx++) {
			if (board[idx][col] == newValue) {
				return false;
			}

			if (board[row][idx] == newValue) {
				return false;
			}
		}

		int startRow = (row / 3) * 3;
		int startCol = (col / 3) * 3;
		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startCol; j < startCol + 3; j++) {
				if (board[i][j] == newValue) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		SudokuSolver test = new SudokuSolver();

		char[][] board = new char[][] { "..9748...".toCharArray(), "7........".toCharArray(), ".2.1.9...".toCharArray(), "..7...24.".toCharArray(), ".64.1.59.".toCharArray(),
				".98...3..".toCharArray(), "...8.3.2.".toCharArray(), "........6".toCharArray(), "...2759..".toCharArray() };

		test.solveSudoku(board);
		for (char[] row : board) {
			System.out.println(Arrays.toString(row));
		}
	}

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
