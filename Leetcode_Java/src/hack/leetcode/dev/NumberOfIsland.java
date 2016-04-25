package hack.leetcode.dev;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3
 */
public class NumberOfIsland {
	int[][] distance = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int count = 0;
		int m = grid.length;
		int n = grid[0].length;

		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					visited[i][j] = true;
					count++;

					Queue<Point> points = new LinkedList<Point>();
					points.offer(new Point(i, j));
					while (!points.isEmpty()) {
						Point p = points.poll();
						for (int[] dis : distance) {
							int ii = p.x + dis[0];
							int jj = p.y + dis[1];
							if (ii >= 0 && ii < m && jj >= 0 && jj < n && !visited[ii][jj] && grid[ii][jj] == '1') {
								visited[ii][jj] = true;
								points.offer(new Point(ii, jj));
							}
						}
					}
				}
			}
		}

		return count;
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
