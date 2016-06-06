package hack.leetcode.dev;

import java.util.ArrayList;

/*
 *	The n-queens puzzle is the problem of placing n queens on an n*n chessboard such that no two queens attack each other.
 *	Given an integer n, return all distinct solutions to the n-queens puzzle.
 *	Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *	For example,
 *	There exist two distinct solutions to the 4-queens puzzle:
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
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> res = new ArrayList<String[]>();
		helper(0, new int[n], res);
		return res;
	}

	private void helper(int cur, int[] row, ArrayList<String[]> res) {
		int n = row.length;
		if (cur == n) {
			res.add(generateSol(row));
		} else {
			for (int i = 0; i < n; i++) {
				boolean good = true;
				row[cur] = i;
				for (int j = 0; j < cur; j++) {
					if (row[cur] == row[j] || cur - row[cur] == j - row[j] || cur + row[cur] == j + row[j]) {
						good = false;
						break;
					}
				}
				if (good) {
					helper(cur + 1, row, res);
				}
			}
		}
	}

	private String[] generateSol(int[] row) {
		int n = row.length;
		String[] sol = new String[n];
		for (int i = 0; i < n; i++) {
			String line = "";
			for (int j = 0; j < n; j++) {
				if (j == row[i]) {
					line += "Q";
				} else {
					line += ".";
				}
			}
			sol[i] = line;
		}
		return sol;
	}
}
