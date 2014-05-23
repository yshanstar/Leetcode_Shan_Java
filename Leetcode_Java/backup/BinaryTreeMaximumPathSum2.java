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
public class BinaryTreeMaximumPathSum2 {
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return root.val;
		}

		Sum maxSum = new Sum(Integer.MIN_VALUE);
		Sum tmpSum = new Sum(0);

		getMaxSumHelper(maxSum, tmpSum, root);

		return maxSum.val;
	}

	private void getMaxSumHelper(Sum maxSum, Sum tmpSum, TreeNode node) {
		if (node == null) {
			tmpSum = new Sum(0);
			return;
		}
		Sum leftSum = new Sum(0);
		Sum rightSum = new Sum(0);
		getMaxSumHelper(maxSum, leftSum, node.left);
		getMaxSumHelper(maxSum, rightSum, node.right);

		tmpSum.val = Math.max(node.val, Math.max(leftSum.val, rightSum.val) + node.val);
		maxSum.val = Math.max(maxSum.val, Math.max(tmpSum.val, node.val + leftSum.val + rightSum.val));
	}
}
