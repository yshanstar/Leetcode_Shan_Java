package hack.leetcode.dev;

import hack.leetcode.ulti.DirectedGraph;
import hack.leetcode.ulti.DirectedGraph.Edge;

import java.util.Arrays;
import java.util.Set;

/*
 * Dijkstra's algorithm to find shortest path from s to all other nodes
 */
public class Dijkstra {
	public int[] dijkstra(DirectedGraph G, int start) {
		if (G == null || G.GetVertex().size() == 0) {
			return new int[0];
		}

		if (!G.GetVertex().contains(start)) {
			System.out.println("Not found start point");
			return new int[0];
		}

		final int[] dist = new int[G.GetVertex().size()]; // shortest known
															// distance from
		final int[] pred = new int[G.GetVertex().size()]; // preceeding node in
															// path
		final boolean[] visited = new boolean[G.GetVertex().size()]; // all
																		// false
																		// initially

		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		dist[start] = 0;

		for (int i = 0; i < dist.length; i++) {
			int next = minVertex(dist, visited);
			if (next == -1) {
				continue;
			}
			visited[next] = true;

			Set<Integer> neighbors = G.GetNeighbors(next);
			for (Integer v : neighbors) {
				int dis = dist[next] + G.GetWeight(next, v);
				if (dist[v] > dis) {
					dist[v] = dis;
					pred[v] = next;
				}
			}

		}

		return dist;
	}

	private int minVertex(int[] dist, boolean[] visited) {
		int x = Integer.MAX_VALUE;
		int y = -1; // graph not connected, or no unvisited vertices
		for (int i = 0; i < dist.length; i++) {
			if (!visited[i] && dist[i] < x) {
				y = i;
				x = dist[i];
			}
		}
		return y;
	}

	public static void main(String[] args) {
		Edge[] GRAPH = { new Edge(0, 1, 7), new Edge(0, 2, 9),
				new Edge(0, 5, 14), new Edge(1, 2, 10), new Edge(1, 3, 15),
				new Edge(2, 3, 11), new Edge(2, 5, 2), new Edge(3, 4, 6),
				new Edge(4, 5, 9), };

		DirectedGraph G = new DirectedGraph(GRAPH);

		Dijkstra test = new Dijkstra();
		int[] dict = test.dijkstra(G, 3);

		System.out.println(Arrays.toString(dict));
	}
}
