import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 * int label;
 * ArrayList<UndirectedGraphNode> neighbors;
 * UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> nodeQueue = new LinkedList<UndirectedGraphNode>();
        HashMap<Integer, UndirectedGraphNode> nodeMap = new HashMap<Integer, UndirectedGraphNode>();
        nodeQueue.offer(node);
        nodeMap.put(head.label, head);

        while (!nodeQueue.isEmpty()) {
            UndirectedGraphNode cur = nodeQueue.poll();
            UndirectedGraphNode copyCur = nodeMap.get(cur.label);

            for (UndirectedGraphNode n : cur.neighbors) {
                if (nodeMap.containsKey(n.label)) {
                    copyCur.neighbors.add(nodeMap.get(n.label));
                } else {
                    UndirectedGraphNode newNode = new UndirectedGraphNode(n.label);
                    copyCur.neighbors.add(newNode);
                    nodeMap.put(newNode.label, newNode);
                    nodeQueue.offer(n);
                }
            }
        }
        return head;
    }
}