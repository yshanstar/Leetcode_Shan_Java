package hack.leetcode.dev;

import java.util.LinkedList;
import java.util.Queue;

import hack.leetcode.ulti.TreeLinkNode;

/*
 * Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.
 For example,
 Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
 After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersinEachNode2 {
	public static void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		else if (root.left == null && root.right == null) {
			root.next = null;
		}else{
			Queue<TreeLinkNode> nodeQueue = new LinkedList<TreeLinkNode>();
			Queue<TreeLinkNode> nextLevelQueue = new LinkedList<TreeLinkNode>();
			nodeQueue.add(root);
			TreeLinkNode pre = null;
			while (!nodeQueue.isEmpty()) {
				TreeLinkNode node = nodeQueue.poll();
				if (node.left != null)
					nextLevelQueue.add(node.left);
				if (node.right != null)
					nextLevelQueue.add(node.right);
				if (nodeQueue.isEmpty()) {
					if (pre != null) {
						pre.next = node;
					}
					node.next = null;
					nodeQueue = nextLevelQueue;
					nextLevelQueue = new LinkedList<TreeLinkNode>();
					pre = null;
				} else {
					if (pre == null) {
						pre = node;
					} else {
						pre.next = node;
						pre = node;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
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
		connect(zero);
	}
	
}
