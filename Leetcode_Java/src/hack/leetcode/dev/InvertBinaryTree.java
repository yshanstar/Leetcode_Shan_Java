package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

/*
 * Invert a binary tree.

	     4
	   /   \
	  2     7
	 / \   / \
	1   3 6   9
	
	to
	     4
	   /   \
	  7     2
	 / \   / \
	9   6 3   1
 */
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return root;
		}
		
		TreeNode tmp = root.left;
		root.left = invertTree(root.right);
		root.right =  invertTree(tmp);
		
		return root;
	}
}
