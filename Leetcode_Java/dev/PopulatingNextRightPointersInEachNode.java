package hack.leetcode.dev;

import hack.leetcode.ulti.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Queue<TreeLinkNode> nodeQueue = new LinkedList<TreeLinkNode>();
		if (root == null) {
			return;
		} else if (root.left == null || root.right == null) {
			root.next = null;
		} else {
			goThrough(root, nodeQueue, 0);
		}
	}

	private void goThrough(TreeLinkNode node, Queue<TreeLinkNode> nodeQueue, int level) {
		if (node == null) {
			return;
		}
		nodeQueue.offer(node);
		TreeLinkNode n = null;
		TreeLinkNode pre = null;
		int count = 1;
		while ((n = nodeQueue.poll()) != null) {
			if (pre != null) {
				pre.next = n;
			}
			if (n.left != null && n.right != null) {
				nodeQueue.offer(n.left);
				nodeQueue.offer(n.right);
			}
			pre = n;
			if (count == Math.pow(2, level)) {
				n.next = null;
				pre = null;
				level++;
				count = 1;
			} else {
				count++;
			}
		}
	}

	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNode pointersInEachNode = new PopulatingNextRightPointersInEachNode();
		TreeLinkNode zero = new TreeLinkNode(0);
		TreeLinkNode one = new TreeLinkNode(1);
		TreeLinkNode two = new TreeLinkNode(2);
		TreeLinkNode three = new TreeLinkNode(3);
		TreeLinkNode four = new TreeLinkNode(4);
		TreeLinkNode five = new TreeLinkNode(5);
		TreeLinkNode six = new TreeLinkNode(6);
		zero.left = one;
		zero.right = two;
		one.left = three;
		one.right = four;
		two.left = five;
		two.right = six;
		pointersInEachNode.connect(zero);
	}
}
