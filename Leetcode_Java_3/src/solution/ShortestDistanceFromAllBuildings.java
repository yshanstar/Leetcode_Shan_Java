package solution;

import java.util.LinkedList;
import java.util.Queue;

/*
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
 */
public class ShortestDistanceFromAllBuildings {
	int m;
	int n;

	int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int shortestDistance(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0] == null) {
			return -1;
		}

		m = grid.length;
		n = grid[0].length;

		int[][] reach = new int[m][n];
		int[][] dist = new int[m][n];

		int numOfBuilding = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					numOfBuilding++;
					bfs(grid, reach, dist, i, j);
				}
			}
		}

		int minLength = Integer.MAX_VALUE;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (reach[i][j] == numOfBuilding && grid[i][j] == 0) {
					minLength = Math.min(minLength, dist[i][j]);
				}
			}
		}

		return (minLength == Integer.MAX_VALUE) ? -1 : minLength;
	}

	private void bfs(int[][] grid, int[][] reach, int[][] dist, int i, int j) {
		boolean[][] visited = new boolean[m][n];
		int[][] curDist = new int[m][n];

		int step = 1;

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { i, j });

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				int[] cur = queue.poll();
				for (int[] dir : directions) {
					int ii = cur[0] + dir[0];
					int jj = cur[1] + dir[1];

					if (ii >= 0 && ii < m && jj >= 0 && jj < n && grid[ii][jj] == 0 && !visited[ii][jj]) {
						visited[ii][jj] = true;
						curDist[ii][jj] = step;
						reach[ii][jj]++;
						queue.offer(new int[] { ii, jj });
						dist[ii][jj] += curDist[ii][jj];
					}
				}
			}
			step++;
		}
	}

	public static void main(String[] args) {
		ShortestDistanceFromAllBuildings test = new ShortestDistanceFromAllBuildings();
		int[][] grid = new int[][] { { 1, 0, 2, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } };
		test.shortestDistance(grid);
	}
}
