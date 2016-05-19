package solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import util.UndirectedGraphNode;

/*
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:
 */
public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return node;
		}

		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);

		Queue<UndirectedGraphNode> nodeQueue = new LinkedList<UndirectedGraphNode>();
		nodeQueue.offer(node);

		Map<Integer, UndirectedGraphNode> nodeMap = new HashMap<Integer, UndirectedGraphNode>();
		nodeMap.put(newNode.label, newNode);

		while (!nodeQueue.isEmpty()) {
			UndirectedGraphNode tmpNode = nodeQueue.poll();

			UndirectedGraphNode copyNode = nodeMap.get(tmpNode.label);

			for (UndirectedGraphNode neighbor : tmpNode.neighbors) {
				if (nodeMap.containsKey(neighbor.label)) {
					copyNode.neighbors.add(nodeMap.get(neighbor.label));
				} else {
					UndirectedGraphNode tmp = new UndirectedGraphNode(neighbor.label);
					copyNode.neighbors.add(tmp);
					nodeMap.put(tmp.label, tmp);
					nodeQueue.offer(neighbor);
				}
			}

		}

		return newNode;
	}
}
