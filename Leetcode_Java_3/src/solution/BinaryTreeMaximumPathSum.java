package solution;

import util.TreeNode;

/*
 * Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

 For example:
 Given the below binary tree,

 1
 / \
 2   3
 Return 6.
 */
public class BinaryTreeMaximumPathSum {
	class Node {
		int sum;

		public Node(int v) {
			this.sum = v;
		}
	}

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return root.val;
		}

		Node maxNode = new Node(Integer.MIN_VALUE);
		Node tmp = new Node(0);

		helper(maxNode, tmp, root);

		return maxNode.sum;
	}

	private void helper(Node maxNode, Node tmpNode, TreeNode root) {
		if (root == null) {
			tmpNode.sum = 0;
			return;
		}

		Node left = new Node(0);
		Node right = new Node(0);

		helper(maxNode, left, root.left);
		helper(maxNode, right, root.right);

		tmpNode.sum = Math.max(root.val, Math.max(left.sum, right.sum) + root.val);
		maxNode.sum = Math.max(maxNode.sum, Math.max(tmpNode.sum, root.val + left.sum + right.sum));
	}

	public int maxPathSum2(TreeNode root) {
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