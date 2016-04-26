package solution;

import java.util.Stack;

import util.TreeNode;

/*
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note: 
 You may assume k is always valid, 1 <= k <= BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementInBST {
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}

		int count = 0;
		while (!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			if (++count == k) {
				return tmp.val;
			}

			if (tmp.right != null) {
				tmp = tmp.right;
				while (tmp != null) {
					stack.push(tmp);
					tmp = tmp.left;
				}
			}
		}

		return Integer.MAX_VALUE;
	}
}
