package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

/*
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthofBinaryTree2 {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		} else {
			int leftDepth = root.left == null ? Integer.MAX_VALUE : minDepth(root.left);
			int rightDepth = root.right == null ? Integer.MAX_VALUE : minDepth(root.right);
			return Math.min(leftDepth, rightDepth) + 1;
		}
	}
}
