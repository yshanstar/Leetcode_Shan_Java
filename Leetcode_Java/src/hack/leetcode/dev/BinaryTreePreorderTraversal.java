package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/*
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
	 1
	  \
	   2
	  /
	 3
 * return [1,2,3].
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}

		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		nodeStack.push(root);

		while (!nodeStack.empty()) {
			TreeNode cur = nodeStack.pop();
			res.add(cur.val);

			if (cur.right != null) {
				nodeStack.push(cur.right);
			}

			if (cur.left != null) {
				nodeStack.push(cur.left);
			}
		}

		return res;
	}
}
