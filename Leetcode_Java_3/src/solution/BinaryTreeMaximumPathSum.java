package solution;

import util.TreeNode;

public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
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