package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

import java.util.ArrayList;

/*
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *  Note: 
 *  You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *  Follow up:
 *  What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementinaBST {
	public int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}

		if (root.left == null && root.right == null) {
			return root.val;
		}

		ArrayList<Integer> res = new ArrayList<Integer>();
		helper(root, res);
		return res.get(k - 1);
	}

	private void helper(TreeNode root, ArrayList<Integer> res) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			res.add(root.val);
			return;
		}

		helper(root.left, res);
		res.add(root.val);
		helper(root.right, res);
	}
}
