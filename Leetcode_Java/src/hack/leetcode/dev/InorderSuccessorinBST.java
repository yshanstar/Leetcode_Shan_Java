package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

/*
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree, return null.
 */
public class InorderSuccessorinBST {
	TreeNode successor = null;

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null) {
			return null;
		}

		if (p.val < root.val) {
			TreeNode n = inorderSuccessor(root.left, p);
			if (n != null) {
				return n;
			}
		}

		if (successor == null) {
			if (root.val == p.val)
				successor = root;
		} else {
			return root;
		}

		return inorderSuccessor(root.right, p);
	}
}
