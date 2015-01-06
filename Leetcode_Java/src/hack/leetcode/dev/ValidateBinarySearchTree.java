package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

/*
 *  Given a binary tree, determine if it is a valid binary search tree (BST).
 *	Assume a BST is defined as follows:
 *	The left subtree of a node contains only nodes with keys less than the node's key.
 *	The right subtree of a node contains only nodes with keys greater than the node's key.
 *	Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValidBSTHelper(TreeNode node, int low, int high) {
		if (node == null) {
			return true;
		}
		if (node.val > low && node.val < high) {
			return isValidBSTHelper(node.left, low, node.val) && isValidBSTHelper(node.right, node.val, high);
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		ValidateBinarySearchTree test = new ValidateBinarySearchTree();
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(-1);
		n1.left = n2;

		test.isValidBST(n1);
	}
}
