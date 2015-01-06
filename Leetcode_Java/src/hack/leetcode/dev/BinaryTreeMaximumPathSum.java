package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

/*
 *  Given a binary tree, find the maximum path sum.
 *	The path may start and end at any node in the tree.
 *	For example:
 *	Given the below binary tree,
	  1
	 / \
	2   3
 *	Return 6. 
 */
public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return root.val;
		}

		Sum maxSum = new Sum(Integer.MIN_VALUE);
		Sum tmpSum = new Sum(0);
		maxPathSumHelper(maxSum, tmpSum, root);
		return maxSum.val;
	}

	private void maxPathSumHelper(Sum maxSum, Sum tmpSum, TreeNode node) {
		if (node == null) {
			tmpSum.val = 0;
			return;
		}
		Sum leftSum = new Sum(0);
		Sum rightSum = new Sum(0);
		maxPathSumHelper(maxSum, leftSum, node.left);
		maxPathSumHelper(maxSum, rightSum, node.right);

		tmpSum.val = Math.max(node.val, Math.max(node.val + leftSum.val, node.val + rightSum.val));
		maxSum.val = Math.max(maxSum.val, Math.max(tmpSum.val, node.val + leftSum.val + rightSum.val));
	}
}

class Sum {
	int val;

	public Sum(int m) {
		this.val = m;
	}
}