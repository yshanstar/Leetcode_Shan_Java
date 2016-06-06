package hack.leetcode.dev;

import java.util.LinkedList;
import java.util.Queue;

/*
 *  Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region .
 * For example,

 X X X X
 X O O X
 X X O X
 X O X X

 * After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 */
public class SurroundedRegions2 {
	public void solve(char[][] board) {
		if (board == null || board.length <= 1) {
			return;
		}
		Queue<BoardPoint> pointsQueue = new LinkedList<BoardPoint>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if ((i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) && (board[i][j] == 'O')) {
					pointsQueue.add(new BoardPoint(i, j));
				}
			}
		}

		while (!pointsQueue.isEmpty()) {
			BoardPoint p = pointsQueue.poll();
			board[p.row][p.col] = '-';
			if (p.row > 0 && board[p.row - 1][p.col] == 'O') {
				pointsQueue.add(new BoardPoint(p.row - 1, p.col));
			}
			if (p.row < board.length - 1 && board[p.row + 1][p.col] == 'O') {
				pointsQueue.add(new BoardPoint(p.row + 1, p.col));
			}
			if (p.col > 0 && board[p.row][p.col - 1] == 'O') {
				pointsQueue.add(new BoardPoint(p.row, p.col - 1));
			}
			if (p.col < board[p.row].length - 1 && board[p.row][p.col + 1] == 'O') {
				pointsQueue.add(new BoardPoint(p.row, p.col + 1));
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != 'X') {
					if (board[i][j] == 'O') {
						board[i][j] = 'X';
					} else {
						board[i][j] = 'O';
					}
				}
			}
		}
	}

}

class BoardPoint {
	int row;
	int col;

	public BoardPoint(int row, int col) {
		this.row = row;
		this.col = col;
	}
}