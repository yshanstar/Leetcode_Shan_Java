package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

import java.util.Stack;

/*
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BinarySearchTreeIterator {
	Stack<TreeNode> nodeStack;

	public BinarySearchTreeIterator(TreeNode root) {
		this.nodeStack = new Stack<TreeNode>();

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
