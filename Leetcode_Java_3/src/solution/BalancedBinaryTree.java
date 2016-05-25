package solution;

import util.TreeNode;

/*
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {

	public boolean isBalanced2(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}

		int leftDepth = height2(root.left);
		int rightDepth = height2(root.right);

		if (Math.abs(rightDepth - leftDepth) > 1) {
			return false;
		}

		return isBalanced2(root.left) && isBalanced2(root.right);

	}

	private int height2(TreeNode node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return 1;
		}

		return Math.max(height2(node.left), height2(node.right)) + 1;
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		int leftDepth = height(root.left);
		int rightDepth = height(root.right);

		if (Math.abs(leftDepth - rightDepth) > 1) {
			return false;
		}

		return isBalanced(root.left) && isBalanced(root.right);

	}

	private int height(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		return Math.max(height(root.left), height(root.right)) + 1;
	}
}
