package hack.leetcode.dev;

import hack.leetcode.ulti.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}

		UndirectedGraphNode head = new UndirectedGraphNode(node.label);
		Queue<UndirectedGraphNode> nodeQueue = new LinkedList<UndirectedGraphNode>();
		HashMap<Integer, UndirectedGraphNode> nodeMap = new HashMap<Integer, UndirectedGraphNode>();
		nodeQueue.offer(node);
		nodeMap.put(head.label, head);

		while (!nodeQueue.isEmpty()) {
			UndirectedGraphNode cur = nodeQueue.poll();
			UndirectedGraphNode copyCur = nodeMap.get(cur.label);
			for (UndirectedGraphNode neighbor : cur.neighbors) {
				if (nodeMap.containsKey(neighbor.label)) {
					copyCur.neighbors.add(nodeMap.get(neighbor.label));
				} else {
					UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
					copyCur.neighbors.add(newNode);
					nodeMap.put(newNode.label, newNode);
					nodeQueue.offer(neighbor);
				}
			}
		}
		return head;
	}

	public static void main(String[] args) {
		UndirectedGraphNode node = new UndirectedGraphNode(0);
		node.neighbors.add(node);
		node.neighbors.add(node);

		CloneGraph test = new CloneGraph();
		test.cloneGraph(node);
	}
}
