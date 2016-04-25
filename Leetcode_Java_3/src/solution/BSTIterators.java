package solution;

import java.util.Stack;

import util.TreeNode;

public class BSTIterators {
	Stack<TreeNode> stack;

	public BSTIterators(TreeNode root) {
		stack = new Stack<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode tmp = stack.pop();
		if (tmp.right != null) {
			TreeNode n = tmp.right;
			while (n != null) {
				stack.push(n);
				n = n.left;
			}
		}

		return tmp.val;
	}
}
