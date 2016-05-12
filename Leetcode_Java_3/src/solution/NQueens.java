package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (n <= 0) {
			res.add(new ArrayList<String>());
			return res;
		}

		int[] colUsed = new int[n];
		Arrays.fill(colUsed, -1);
		dfs(res, colUsed, 0);
		return res;
	}

	private void dfs(List<List<String>> res, int[] colUsed, int rowIdx) {
		int n = colUsed.length;
		if (rowIdx == n) {
			res.add(generate(colUsed));
			return;
		}

		for (int col = 0; col < colUsed.length; col++) {
			if (isValid(colUsed, rowIdx, col)) {
				colUsed[rowIdx] = col;
				dfs(res, colUsed, rowIdx + 1);
			}
		}
	}

	private boolean isValid(int[] colUsed, int row, int col) {
		for (int i = 0; i < row; i++) {
			// Excludes used columns and diagonal positions
			// (x2-x1)/(y2-y1) == 1 or -1
			if (colUsed[i] == col || row - i == Math.abs(col - colUsed[i])) {
				return false;
			}
		}

		return true;
	}

	private List<String> generate(int[] colUsed) {
		List<String> res = new ArrayList<String>();
		for (int i : colUsed) {
			char[] line = new char[colUsed.length];
			Arrays.fill(line, '.');
			line[i] = 'Q';
			res.add(String.valueOf(line));
		}
		return res;
	}
}
