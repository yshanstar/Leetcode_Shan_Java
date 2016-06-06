package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

/*
 * Given a binary tree, find the length of the longest consecutive sequence path.

 The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

 For example,
 1
 \
 3
 / \
 2   4
 \
 5
 Longest consecutive sequence path is 3-4-5, so return 3.
 2
 \
 3
 / 
 2    
 / 
 1
 Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class BinaryTreeLongestConsecutiveSequence {
	public int longestConsecutive(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int[] res = new int[1];

		int curLen = 0;

		helper(res, root, root, curLen);

		return res[0];
	}

	private void helper(int[] res, TreeNode parent, TreeNode node,
			int currentLength) {
		if (node == null) {
			return;
		}

		if (parent.val + 1 == node.val) {
			currentLength += 1;
		} else {
			currentLength = 1;
		}

		res[0] = Math.max(res[0], currentLength);

		helper(res, node, node.left, currentLength);
		helper(res, node, node.right, currentLength);
	}
}
