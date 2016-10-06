package hack.leetcode.dev;

import java.util.Stack;

import hack.leetcode.ulti.TreeNode;

/*
 * Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
		int res = 0;
		if (root == null) {
			return res;
		}

		if (root.left != null) {
			TreeNode tmp = root.left;
			if (tmp.left == null && tmp.right == null) {
				res += tmp.val;
			} else {
				res += sumOfLeftLeaves(tmp);
			}
		}

		if (root.right != null) {
			res += sumOfLeftLeaves(root.right);
		}

		return res;
	}

	public int sumOfLeftLeavesIterative(TreeNode root) {
		int res = 0;
		if (root == null) {
			return res;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			if (tmp.left != null) {
				if (tmp.left.left == null && tmp.left.right == null) {
					res += tmp.left.val;
				} else {
					stack.push(tmp.left);
				}
			}

			if (tmp.right != null) {
				if (tmp.right.left != null || tmp.right.right != null) {
					stack.push(tmp.right);
				}
			}
		}

		return res;
	}
}
