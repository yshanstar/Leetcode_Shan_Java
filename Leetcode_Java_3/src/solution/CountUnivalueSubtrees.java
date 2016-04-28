package solution;

import util.TreeNode;

/*
 * Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.
 */
public class CountUnivalueSubtrees {
	public int countUnivalSubtrees(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int[] count = new int[1];
		helper(root, count, root.val);

		return count[0];
	}

	private boolean helper(TreeNode node, int[] count, int value) {
		if (node == null) {
			return true;
		}

		boolean l = helper(node.left, count, node.val);
		boolean r = helper(node.right, count, node.val);

		if (l && r) {
			count[0]++;
		}

		return l && r && (node.val == value);
	}
}
