package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

/*
 * 	Given a binary tree, determine if it is height-balanced.
 *	For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		if (Math.abs(leftDepth - rightDepth) > 1) {
			return false;
		}

		return isBalanced(root.left) && isBalanced(root.right);
	}

	private int getDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
	}
}
