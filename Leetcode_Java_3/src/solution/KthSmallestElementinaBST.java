package solution;

import java.util.Stack;

import util.TreeNode;

/*
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note: 
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class KthSmallestElementinaBST {
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		TreeNode cur = root;
		int n = 0;

		while (cur != null || !nodeStack.isEmpty()) {
			while (cur != null) {
				nodeStack.push(cur);
				cur = cur.left;
			}
			cur = nodeStack.pop();
			if (++n == k) {
				return cur.val;
			}
			cur = cur.right;
		}

		return Integer.MIN_VALUE;
	}
}
