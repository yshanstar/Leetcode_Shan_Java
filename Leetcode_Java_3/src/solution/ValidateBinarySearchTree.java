package solution;

import util.TreeNode;

/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}

		return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
	}

	private boolean helper(TreeNode node, long high, long low) {
		if (node == null) {
			return true;
		}

		if (node.val > low && node.val < high) {
			return helper(node.left, node.val, low)
					&& helper(node.right, high, node.val);
		} else {
			return false;
		}
	}
}
