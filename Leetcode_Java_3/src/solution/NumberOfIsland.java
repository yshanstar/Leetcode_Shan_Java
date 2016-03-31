package solution;

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

	public int numIslandsBFS(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;
		int count = 0;
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && grid[i][j] == '1') {
					visited[i][j] = true;
					count++;

					Queue<GridPoint> points = new LinkedList<GridPoint>();
					points.offer(new GridPoint(i, j));

					while (!points.isEmpty()) {
						GridPoint tmp = points.poll();
						// Check y+1
						if (tmp.y + 1 < n && !visited[tmp.x][tmp.y + 1]) {
							if (grid[tmp.x][tmp.y + 1] == '1') {
								visited[tmp.x][tmp.y + 1] = true;
								points.offer(new GridPoint(tmp.x, tmp.y + 1));
							}
						}

						// Check y-1
						if (tmp.y - 1 >= 0 && !visited[tmp.x][tmp.y - 1]) {
							if (grid[tmp.x][tmp.y - 1] == '1') {
								visited[tmp.x][tmp.y - 1] = true;
								points.offer(new GridPoint(tmp.x, tmp.y - 1));
							}
						}

						// Check x+1
						if (tmp.x + 1 < m && !visited[tmp.x + 1][tmp.y]) {
							if (grid[tmp.x + 1][tmp.y] == '1') {
								visited[tmp.x + 1][tmp.y] = true;
								points.offer(new GridPoint(tmp.x + 1, tmp.y));
							}
						}

						// Check x-1
						if (tmp.x - 1 >= 0 && !visited[tmp.x - 1][tmp.y]) {
							if (grid[tmp.x - 1][tmp.y] == '1') {
								visited[tmp.x - 1][tmp.y] = true;
								points.offer(new GridPoint(tmp.x - 1, tmp.y));
							}
						}
					}
				}
			}
		}
		return count;
	}

	class GridPoint {
		int x;
		int y;

		public GridPoint(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int numIslandsUnionFind(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;

		UnionFind uf = new UnionFind(grid);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					for (int[] dir : distance) {
						int x = i + dir[0];
						int y = j + dir[1];
						if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
							int id1 = i * n + j;
							int id2 = x * n + y;
							uf.union(id1, id2);
						}
					}
				}
			}
		}

		return uf.count;
	}

	class UnionFind {
		int[] father;
		int m;
		int n;

		int count = 0;

		public UnionFind(char[][] grid) {
			m = grid.length;
			n = grid[0].length;
			father = new int[m * n];

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == '1') {
						int id = i * n + j;
						father[id] = -1;
						count++;
					}
				}
			}
		}

		public void union(int node1, int node2) {
			int x = find(node1);
			int y = find(node2);

			if (x != y) {
				father[x] = y;
				count--;
			}
		}

		public int find(int node) {
			if (father[node] == -1) {
				return node;
			}

			father[node] = find(father[node]);
			return father[node];
		}
	}
}
