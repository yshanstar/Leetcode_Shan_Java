package solution;

import java.util.Arrays;

/*
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

 Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

 Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 Any live cell with two or three live neighbors lives on to the next generation.
 Any live cell with more than three live neighbors dies, as if by over-population..
 Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 Write a function to compute the next state (after one update) of the board given its current state.

 Follow up: 
 Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */
public class GameOfLife {
	public void gameOfLife2(boolean[][] board) {
		if (board == null || board.length == 0) {
			return;
		}

		int m = board.length;
		int n = board[0].length;

		boolean[][] copy = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			copy[i] = board[i].clone();
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				boolean cur = board[i][j];
				int neighbor = countNeighbor(board, i, j);

				if (cur && neighbor < 2) {
					copy[i][j] = false;
				} else if (cur && neighbor > 3) {
					copy[i][j] = true;
				} else if (!cur && neighbor == 3) {
					copy[i][j] = true;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			board[i] = copy[i].clone();
		}
	}

	private int countNeighbor(boolean[][] board, int i, int j) {
		int liveNeighbor = count(board, i - 1, j) + count(board, i + 1, j) + count(board, i - 1, j - 1) + count(board, i - 1, j + 1) + count(board, i, j - 1) + count(board, i, j + 1)
				+ count(board, i + 1, j - 1) + count(board, i + 1, j + 1);
		return liveNeighbor;
	}

	private int count(boolean[][] board, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return 0;
		}

		boolean cur = board[i][j];

		return (cur) ? 1 : 0;
	}

	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0) {
			return;
		}

		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int cur = board[i][j];
				int count = countLiveNeighbor(board, i, j);

				if (cur == 1 && count < 2) {
					board[i][j] = -1;
				} else if (cur == 1 && count > 3) {
					board[i][j] = -1;
				} else if (cur == 0 && count == 3) {
					board[i][j] = -2;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int cur = board[i][j];
				if (cur == -1) {
					board[i][j] = 0;
				} else if (cur == -2) {
					board[i][j] = 1;
				}
			}
		}
	}

	private int countLiveNeighbor(int[][] board, int i, int j) {
		int liveNeighbor = count(board, i - 1, j) + count(board, i + 1, j) + count(board, i - 1, j - 1) + count(board, i - 1, j + 1) + count(board, i, j - 1) + count(board, i, j + 1)
				+ count(board, i + 1, j - 1) + count(board, i + 1, j + 1);
		return liveNeighbor;
	}

	private int count(int[][] board, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return 0;
		}

		int cur = board[i][j];

		if (cur == -1) {
			return 1;
		} else if (cur == -2) {
			return 0;
		} else {
			return cur;
		}
	}

	public static void main(String[] args) {
		GameOfLife test = new GameOfLife();
		int[][] board = new int[][] { { 0 } };
		test.gameOfLife(board);

		boolean[][] board2 = new boolean[][] { { false, true, false }, { false, true, false }, { false, true, false } };
		int i = 0;
		while (i < 3) {
			test.gameOfLife2(board2);
			for (boolean[] row : board2) {
				System.out.println(Arrays.toString(row));
			}
			i++;
			System.out.println("end");
		}

	}
}
