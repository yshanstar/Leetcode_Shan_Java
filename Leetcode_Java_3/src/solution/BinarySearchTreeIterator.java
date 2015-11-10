package solution;

import java.util.Stack;

import util.TreeNode;

/*
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BinarySearchTreeIterator {
	Stack<TreeNode> nodeStack = new Stack<TreeNode>();

	public BinarySearchTreeIterator(TreeNode root) {
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
			TreeNode next = nodeStack.pop();
			int res = next.val;
			if (next.right != null) {
				next = next.right;
				while (next != null) {
					nodeStack.push(next);
					next = next.left;
				}
			}
			return res;
		} else {
			return Integer.MIN_VALUE;
		}
	}
}
