package solution;

import util.TreeNode;

public class BalancedBinaryTree {
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
