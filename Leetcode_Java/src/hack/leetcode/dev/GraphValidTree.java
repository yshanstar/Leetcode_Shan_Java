package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.List;

/*
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 For example:
 Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 */
public class GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		if (n <= 0) {
			return false;
		}

		// initialize adjacency list
		List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);

		// initialize vertices
		for (int i = 0; i < n; i++) {
			adjList.add(i, new ArrayList<Integer>());
		}

		// add edges
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0], v = edges[i][1];
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}

		boolean[] visited = new boolean[n];

		// make sure there's no cycle
		if (hasCycle(adjList, 0, visited, -1))
			return false;

		// make sure all vertices are connected
		for (int i = 0; i < n; i++) {
			if (!visited[i])
				return false;
		}

		return true;
	}

	private boolean hasCycle(List<List<Integer>> adjList, int u,
			boolean[] visited, int parent) {
		visited[u] = true;

		for (int i = 0; i < adjList.get(u).size(); i++) {
			int v = adjList.get(u).get(i);

			if ((visited[v] && parent != v)
					|| (!visited[v] && hasCycle(adjList, v, visited, u))) {
				return true;
			}
		}

		return false;
	}
	
	public static void main(String []args){
        for (int i = 0; i < 10; i++)
    	{
    		ArrayList<Integer> nums = new ArrayList<Integer>();
    		nums.add(i);
    	}

        ArrayList<Integer> nums = new ArrayList<Integer>();
     }
}
