package hack.leetcode.ulti;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DirectedGraph {
	private final Map<Integer, Vertex> graph;

	public Set<Integer> GetVertex() {
		if (graph.keySet().isEmpty()) {
			return new HashSet<Integer>();
		}

		return graph.keySet();
	}

	public Map<Integer, Vertex> GetGraph() {
		return graph;
	}

	public int GetWeight(int i, int j) {
		if (!graph.containsKey(i) || !graph.containsKey(j)) {
			return Integer.MAX_VALUE;
		}

		if (graph.get(i).neighbours.containsKey(j)) {
			return graph.get(i).neighbours.get(j);
		}

		if (graph.get(j).neighbours.containsKey(i)) {
			return graph.get(j).neighbours.get(i);
		}

		return Integer.MAX_VALUE;
	}

	public Set<Integer> GetNeighbors(int i) {
		if (!graph.containsKey(i)) {
			return new HashSet<Integer>();
		}

		return graph.get(i).neighbours.keySet();
	}

	public DirectedGraph(Edge[] edges) {

		graph = new HashMap<Integer, Vertex>(edges.length);

		// one pass to find all vertices
		for (Edge e : edges) {
			if (!graph.containsKey(e.v1))
				graph.put(e.v1, new Vertex(e.v1));
			if (!graph.containsKey(e.v2))
				graph.put(e.v2, new Vertex(e.v2));
		}

		for (Edge e : edges) {
			graph.get(e.v1).neighbours.put(e.v2, e.weight);
			graph.get(e.v2).neighbours.put(e.v1, e.weight);
		}
	}

	public static class Edge {
		public final int v1, v2;
		public final int weight;

		public Edge(int v1, int v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}
	}

	public static class Vertex {
		public int id;
		public int weight = Integer.MAX_VALUE; // MAX_VALUE assumed to be
												// infinity
		public Vertex previous = null;
		public final Map<Integer, Integer> neighbours;

		public Vertex(int id) {
			this.id = id;
			this.neighbours = new HashMap<Integer, Integer>();
		}
	}

}
