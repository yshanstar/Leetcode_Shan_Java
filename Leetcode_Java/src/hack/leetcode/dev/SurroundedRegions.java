package hack.leetcode.dev;

import java.util.ArrayList;

/*
 *  Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region .

 For example,

 X X X X
 X O O X
 X X O X
 X O X X

 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X

 */
public class SurroundedRegions {
	public void solve(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<TargetNode> nodeList = new ArrayList<TargetNode>();
		if (board.length == 0) {
			return;
		} else if (board[0].length == 1) {
			return;
		} else {
			int[][] flag = new int[board.length][board[0].length];
			for (int rowIdx = 0; rowIdx < board.length; rowIdx++) {
				for (int colIdx = 0; colIdx < board[rowIdx].length; colIdx++) {
					if (board[rowIdx][colIdx] == 'X') {
						continue;
					} else {
						if (!(rowIdx == 0 || (rowIdx == board.length - 1) || colIdx == 0 || (colIdx == board[0].length - 1))) {
							nodeList.add(new TargetNode(rowIdx, colIdx));
						}
						if (isConnected(rowIdx, colIdx, board)) {
							flag[rowIdx][colIdx] = 0;
						} else {
							flag[rowIdx][colIdx] = 1;
						}
					}
				}
			}
			for (int i = 0; i < nodeList.size(); i++) {
				if ((flag[(nodeList.get(i).row - 1 >= 0) ? (nodeList.get(i).row - 1) : 0][nodeList.get(i).col] == 0)
						&& (flag[(nodeList.get(i).row + 1 < board.length) ? (nodeList.get(i).row + 1) : board.length - 1][nodeList.get(i).col] == 0)
						&& (flag[nodeList.get(i).row][(nodeList.get(i).col - 1 >= 0) ? (nodeList.get(i).col - 1) : 0] == 0)
						&& (flag[nodeList.get(i).row][(nodeList.get(i).col + 1 < board[0].length) ? (nodeList.get(i).col + 1) : board[0].length - 1] == 0)) {
					board[nodeList.get(i).row][nodeList.get(i).col] = 'X';
				}
			}
		}
	}

	private boolean isConnected(int rowIdx, int colIdx, char[][] board) {
		return !(toTop(rowIdx, colIdx, board) || toLeft(rowIdx, colIdx, board) || goBottom(rowIdx, colIdx, board) || goRight(rowIdx, colIdx, board));
	}

	private boolean toTop(int rowIdx, int colIdx, char[][] board) {
		if (rowIdx == 0) {
			return true;
		}
		int targetRow;
		for (targetRow = 0; targetRow < rowIdx; targetRow++) {
			if (board[targetRow][colIdx] == 'X') {
				return false;
			}
		}
		return true;
	}

	private boolean toLeft(int rowIdx, int colIdx, char[][] board) {
		if (colIdx == 0) {
			return true;
		}
		int targetCol;
		for (targetCol = 0; targetCol < colIdx; targetCol++) {
			if (board[rowIdx][targetCol] == 'X') {
				return false;
			}
		}
		return true;
	}

	private boolean goBottom(int rowIdx, int colIdx, char[][] board) {
		if (rowIdx == board.length - 1) {
			return true;
		}
		int targetRow;
		for (targetRow = board.length - 1; targetRow > rowIdx; targetRow--) {
			if (board[targetRow][colIdx] == 'X') {
				return false;
			}
		}
		return true;
	}

	private boolean goRight(int rowIdx, int colIdx, char[][] board) {
		if (colIdx == board[0].length - 1) {
			return true;
		}
		int targetCol;
		for (targetCol = board[0].length - 1; targetCol > colIdx; targetCol--) {
			if (board[rowIdx][targetCol] == 'X') {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		SurroundedRegions surroundedRegions = new SurroundedRegions();
		char[][] a = new char[][] { "OXXOX".toCharArray(), "XOOXO".toCharArray(), "XOXOX".toCharArray(), "OXOOO".toCharArray(), "XXOXO".toCharArray() };
		surroundedRegions.solve(a);

	}
}

class TargetNode {
	int row;
	int col;

	public TargetNode(int row, int col) {
		this.row = row;
		this.col = col;
	}
}