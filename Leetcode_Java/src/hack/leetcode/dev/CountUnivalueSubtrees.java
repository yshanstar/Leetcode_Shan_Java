package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

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
		int[] counter = new int[1];
		count(root, counter, root.val);
		return counter[0];
	}

	private boolean count(TreeNode node, int[] counter, int val) {
		if (node == null) {
			return true;
		}
		boolean l = count(node.left, counter, node.val);
		boolean r = count(node.right, counter, node.val);

		if (l && r) {
			counter[0]++;
		}

		return l && r && node.val == val;
	}
}
