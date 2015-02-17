package solution;

import java.util.Stack;

import util.TreeNode;

public class BSTIterator {
	Stack<TreeNode> nodeStack;

	public BSTIterator(TreeNode root) {
		nodeStack = new Stack<TreeNode>();

		while (root != null) {
			nodeStack.push(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !nodeStack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		if (hasNext()) {
			TreeNode node = nodeStack.pop();
			int res = node.val;

			if (node.right != null) {
				node = node.right;
				while (node != null) {
					nodeStack.push(node);
					node = node.left;
				}
			}
			return res;
		} else {
			return Integer.MIN_VALUE;
		}
	}
}
