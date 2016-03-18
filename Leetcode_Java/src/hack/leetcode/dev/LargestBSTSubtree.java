package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

/*
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

	Note:
	A subtree must include all of its descendants.
	Here's an example:
	    10
	    / \
	   5  15
	  / \   \ 
	 1   8   7
	The Largest BST Subtree in this case is the highlighted one. 
	The return value is the subtree's size, which is 3.
 */
public class LargestBSTSubtree {
	public int largestBSTSubtree(TreeNode root) {
		return helper(root).count;
	}

	private Node helper(TreeNode root) {
		if (root == null) {
			return new Node(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		if (root.left == null && root.right == null) {
			return new Node(true, 1, root.val, root.val);
		}

		Node left = helper(root.left);
		Node right = helper(root.right);

		if (left.isBST && (left.count == 0 || left.max < root.val)
				&& right.isBST && (right.count == 0 || right.min > root.val)) {
			return new Node(true, left.count + right.count + 1, Math.max(
					root.val, right.max), Math.min(root.val, left.min));
		}

		return new Node(false, Math.max(left.count, right.count), 0, 0);
	}
}

class Node{
	boolean isBST;
	int count;
	int max;
	int min;

	public Node(boolean isBST, int count, int max, int min) {
		this.isBST = isBST;
		this.count = count;
		this.max = max;
		this.min = min;
	}
	
}
